package com.bjsxt.spark.util;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.spark.conf.ConfigurationManager;
import com.bjsxt.spark.constant.Constants;
import com.spark.spark.test.MockData;
 

/**
 * Spark工具类
 * @author Administrator
 *
 */
public class SparkUtils {
	
	/**
	 * 根据当前是否本地测试的配置，决定 如何设置SparkConf的master
	 */
	public static void setMaster(SparkConf conf) {
		boolean local = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);
		if(local) {
			conf.setMaster("local");  
		}
	}
	
	/**
	 * 获取SQLContext
	 * 如果spark.local设置为true，那么就创建SQLContext；否则，创建HiveContext
	 * @param sc
	 * @return
	 */
	public static SQLContext getSQLContext(JavaSparkContext sc) {
		boolean local = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);
		if(local) {
			return new SQLContext(sc);
		} else {
			return new HiveContext(sc);
		}
	}
	
	/**
	 * 生成模拟数据
	 * 如果spark.local配置设置为true，则生成模拟数据；否则不生成
	 * @param sc
	 * @param sqlContext
	 */
	public static void mockData(JavaSparkContext sc, SQLContext sqlContext) {
		boolean local = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);
		/**
		 * 如何local为true  说明在本地测试  应该生产模拟数据    RDD-》DataFrame-->注册成临时表0
		 * false    HiveContext  直接可以操作hive表
		 */
		if(local) {
			MockData.mock(sc, sqlContext);  
		}
	}
	
	/**
	 * 获取指定日期范围内的卡口信息
	 * @param sqlContext
	 * @param taskParamsJsonObject
	 */
	public static JavaRDD<Row> getCameraRDDByDateRange(SQLContext sqlContext, JSONObject taskParamsJsonObject) {
		String startDate = ParamUtils.getParam(taskParamsJsonObject, Constants.PARAM_START_DATE);
		String endDate = ParamUtils.getParam(taskParamsJsonObject, Constants.PARAM_END_DATE);
		String sql = 
				"SELECT * "
				+ "FROM monitor_flow_action "
				+ "WHERE date>='" + startDate + "' "
				+ "AND date<='" + endDate + "'";  
		
		DataFrame monitorDF = sqlContext.sql(sql);
		/**
		 * repartition可以提高stage的并行度
		 */
//		return actionDF.javaRDD().repartition(1000);
		return monitorDF.javaRDD();   
	}
	
	/**
	 * 获取指定日期内出现指定车辆的卡扣信息
	 * @param sqlContext
	 * @param taskParamsJsonObject
	 * @return JavaRDD<Row>
	 */
	public static JavaRDD<Row> getCameraRDDByDateRangeAndCars(SQLContext sqlContext, JSONObject taskParamsJsonObject) {
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
			if(i < carArr.length - 1){
				sql += ",";
			}
		}
		sql += ")";
		
		System.out.println("sql:"+sql);
		DataFrame monitorDF = sqlContext.sql(sql);
		
		/**
		 * repartition可以提高stage的并行度
		 */
//		return actionDF.javaRDD().repartition(1000);
		
		return monitorDF.javaRDD();
	}
	
	/*****************************************************/
	/**
	 * 获取指定日期范围和指定区域范围内的卡口信息
	 * @param sqlContext
	 * @param taskParamsJsonObject 传过来的json对象
	 * @param a 区域
	 */
	public static JavaRDD<Row> getCameraRDDByDateRangeAndArea(SQLContext sqlContext, JSONObject taskParamsJsonObject,String a) {
		String startDate = ParamUtils.getParam(taskParamsJsonObject, Constants.PARAM_START_DATE);
		String endDate = ParamUtils.getParam(taskParamsJsonObject, Constants.PARAM_END_DATE);
		
		String sql = 
				"SELECT * "
				+ "FROM monitor_flow_action "
				+ "WHERE date>='" + startDate + "' "
				+ "AND date<='" + endDate + "'"
				+ "AND area_id in ('"+a +"')";  
		
		DataFrame monitorDF = sqlContext.sql(sql);
		monitorDF.show();
		/**
		 * repartition可以提高stage的并行度
		 */
//		return actionDF.javaRDD().repartition(1000);
		return monitorDF.javaRDD();   
	}
	
}
