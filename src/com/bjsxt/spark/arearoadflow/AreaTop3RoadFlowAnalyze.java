package com.bjsxt.spark.arearoadflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.spark.conf.ConfigurationManager;
import com.bjsxt.spark.constant.Constants;
import com.bjsxt.spark.dao.ITaskDAO;
import com.bjsxt.spark.dao.factory.DAOFactory;
import com.bjsxt.spark.domain.Task;
import com.bjsxt.spark.util.ParamUtils;
import com.bjsxt.spark.util.SparkUtils;

import scala.Tuple2;

/**
 * 计算出每一个区域top3的道路流量
 * 	每一个区域车流量最多的3条道路   每条道路有多个卡扣
 * @author root
 * ./spark-submit 
 * 	--master spark://node1:7077 	
 * 	--jars ../lib/mysql-connector-java-5.1.6.jar,../lib/fastjson-1.2.11.jar 
 * 	--driver-class-path ../lib/mysql-connector-java-5.1.6.jar:../lib/fastjson-1.2.11.jar 
 * 	../lib/Test.jar 4 
 * 
 * 这是一个分组取topN  SparkSQL分组取topN 
 * 区域，道路流量排序         按照区域和道路进行分组  
 * 
 */
public class AreaTop3RoadFlowAnalyze {
	public static void main(String[] args) {
		// 创建SparkConf
		SparkConf conf = new SparkConf()
				.setAppName("AreaTop3ProductSpark")
				.set("spark.sql.shuffle.partitions", "1");
		SparkUtils.setMaster(conf); 
		
		// 构建Spark上下文
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext sqlContext = SparkUtils.getSQLContext(sc);
		/**
		 * "SELECT * FROM table1 join table2 ON (连接条件)"  如果某一个表小于20G 他会自动广播出去
		 * 会将小于spark.sql.autoBroadcastJoinThreshold值（默认为10M）的表广播到executor节点，不走shuffle过程,更加高效。
		 */
//			sqlContext.setConf("spark.sql.autoBroadcastJoinThreshold", "1048576000");  //单位：字节
				
				
		// 注册自定义函数
		sqlContext.udf().register("concat_String_string", new ConcatStringStringUDF(), DataTypes.StringType);
		sqlContext.udf().register("random_prefix", new RandomPrefixUDF(), DataTypes.StringType);
		sqlContext.udf().register("remove_random_prefix", new RemoveRandomPrefixUDF(), DataTypes.StringType); 
		
		sqlContext.udf().register("group_concat_distinct",new GroupConcatDistinctUDAF());
		
		
		// 准备模拟数据
		SparkUtils.mockData(sc, sqlContext);  
		
		// 获取命令行传入的taskid，查询对应的任务参数
		ITaskDAO taskDAO = DAOFactory.getTaskDAO();
		
		long taskid = ParamUtils.getTaskIdFromArgs(args,Constants.SPARK_LOCAL_TASKID_TOPN_MONITOR_FLOW);
		Task task = taskDAO.findTaskById(taskid);
		 if(task == null){
			 return ;
		 }
		 System.out.println("task.getTaskParams()----"+task.getTaskParams());
		 JSONObject taskParam = JSONObject.parseObject(task.getTaskParams());
		 
		 /**
		  * 获取指定日期内的参数
		  * (areaId,row)
		  */
		 JavaPairRDD<String, Row> areaId2DetailInfos = getInfosByDateRDD(sqlContext,taskParam);
						 
		 /**
		  * 从异构数据源MySQL中获取区域信息
		  * area_id	area_name
		  * areaId2AreaInfoRDD<area_id,area_name:区域名称>
		  */
		 JavaPairRDD<String, String> areaId2AreaInfoRDD = getAreaId2AreaInfoRDD(sqlContext);
		
		 /**
		  * 补全区域信息    添加区域名称
		  * 	monitor_id car road_id	area_id	area_name 
		  * 生成基础临时信息表
		  * 	tmp_car_flow_basic
		  * 
		  * 将符合条件的所有的数据得到对应的中文区域名称 ，然后动态创建Schema的方式，将这些数据注册成临时表tmp_car_flow_basic
		  */
		 generateTempRoadFlowBasicTable(sqlContext,areaId2DetailInfos,areaId2AreaInfoRDD);
		 
		 /**
		  * 统计各个区域各个路段车流量的临时表
		  * 
		  * area_name  road_id    car_count      monitor_infos
		  *   海淀区		  01		 100	  0001=20|0002=30|0003=50
		  * 
		  * 注册成临时表tmp_area_road_flow_count
		  */
		 generateTempAreaRoadFlowTable(sqlContext);
		 
		 /**
		  *  area_name
		  *	 road_id
		  *	 count(*) car_count
		  *	 monitor_infos   
		  * 使用开窗函数  获取每一个区域的topN路段
		  */
		getAreaTop3RoadFolwRDD(sqlContext);
		System.out.println("***********ALL FINISHED*************");
		sc.close();
	}

