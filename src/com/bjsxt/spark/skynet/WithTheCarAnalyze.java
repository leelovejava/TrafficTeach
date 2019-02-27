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
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

import scala.Tuple2;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.spark.constant.Constants;
import com.bjsxt.spark.dao.ICarTrackDAO;
import com.bjsxt.spark.dao.ITaskDAO;
import com.bjsxt.spark.dao.factory.DAOFactory;
import com.bjsxt.spark.domain.CarTrack;
import com.bjsxt.spark.domain.Task;
import com.bjsxt.spark.util.DateUtils;
import com.bjsxt.spark.util.ParamUtils;
import com.bjsxt.spark.util.SparkUtils;

public class WithTheCarAnalyze {
	public static void main(String[] args) {
		
		/**
		 * 现在要计算的是所有的车的跟踪信息
		 * 
		 *标准是：两个车的时间差在5分钟内就是有跟踪嫌疑
		 * table1：car track   1：时间段（精确到5分钟） 2 3 4 5
		 * table2：monitor_id 12:00-12:05  cars  A B C
		 * 						12:06-12:10  cars
		 */
		// 构建Spark上下文
				SparkConf conf = new SparkConf()
						.setAppName(Constants.SPARK_APP_NAME_SESSION)
						.set("spark.sql.shuffle.partitions", "10")
						.set("spark.default.parallelism", "100")
//						.set("spark.storage.memoryFraction", "0.5")  
//						.set("spark.shuffle.consolidateFiles", "true")
//						.set("spark.shuffle.file.buffer", "64")  
//						.set("spark.shuffle.memoryFraction", "0.3")    
//						.set("spark.reducer.maxSizeInFlight", "24")  
//						.set("spark.shuffle.io.maxRetries", "60")  
//						.set("spark.shuffle.io.retryWait", "60")   
//						.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
						;
				SparkUtils.setMaster(conf); 
				
				JavaSparkContext sc = new JavaSparkContext(conf);
				
				SQLContext sqlContext = SparkUtils.getSQLContext(sc);
				
				/**
				 * 基于本地测试生成模拟测试数据，如果在集群中运行的话，直接操作Hive中的临时表就可以
				 * 本地模拟数据注册成一张临时表
				 * monitor_flow_action
				 */
				SparkUtils.mockData(sc, sqlContext);
				
				
				
				//从配置文件中查询出来指定的任务ID
				long taskId = ParamUtils.getTaskIdFromArgs(args, Constants.SPARK_LOCAL_WITH_THE_CAR);
				
				/**
				 * 通过taskId从数据库中查询相应的参数
				 * 	1、通过DAOFactory工厂类创建出TaskDAO组件
				 * 	2、查询task
				 */
				ITaskDAO taskDAO = DAOFactory.getTaskDAO();
				Task task = taskDAO.findTaskById(taskId);
				
				if(task == null){
					return;
				}
				
				/**
				 * task对象已经获取到，因为params是一个json，所以需要创建一个解析json的对象 
				 */
				JSONObject taskParamsJsonObject = JSONObject.parseObject(task.getTaskParams());
			   
				/**
				 * 统计出指定时间内的车辆信息
				 */
				JavaRDD<Row> cameraRDD = SparkUtils.getCameraRDDByDateRange(sqlContext, taskParamsJsonObject);
				
 				withTheCarAnalyze(taskId,sc,cameraRDD);
				sc.close();				
	}

