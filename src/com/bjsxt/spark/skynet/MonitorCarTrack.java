package com.bjsxt.spark.skynet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.spark.conf.ConfigurationManager;
import com.bjsxt.spark.constant.Constants;
import com.bjsxt.spark.dao.ITaskDAO;
import com.bjsxt.spark.dao.factory.DAOFactory;
import com.bjsxt.spark.domain.Task;
import com.bjsxt.spark.util.DateUtils;
import com.bjsxt.spark.util.ParamUtils;
import com.bjsxt.spark.util.SparkUtils;
import com.spark.spark.test.MockData;

import scala.Tuple2;

/**
京F88622	: 0006-->0003-->0008-->0006-->0001-->0008-->0007-->0000-->0007-->0001-->0002-->0004-->0006-->0005-->0005-->0003-->0007-->0000-->0004-->0001-->0001-->0004
深E66902	: 0007-->0007-->0004-->0005-->0005-->0001-->0004-->0003-->0007
京W11471	: 0007-->0007-->0001-->0006-->0001-->0005-->0003-->0007-->0001-->0003-->0006-->0008-->0006-->0005-->0003-->0002-->0000-->0006-->0006-->0003-->0000-->0000-->0004-->0000-->0005-->0003-->0001-->0000-->0000-->0000-->0000-->0007-->0000-->0000-->0008
京C49161	: 0001-->0007-->0004-->0003-->0001-->0008-->0007-->0001-->0007-->0004-->0002-->0004-->0005-->0002-->0005-->0006-->0004-->0003-->0001-->0000-->0000-->0002-->0008-->0005-->0007-->0007-->0000

 */
public class MonitorCarTrack {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName(Constants.SPARK_APP_NAME_SESSION);
        SparkUtils.setMaster(sparkConf);

        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        SQLContext sqlContext = SparkUtils.getSQLContext(sc);

        if (ConfigurationManager.getBoolean(Constants.SPARK_LOCAL)) {
            MockData.mock(sc, sqlContext);
        } else {
            sqlContext.sql("use traffic");
        }

        long taskId = ParamUtils.getTaskIdFromArgs(args, Constants.SPARK_LOCAL_TASKID_MONITOR);
        if (taskId == 0L) {
            System.out.println("args is null");
            System.exit(-1);
        }

        ITaskDAO taskDAO = DAOFactory.getTaskDAO();
        Task task = taskDAO.findTaskById(taskId);

        if (task == null) {
            System.exit(-1);
        }
        // 处理从task表中获得的参数
        JSONObject taskParamsJsonObject = JSONObject.parseObject(task.getTaskParams());

        // 获得row类型的RDD : 2018-01-23	0001	91631	京U16332	2018-01-23 00:27:58	202	5	06
        JavaRDD<Row> cameraRDD = SparkUtils.getCameraRDDByDateRange(sqlContext, taskParamsJsonObject);
        cameraRDD.cache();

        // 获取map类型RDD: monitorID -> car       0001 : 京U16332
        JavaPairRDD<String, String> monitor2CarRDD = getMonitor2CarRDD(cameraRDD);

        // 过滤掉monitorId不等于0001的数据 0001 : 京U16332
        JavaPairRDD<String, String> filteredMonitor2CarRDD = getFilteredMonitor2CarRDD(monitor2CarRDD);

        // 去掉monitorId, 只保留car  京U16332
        JavaRDD<String> carRDD = getCarRDD(filteredMonitor2CarRDD);

        // 去重，然后获得car到集合中  [京U16332,京U16332...]
        List<String> carList = carRDD.distinct().collect();

        // 使得executor端能够获得carList
        final Broadcast<List<String>> carListBroadcast = sc.broadcast(carList);

        // print the reuslt
        // carList.forEach(System.out::println);

        // 开启另一条支线
        // 获得map类型RDD: car -> row   京U16332 : 2018-01-23	0001	91631	京U16332	2018-01-23 00:27:58	202	5	06
        JavaPairRDD<String, Row> car2RowRDD = getCar2RowRDD(cameraRDD);

