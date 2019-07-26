package com.traffic.spark.arearoadflow;

import com.alibaba.fastjson.JSONObject;
import com.traffic.load.data.MockData;
import com.traffic.spark.conf.ConfigurationManager;
import com.traffic.spark.constant.Constants;
import com.traffic.spark.dao.ITaskDAO;
import com.traffic.spark.dao.factory.DAOFactory;
import com.traffic.spark.domain.Task;
import com.traffic.spark.util.DateUtils;
import com.traffic.spark.util.NumberUtils;
import com.traffic.spark.util.ParamUtils;
import com.traffic.spark.util.SparkUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.*;
import java.util.Map.Entry;

/**
 * 卡扣流
 * monitor_id   1 2 3 4      1_2 2_3 3_4
 * 指定一个道路流  1 2 3 4
 * 1 carCount1 2carCount2  转化率 carCount2/carCount1
 * 1 2 3  转化率                           1 2 3的车流量/1 2的车流量
 * 1 2 3 4 转化率       1 2 3 4的车流量 / 1 2 3 的车流量
 * 京A1234	1,2,3,6,2,3
 * 1、查询出来的数据封装到cameraRDD
 * 2、计算每一车的轨迹
 * 3、匹配指定的道路流       1：carCount   1，2：carCount   1,2,3carCount
 *
 * @author root
 */
public class MonitorOneStepConvertRateAnalyze {
    public static void main(String[] args) {

        /**
         * 判断应用程序是否在本地执行
         */
        JavaSparkContext sc = null;
        SparkSession spark = null;
        Boolean onLocal = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);

        if (onLocal) {
            // 构建Spark运行时的环境参数
            SparkConf conf = new SparkConf()
                    .setAppName(Constants.SPARK_APP_NAME)
//			.set("spark.sql.shuffle.partitions", "300")
//			.set("spark.default.parallelism", "100")
//			.set("spark.storage.memoryFraction", "0.5")
//			.set("spark.shuffle.consolidateFiles", "true")
//			.set("spark.shuffle.file.buffer", "64")
//			.set("spark.shuffle.memoryFraction", "0.3")
//			.set("spark.reducer.maxSizeInFlight", "96")
//			.set("spark.shuffle.io.maxRetries", "60")
//			.set("spark.shuffle.io.retryWait", "60")
//			.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
//			.registerKryoClasses(new Class[]{SpeedSortKey.class})
                    ;
            /**
             * 设置spark运行时的master  根据配置文件来决定的
             */
            conf.setMaster("local");
            sc = new JavaSparkContext(conf);

            spark = SparkSession.builder().getOrCreate();
            /**
             * 基于本地测试生成模拟测试数据，如果在集群中运行的话，直接操作Hive中的表就可以
             * 本地模拟数据注册成一张临时表
             * monitor_flow_action	数据表：监控车流量所有数据
             * monitor_camera_info	标准表：卡扣对应摄像头标准表
             */
            MockData.mock(sc, spark);
        } else {
            System.out.println("++++++++++++++++++++++++++++++++++++++开启hive的支持");
            /**
             * "SELECT * FROM table1 join table2 ON (连接条件)"  如果某一个表小于20G 他会自动广播出去
             * 会将小于spark.sql.autoBroadcastJoinThreshold值（默认为10M）的表广播到executor节点，不走shuffle过程,更加高效。
             *
             * config("spark.sql.autoBroadcastJoinThreshold", "1048576000");  //单位：字节
             */
            spark = SparkSession.builder().config("spark.sql.autoBroadcastJoinThreshold", "1048576000").enableHiveSupport().getOrCreate();
            spark.sql("use traffic");
        }

//			// 1、构造Spark上下文
//			SparkConf conf = new SparkConf().setAppName(Constants.SPARK_APP_NAME);
//			SparkUtils.setMaster(conf);
//
//			JavaSparkContext sc = new JavaSparkContext(conf);
//			SparkSession spark = SparkUtils.getSQLContext(sc);
//
//			// 2、生成模拟数据
//			SparkUtils.mockData(sc, spark);

        // 3、查询任务，获取任务的参数
        long taskid = ParamUtils.getTaskIdFromArgs(args, Constants.SPARK_LOCAL_TASKID_MONITOR_ONE_STEP_CONVERT);

        ITaskDAO taskDAO = DAOFactory.getTaskDAO();
        Task task = taskDAO.findTaskById(taskid);
        if (task == null) {
            return;
        }
        JSONObject taskParam = JSONObject.parseObject(task.getTaskParams());