	private static void withTheCarAnalyze(final long taskId, JavaSparkContext sc, JavaRDD<Row> cameraRDD) {
		
		/**
		 * trackWithActionTimeRDD
		 * k: car
		 * v:monitor_id+"="+action_time
		 */
		JavaPairRDD<String, String> trackWithActionTimeRDD = getCarTrack(cameraRDD);
		/**
		 * 所有车辆轨迹存储在MySQL中，测试只是放入到MySQL   实际情况是在Redis中
		 * 
		 * 
		 * 
		 * car	monitor:actionTime
		 * 
		 * monitor_id	时间段（actionTime）
		 */
		trackWithActionTimeRDD.foreachPartition(new VoidFunction<Iterator<Tuple2<String,String>>>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void call(Iterator<Tuple2<String, String>> iterator) throws Exception {
				
				List<CarTrack> carTracks = new ArrayList<>();
				
				while(iterator.hasNext()){
					Tuple2<String, String> tuple = iterator.next();
					String car = tuple._1;
					String timeAndTack = tuple._2;
					//carTrackWithTime.append("|" + row.getString(1)+"="+row.getString(4))
					//car , monitor_id,actionTime
					carTracks.add(new CarTrack(taskId, DateUtils.getTodayDate(), car, timeAndTack));
				}
				ICarTrackDAO carTrackDAO = DAOFactory.getCarTrackDAO();
				/**
				 * 将数据插入到表car_track中
				 */
				carTrackDAO.insertBatchCarTrack(carTracks);
			}
		});
		
		/*List<Tuple2<String, String>> car2Track = trackWithActionTimeRDD.collect();
		final Broadcast<List<Tuple2<String, String>>> car2TrackBroadcast = sc.broadcast(car2Track);
		
		trackWithActionTimeRDD.mapToPair(new PairFunction<Tuple2<String,String>, String,String>() {
			*//**
			 * 
			 *//*
			private static final long serialVersionUID = 1L;

			@Override
			public Tuple2<String, String> call(Tuple2<String, String> tuple) throws Exception {
				List<Tuple2<String, String>> car2Tracks = car2TrackBroadcast.value();
				return null;
			}
		});*/
		
		/**
		 * 卡口号	时间段（粒度至5分钟）	车牌集合
		 * 	具体查看每一个卡口在每一个时间段内车辆的数量。
		 * 实现思路：
		 * 	按照卡口进行聚合	
		 *//*
		
		cameraRDD.mapToPair(new PairFunction<Row,String, Row>() {
			*//**
			 * 
			 *//*
			private static final long serialVersionUID = 1L;

			@Override
			public Tuple2<String, Row> call(Row row) throws Exception {
				return new Tuple2<String, Row>(row.getString(1), row);
			}
		}).groupByKey().foreach(new VoidFunction<Tuple2<String,Iterable<Row>>>() {

			*//**
			 * 
			 *//*
			private static final long serialVersionUID = 1L;

			@Override
			public void call(Tuple2<String, Iterable<Row>> tuple) throws Exception {
				String monitor = tuple._1;
				Iterator<Row> rowIterator = tuple._2.iterator();
				List<Row> rows = new ArrayList<>();
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					rows.add(row);
				}
				
				 
				
			}
		}); 
		*/
		
		
		
	}

	private static JavaPairRDD<String, String> getCarTrack(JavaRDD<Row> cameraRDD) {
		return cameraRDD.mapToPair(new PairFunction<Row, String, Row>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Tuple2<String, Row> call(Row row) throws Exception {
				return new Tuple2<String, Row>(row.getString(3), row);
			}
		}).groupByKey().mapToPair(new PairFunction<Tuple2<String,Iterable<Row>>, String, String>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Tuple2<String, String> call(Tuple2<String, Iterable<Row>> t) throws Exception {
				String car = t._1;
				Iterator<Row> iterator = t._2.iterator();
				List<Row> rows = new ArrayList<>();
				while (iterator.hasNext()) {
					Row row = iterator.next();
					rows.add(row);
				}
				Collections.sort(rows, new Comparator<Row>() {
					

					@Override
					public int compare(Row r1, Row r2) {
						String actionTime1 = r1.getString(4);
						String actionTime2 = r2.getString(4);
						
						if(DateUtils.before(actionTime1, actionTime2)){
							return -1;
						}
						return 1;
					}
				});
				
				StringBuilder carTrackWithTime = new StringBuilder();
				for (Row row : rows) {
					carTrackWithTime.append("|" + row.getString(1)+"="+row.getString(4));
				}
				String trackWithTime = "";
				if(!"".equals(carTrackWithTime.toString())){
					trackWithTime = carTrackWithTime.toString().substring(1);
				}
				
				return new Tuple2<String, String>(car, trackWithTime);
			}
		});
	}

	 
}