        // 保留 0001卡扣下通过车辆的 信息
        JavaPairRDD<String, Row> filterCar2RowRDD = getFilteredCar2RowRDD(car2RowRDD, carListBroadcast);

        // car相同的放在一组中
        JavaPairRDD<String, Iterable<Row>> car2RowsRDD = filterCar2RowRDD.groupByKey();

        // 按时间排序，获得car -> monitor_ids   京U53611	: 0002-->0003-->0007-->0001-->0008-->0005-->0003-->0004-->0003
        JavaPairRDD<String, String> car2MonitorsRDD = getCar2MonitorsRDD(car2RowsRDD);

        // 打印结果
        car2MonitorsRDD.foreach(new VoidFunction<Tuple2<String, String>>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public void call(Tuple2<String, String> stringStringTuple2) throws Exception {
                String carId = stringStringTuple2._1;
                String track = stringStringTuple2._2;
                System.out.println(carId + "\t: " + track);
            }
        });
    }

    private static JavaPairRDD<String, String> getCar2MonitorsRDD(JavaPairRDD<String, Iterable<Row>> car2RowsRDD) {
        return car2RowsRDD.mapToPair(new PairFunction<Tuple2<String, Iterable<Row>>, String, String>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Tuple2<String, String> call(Tuple2<String, Iterable<Row>> stringIterableTuple2) throws Exception {
                String carId = stringIterableTuple2._1;
                Iterator<Row> iter = stringIterableTuple2._2.iterator();
                List<Row> rows = new ArrayList<>();
                while (iter.hasNext()) {
                    rows.add(iter.next());
                }

                Collections.sort(rows, new Comparator<Row>() {
                    @Override
                    public int compare(Row o1, Row o2) {
                        if (DateUtils.before(o1.getAs("action_time") + "", o2.getAs("action_time") + "")) {
                            return -1;
                        } else
                            return 1;
                    }
                });
                StringBuilder stringBuilder = new StringBuilder();
                for (Row row : rows) {
                    stringBuilder.append((String) row.getAs("monitor_id"));
                    stringBuilder.append("-->");
                }
                return new Tuple2<>(carId, stringBuilder.substring(0, stringBuilder.length() - 3));
            }
        });
    }

    private static JavaPairRDD<String, Row> getFilteredCar2RowRDD(JavaPairRDD<String, Row> car2RowRDD, final Broadcast<List<String>> carListBroadcast) {
        return car2RowRDD.filter(new Function<Tuple2<String, Row>, Boolean>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Boolean call(Tuple2<String, Row> v1) throws Exception {
                String carId = v1._1;
                List<String> carList = carListBroadcast.value();
                return carList.contains(carId);
            }
        });
    }

    private static JavaPairRDD<String, Row> getCar2RowRDD(JavaRDD<Row> cameraRDD) {
        return cameraRDD.mapToPair(new PairFunction<Row, String, Row>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Tuple2<String, Row> call(Row row) throws Exception {
                return new Tuple2<>((String) row.getAs("car"), row);
            }
        });
    }

    private static JavaRDD<String> getCarRDD(JavaPairRDD<String, String> monitor2CarRDD) {
        return monitor2CarRDD.map(new Function<Tuple2<String, String>, String>() {
            private static final long serialVersionUID = 1L;

            @Override
            public String call(Tuple2<String, String> v1) throws Exception {
                return v1._2;
            }
        });
    }

    private static JavaPairRDD<String, String> getFilteredMonitor2CarRDD(JavaPairRDD<String, String> monitor2CarRDD) {
        return monitor2CarRDD.filter(new Function<Tuple2<String, String>, Boolean>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Boolean call(Tuple2<String, String> v1) throws Exception {
                return v1._1.equals("0001");
            }
        });
    }

    private static JavaPairRDD<String, String> getMonitor2CarRDD(JavaRDD<Row> cameraRDD) {
        JavaPairRDD<String, String> monitor2CarRDD = cameraRDD.mapToPair(new PairFunction<Row, String, String>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Tuple2<String, String> call(Row row) throws Exception {
                return new Tuple2<>((String) row.getAs("monitor_id"), (String) row.getAs("car"));
            }
        });
        return monitor2CarRDD;
    }
}