        /**
         * 从数据库中查找出来我们指定的卡扣流
         * 0001,0002,0003,0004,0005
         */
        String roadFlow = ParamUtils.getParam(taskParam, Constants.PARAM_MONITOR_FLOW);
        final Broadcast<String> roadFlowBroadcast = sc.broadcast(roadFlow);

        /**
         * 通过时间的范围拿到合法的车辆
         */
        JavaRDD<Row> rowRDDByDateRange = SparkUtils.getCameraRDDByDateRange(spark, taskParam);
        /**
         * 将rowRDDByDateRange 变成key-value对的形式，key car value 详细信息
         * （key,row）
         * 为什么要变成k v对的形式？
         * 因为下面要对car 按照时间排序，绘制出这辆车的轨迹。
         */
        JavaPairRDD<String, Row> car2RowRDD = getCar2RowRDD(rowRDDByDateRange);

        /**
         * 计算这一辆车，有多少次匹配到我们指定的卡扣流
         *
         * 先拿到车辆的轨迹，比如一辆车轨迹：0001,0002,0003,0004,0001,0002,0003,0001,0004
         * 返回一个二元组（切分的片段，该片段对应的该车辆轨迹中匹配上的次数）
         * ("0001",3)
         * ("0001,0002",2)
         * ("0001,0002,0003",2)
         * ("0001,0002,0003,0004",1)
         * ("0001,0002,0003,0004,0005",0)
         * ... ...
         * ("0001",13)
         * ("0001,0002",12)
         * ("0001,0002,0003",11)
         * ("0001,0002,0003,0004",11)
         * ("0001,0002,0003,0004,0005",10)
         */
        JavaPairRDD<String, Long> roadSplitRDD = generateAndMatchRowSplit(taskParam, roadFlowBroadcast, car2RowRDD);

        /**
         * roadSplitRDD
         * 所有的相同的key先聚合得到总数
         * ("0001",100)
         * ("0001,0002",200)
         * ("0001,0002,0003",300)
         * ("0001,0002,0003,0004",400)
         * ("0001,0002,0003,0004,0005",500)
         * 变成了一个 K,V格式的map
         * ("0001",500)
         * ("0001,0002",400)
         * ("0001,0002,0003",300)
         * ("0001,0002,0003,0004",200)
         * ("0001,0002,0003,0004,0005",100)
         */
        Map<String, Long> roadFlow2Count = getRoadFlowCount(roadSplitRDD);

        Map<String, Double> convertRateMap = computeRoadSplitConvertRate(roadFlow, roadFlow2Count);

