package com.traffic.spark.util;

import com.alibaba.fastjson.JSONObject;
import com.traffic.load.data.MockData;
import com.traffic.spark.conf.ConfigurationManager;
import com.traffic.spark.constant.Constants;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;


/**
 * Spark工具类
 */
public class SparkUtils {

    /**
     * 根据当前是否本地测试的配置，决定 如何设置SparkConf的master
     */
//	public static void setMaster(SparkConf conf) {
//		boolean local = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);
//		if(local) {
//			conf.setMaster("local");
//		}
//	}

    /**
     * 获取SQLContext
     * 如果spark.local设置为true，那么就创建SQLContext；否则，创建HiveContext
     */
//	public static SparkSession getSQLContext(JavaSparkContext sc) {
//		boolean local = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);
//		if(local) {
//			//如果SparkContext已经存在，SparkSession就会重用它，如果不存在，Spark就会创建一个新的SparkContext
//			SparkSession.builder().getOrCreate();
//			return SparkSession.builder().getOrCreate();
//		} else {
//			System.out.println("++++++++++++++++++++++++++++++++++++++开启hive的支持");
//			/**
//			 * "SELECT * FROM table1 join table2 ON (连接条件)"  如果某一个表小于20G 他会自动广播出去
//			 * 会将小于spark.sql.autoBroadcastJoinThreshold值（默认为10M）的表广播到executor节点，不走shuffle过程,更加高效。
//			 *
//			 * config("spark.sql.autoBroadcastJoinThreshold", "1048576000");  //单位：字节
//			 */
//			return SparkSession.builder().config("spark.sql.autoBroadcastJoinThreshold", "1048576000").enableHiveSupport().getOrCreate();
//		}
//	}

    /**
     * 生成模拟数据
     * 如果spark.local配置设置为true，则生成模拟数据；否则不生成
     */
    public static void mockData(JavaSparkContext sc, SparkSession spark) {
        boolean local = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);
        /**
         * 如何local为true  说明在本地测试  应该生产模拟数据    RDD-》DataFrame-->注册成临时表0
         * false    HiveContext  直接可以操作hive表
         */
        if (local) {
            MockData.mock(sc, spark);
        }
    }

    /**
     * 获取指定日期范围内的卡口信息
     */
    public static JavaRDD<Row> getCameraRDDByDateRange(SparkSession spark, JSONObject taskParamsJsonObject) {
        String startDate = ParamUtils.getParam(taskParamsJsonObject, Constants.PARAM_START_DATE);
        String endDate = ParamUtils.getParam(taskParamsJsonObject, Constants.PARAM_END_DATE);
        String sql =
                "SELECT * "
                        + "FROM monitor_flow_action "
                        + "WHERE date>='" + startDate + "' "
                        + "AND date<='" + endDate + "'";

        Dataset<Row> monitorDF = spark.sql(sql);
        /**
         * repartition可以提高stage的并行度
         */
//		return actionDF.javaRDD().repartition(1000);
        return monitorDF.javaRDD();
    }

    /**
     * 获取指定日期内出现指定车辆的卡扣信息
     */
    public static JavaRDD<Row> getCameraRDDByDateRangeAndCars(SparkSession spark, JSONObject taskParamsJsonObject) {
        String startDate = ParamUtils.getParam(taskParamsJsonObject, Constants.PARAM_START_DATE);
        String endDate = ParamUtils.getParam(taskParamsJsonObject, Constants.PARAM_END_DATE);
        String cars = ParamUtils.getParam(taskParamsJsonObject, Constants.FIELD_CARS);
        String[] carArr = cars.split(",");
        String sql =
                "SELECT * "
                        + "FROM monitor_flow_action "
                        + "WHERE date>='" + startDate + "' "
                        + "AND date<='" + endDate + "' "
                        + "AND car IN (";

        for (int i = 0; i < carArr.length; i++) {
            sql += "'" + carArr[i] + "'";
            if (i < carArr.length - 1) {
                sql += ",";
            }
        }
        sql += ")";

        System.out.println("sql:" + sql);
        Dataset<Row> monitorDF = spark.sql(sql);

        /**
         * repartition可以提高stage的并行度
         */
//		return actionDF.javaRDD().repartition(1000);

        return monitorDF.javaRDD();
    }

    /*****************************************************/
    /**
     * 获取指定日期范围和指定区域范围内的卡口信息
     */
    public static JavaRDD<Row> getCameraRDDByDateRangeAndArea(SparkSession spark, JSONObject taskParamsJsonObject, String a) {
        String startDate = ParamUtils.getParam(taskParamsJsonObject, Constants.PARAM_START_DATE);
        String endDate = ParamUtils.getParam(taskParamsJsonObject, Constants.PARAM_END_DATE);

        String sql =
                "SELECT * "
                        + "FROM monitor_flow_action "
                        + "WHERE date>='" + startDate + "' "
                        + "AND date<='" + endDate + "'"
                        + "AND area_id in ('" + a + "')";
        Dataset<Row> monitorDF = spark.sql(sql);
        monitorDF.show();
        /**
         * repartition可以提高stage的并行度
         */
//		return actionDF.javaRDD().repartition(1000);
        return monitorDF.javaRDD();
    }

}