	@SuppressWarnings("unused")
	private static JavaRDD<Row> getAreaTop3RoadFolwRDD(SQLContext sqlContext) {
		/**
		 * tmp_area_road_flow_count表：
		 * 		area_name
		 * 		road_id
		 * 		car_count
		 * 		monitor_infos
		 */
		String sql = ""
				+ "SELECT "
					+ "area_name,"
					+ "road_id,"
					+ "car_count,"
					+ "monitor_infos, "
					+ "CASE "
						+ "WHEN car_count > 170 THEN 'A LEVEL' "
						+ "WHEN car_count > 160 AND car_count <= 170 THEN 'B LEVEL' "
						+ "WHEN car_count > 150 AND car_count <= 160 THEN 'C LEVEL' "
						+ "ELSE 'D LEVEL' "
					+"END flow_level "
				+ "FROM ("
					+ "SELECT "
						+ "area_name,"
						+ "road_id,"
						+ "car_count,"
						+ "monitor_infos,"
						+ "row_number() OVER (PARTITION BY area_name ORDER BY car_count DESC) rn "
					+ "FROM tmp_area_road_flow_count "
					+ ") tmp "
				+ "WHERE rn <=3"; 
		DataFrame df = sqlContext.sql(sql);
		System.out.println("--------最终的结果-------");
		df.show();
		//存入Hive中，要有result 这个database库
		sqlContext.sql("use result");
		sqlContext.sql("drop table if exists result.areaTop3Road");
		df.write().saveAsTable("areaTop3Road");
		return df.javaRDD();
	}

	private static void generateTempAreaRoadFlowTable(SQLContext sqlContext) {
		/**
		 * 	structFields.add(DataTypes.createStructField("area_id", DataTypes.StringType, true));  
		 *	structFields.add(DataTypes.createStructField("area_name", DataTypes.StringType, true));
		 *	structFields.add(DataTypes.createStructField("road_id", DataTypes.StringType, true));
		 *	structFields.add(DataTypes.createStructField("monitor_id", DataTypes.StringType, true));  
		 *	structFields.add(DataTypes.createStructField("car", DataTypes.StringType, true));  
		 */
		String sql = 
				"SELECT "
				    + "area_name,"
					+ "road_id,"
					+ "count(*) car_count,"
					//group_concat_distinct 统计每一条道路中每一个卡扣下的车流量
					+ "group_concat_distinct(monitor_id) monitor_infos "//0001=20|0002=30
				+ "FROM tmp_car_flow_basic "
				+ "GROUP BY area_name,road_id";
		/**
		 * 下面是当遇到区域下某个道路车辆特别多的时候，会有数据倾斜，怎么处理？random
		 */
	 	String sqlText = ""
				+ "SELECT "
					+ "area_name_road_id,"
					+ "sum(car_count),"
					+ "group_concat_distinct(monitor_infos) monitor_infoss "
				+ "FROM ("
					+ "SELECT "
						+ "remove_random_prefix(prefix_area_name_road_id) area_name_road_id,"
						+ "car_count,"
						+ "monitor_infos "
					+ "FROM ("
						+ "SELECT "
							+ "prefix_area_name_road_id,"//1_海淀区:49
							+ "count(*) car_count,"
							+ "group_concat_distinct(monitor_id) monitor_infos "
						+ "FROM ("
							+ "SELECT "
							+ "monitor_id,"
							+ "car,"
							+ "random_prefix(concat_String_string(area_name,road_id,':'),10) prefix_area_name_road_id "
							+ "FROM tmp_car_flow_basic "
						+ ") t1 "
						+ "GROUP BY prefix_area_name_road_id "
					+ ") t2 "
				+ ") t3 "
				+ "GROUP BY area_name_road_id"; 
		
		
		DataFrame df = sqlContext.sql(sql);		
	
//		df.show();
		df.registerTempTable("tmp_area_road_flow_count"); 
	}