        for (Entry<String, Double> entry : convertRateMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    private static Map<String, Long> getRoadFlowCount(JavaPairRDD<String, Long> roadSplitRDD) {

        JavaPairRDD<String, Long> sumByKey = roadSplitRDD.reduceByKey(new Function2<Long, Long, Long>() {

            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public Long call(Long v1, Long v2) throws Exception {
                return v1 + v2;
            }
        });

        /**
         * ("0001",3)
         * ("0001,0002",2)
         * ("0001,0002,0003",2)
         * ("0001,0002,0003,0004",1)
         * ("0001,0002,0003,0004,0005",0)
         * 转换成Map出去
         */
//		Map<String, Long> map = new HashMap<>();
//		List<Tuple2<String, Long>> results = sumByKey.collect();
//		for (Tuple2<String, Long> tuple : results) {
//			map.put(tuple._1, tuple._2);
//		}
        Map<String, Long> map = sumByKey.collectAsMap();
        return map;
    }

    /**
     * @param roadFlow
     * @param splitCountMap
     * @return Map<String, Double>
     */
    private static Map<String, Double> computeRoadSplitConvertRate(String roadFlow, Map<String, Long> splitCountMap) {
        //0001，0002，0003，0004，0005
        String[] split = roadFlow.split(",");
//		List<String> roadFlowList = Arrays.asList(split);
        /**
         * 存放卡扣切面的转换率
         * "0001,0002" 0.16
         */
        Map<String, Double> rateMap = new HashMap<>();
        long lastMonitorCarCount = 0L;
        String tmpRoadFlow = "";
        for (int i = 0; i < split.length; i++) {
            tmpRoadFlow += "," + split[i];
            Long count = splitCountMap.get(tmpRoadFlow.substring(1));
            if (count != 0L) {
                /**
                 * 1_2
                 * lastMonitorCarCount      1 count
                 */
                if (i != 0 && lastMonitorCarCount != 0L) {
                    double rate = NumberUtils.formatDouble((double) count / (double) lastMonitorCarCount, 2);
                    rateMap.put(tmpRoadFlow.substring(1), rate);
                }
                lastMonitorCarCount = count;
            }
        }
        return rateMap;
    }

    /**
     * car2RowRDD car   row详细信息
     * 按照通过时间进行排序，拿到他的轨迹
     *
     * @param taskParam
     * @param roadFlowBroadcast ---- 0001,0002,0003,0004,0005
     * @param car2RowRDD
     * @return 二元组(切分的片段 ， 该片段在本次车辆轨迹中出现的总数)
     */
    private static JavaPairRDD<String, Long> generateAndMatchRowSplit(JSONObject taskParam,
                                                                      final Broadcast<String> roadFlowBroadcast, JavaPairRDD<String, Row> car2RowRDD) {
        return car2RowRDD.groupByKey().flatMapToPair(new PairFlatMapFunction<Tuple2<String, Iterable<Row>>, String, Long>() {

            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public Iterator<Tuple2<String, Long>> call(Tuple2<String, Iterable<Row>> tuple) throws Exception {
                String car = tuple._1;
                Iterator<Row> iterator = tuple._2.iterator();
                List<Tuple2<String, Long>> list = new ArrayList<>();

                List<Row> rows = new ArrayList<>();
                /**
                 * 遍历的这一辆车的所有的详细信息，然后将详细信息放入到rows集合中
                 */
                while (iterator.hasNext()) {
                    Row row = iterator.next();
                    rows.add(row);
                }

                /**
                 * 对这个rows集合 按照车辆通过卡扣的时间排序
                 */
                Collections.sort(rows, new Comparator<Row>() {

                    @Override
                    public int compare(Row row1, Row row2) {
                        String actionTime1 = row1.getString(4);
                        String actionTime2 = row2.getString(4);
                        if (DateUtils.after(actionTime1, actionTime2)) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                });

                /**
                 * roadFlowBuilder保存到是本次车辆的轨迹是一组逗号分开的卡扣id，组合起来就是这辆车的运行轨迹
                 */
                StringBuilder roadFlowBuilder = new StringBuilder();

                /**
                 * roadFlowBuilder怎么拼起来的？  rows是由顺序了，直接遍历然后追加到roadFlowBuilder就可以了吧。
                 * row.getString(1) ---- monitor_id
                 */
                for (Row row : rows) {
                    roadFlowBuilder.append("," + row.getString(1));
                }
                /**
                 * roadFlowBuilder这里面的开头有一个逗号， 去掉逗号。
                 * roadFlow是本次车辆的轨迹
                 */
                String carTracker = roadFlowBuilder.toString().substring(1);
                /**
                 *  从广播变量中获取指定的卡扣流参数
                 *  0001,0002,0003,0004,0005
                 */
                String standardRoadFlow = roadFlowBroadcast.value();

                /**
                 * 对指定的卡扣流参数分割
                 */
                String[] split = standardRoadFlow.split(",");

                /**
                 * [0001,0002,0003,0004,0005]
                 * 1 2 3 4 5
                 * 遍历分割完成的数组
                 */
                for (int i = 1; i <= split.length; i++) {
                    //临时组成的卡扣切片  1,2 1,2,3
                    String tmpRoadFlow = "";
                    /**
                     * 第一次进来：,0001
                     * 第二次进来：,0001,0002
                     */
                    for (int j = 0; j < i; j++) {
                        tmpRoadFlow += "," + split[j];//,0001
                    }
                    tmpRoadFlow = tmpRoadFlow.substring(1);//去掉前面的逗号     0001

                    //indexOf 从哪个位置开始查找
                    int index = 0;
                    //这辆车有多少次匹配到这个卡扣切片的次数
                    Long count = 0L;

                    while (carTracker.indexOf(tmpRoadFlow, index) != -1) {
                        index = carTracker.indexOf(tmpRoadFlow, index) + 1;
                        count++;
                    }
                    list.add(new Tuple2<String, Long>(tmpRoadFlow, count));
                }
                return list.iterator();
            }
        });
    }

    private static JavaPairRDD<String, Row> getCar2RowRDD(JavaRDD<Row> car2RowRDD) {
        return car2RowRDD.mapToPair(new PairFunction<Row, String, Row>() {

            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public Tuple2<String, Row> call(Row row) throws Exception {
                return new Tuple2<String, Row>(row.getString(3), row);
            }
        });
    }
}