	/**
	 * 获取符合条件数据对应的区域名称，并将这些信息注册成临时表 tmp_car_flow_basic 
	 * @param sqlContext
	 * @param areaId2DetailInfos
	 * @param areaId2AreaInfoRDD
	 */
	private static void generateTempRoadFlowBasicTable(SQLContext sqlContext, 
			JavaPairRDD<String, Row> areaId2DetailInfos, JavaPairRDD<String, String> areaId2AreaInfoRDD) {
		
		JavaRDD<Row> tmpRowRDD = areaId2DetailInfos.join(areaId2AreaInfoRDD).map(
				new Function<Tuple2<String,Tuple2<Row,String>>, Row>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Row call(Tuple2<String, Tuple2<Row, String>> tuple) throws Exception {
				String areaId = tuple._1;
				Row carFlowDetailRow = tuple._2._1;
				String areaName = tuple._2._2;
				
				String roadId = carFlowDetailRow.getString(2);
				String monitorId = carFlowDetailRow.getString(0);
				String car = carFlowDetailRow.getString(1);
				
				
				return RowFactory.create(areaId, areaName, roadId, monitorId,car); 
			}
		});
		
		List<StructField> structFields = new ArrayList<StructField>();
		structFields.add(DataTypes.createStructField("area_id", DataTypes.StringType, true));  
		structFields.add(DataTypes.createStructField("area_name", DataTypes.StringType, true));
		structFields.add(DataTypes.createStructField("road_id", DataTypes.StringType, true));
		structFields.add(DataTypes.createStructField("monitor_id", DataTypes.StringType, true));  
		structFields.add(DataTypes.createStructField("car", DataTypes.StringType, true));  
	 
		
		StructType schema = DataTypes.createStructType(structFields);
		
		DataFrame df = sqlContext.createDataFrame(tmpRowRDD, schema);
		
		df.registerTempTable("tmp_car_flow_basic");
		
	}
	
	private static JavaPairRDD<String, String> getAreaId2AreaInfoRDD(SQLContext sqlContext) {
				String url;
				String user ;
				String password;
				boolean local = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);
				//获取Mysql数据库的url,user,password信息
				if(local) {
					url = ConfigurationManager.getProperty(Constants.JDBC_URL);
					user = ConfigurationManager.getProperty(Constants.JDBC_USER);
					password = ConfigurationManager.getProperty(Constants.JDBC_PASSWORD);
				} else {
					url = ConfigurationManager.getProperty(Constants.JDBC_URL_PROD);
					user = ConfigurationManager.getProperty(Constants.JDBC_USER_PROD);
					password = ConfigurationManager.getProperty(Constants.JDBC_PASSWORD_PROD);
				}
				
				Map<String, String> options = new HashMap<String, String>();
				options.put("url", url);
				options.put("user", user);
				options.put("password", password);
				options.put("dbtable", "area_info");  
				
				// 通过SQLContext去从MySQL中查询数据
				DataFrame areaInfoDF = sqlContext.read().format("jdbc").options(options).load();
				System.out.println("------------Mysql数据库中的表area_info数据为------------");
				areaInfoDF.show();
				// 返回RDD
				JavaRDD<Row> areaInfoRDD = areaInfoDF.javaRDD();
			
				JavaPairRDD<String, String> areaid2areaInfoRDD = areaInfoRDD.mapToPair(
						new PairFunction<Row, String, String>() {

							private static final long serialVersionUID = 1L;

							@Override
							public Tuple2<String, String> call(Row row) throws Exception {
								String areaid = String.valueOf(row.get(0));  
								String areaname = String.valueOf(row.get(1));  
								return new Tuple2<String, String>(areaid, areaname);
							}
						});
				
				return areaid2areaInfoRDD;
	}
	
	/**
	 * 获取日期内的数据
	 * @param sqlContext
	 * @param taskParam
	 * @return (areaId,row)
	 */
	private static JavaPairRDD<String, Row> getInfosByDateRDD(SQLContext sqlContext, JSONObject taskParam) {
		String startDate = ParamUtils.getParam(taskParam, Constants.PARAM_START_DATE);
		String endDate = ParamUtils.getParam(taskParam, Constants.PARAM_END_DATE);
		 
		 String sql = "SELECT "
		 		+ "monitor_id,"
		 		+ "car,"
		 		+ "road_id,"
		 		+ "area_id "
		 		+ "FROM	traffic.monitor_flow_action "
		 		+ "WHERE date >= '"+startDate+"'"
		 				+ "AND date <= '"+endDate+"'";
		 DataFrame df = sqlContext.sql(sql);
		 return df.javaRDD().mapToPair(new PairFunction<Row, String, Row>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Tuple2<String, Row> call(Row row) throws Exception {
				String areaId = row.getString(3);
				return new Tuple2<String, Row>(areaId,row);
			}
		});
	}
}
