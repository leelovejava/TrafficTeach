package com.bjsxt.spark.rtmroad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaPairInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import com.bjsxt.spark.conf.ConfigurationManager;
import com.bjsxt.spark.constant.Constants;

import kafka.serializer.StringDecoder;
import scala.Tuple2;

public class RoadRealTimeAnalyze {
	public static void main(String[] args) {
		// 构建Spark Streaming上下文
		SparkConf conf = new SparkConf()       
 				.setMaster("local")
				.setAppName("AdClickRealTimeStatSpark");
//				.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
//				.set("spark.default.parallelism", "1000");
//				.set("spark.streaming.blockInterval", "50");    
//				.set("spark.streaming.receiver.writeAheadLog.enable", "true");   
				
		JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(5));
		jssc.sparkContext().setLogLevel("WARN");
		jssc.checkpoint("./checkpoint");
		
		Map<String, String> kafkaParams = new HashMap<String, String>();
		String brokers = ConfigurationManager.getProperty(Constants.KAFKA_METADATA_BROKER_LIST);
		kafkaParams.put("metadata.broker.list",brokers);
		
		// 构建topic set
		String kafkaTopics = ConfigurationManager.getProperty(Constants.KAFKA_TOPICS);
		String[] kafkaTopicsSplited = kafkaTopics.split(",");  
		
		Set<String> topics = new HashSet<String>();
		for(String kafkaTopic : kafkaTopicsSplited) {
			topics.add(kafkaTopic);
		}
		
		JavaPairInputDStream<String, String> carRealTimeLogDStream = KafkaUtils.createDirectStream(
				jssc, 
				String.class, 
				String.class, 
				StringDecoder.class, 
				StringDecoder.class, 
				kafkaParams, 
				topics);
		
		/**
		 * 实时计算道路的拥堵情况
		 */
		realTimeCalculateRoadState(carRealTimeLogDStream);
		
		/**
		 * 动态改变广播变量
		 */
//		String path = "I:\\ControlCar.txt";
//		controlCar(path,carRealTimeLogDStream);
		
		jssc.start();
		jssc.awaitTermination();
	}

	private static void controlCar(final String path, JavaPairInputDStream<String, String> carRealTimeLogDStream) {
		 
		carRealTimeLogDStream.transform(new Function<JavaPairRDD<String,String>, JavaRDD<String>>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("resource")
			@Override
			public JavaRDD<String> call(JavaPairRDD<String, String> rdd) throws Exception {
				 
				SparkContext context = rdd.context();
				JavaSparkContext sc = new JavaSparkContext(context);
				List<String> blackCars = readFile(path);
				final Broadcast<List<String>> broadcast = sc.broadcast(blackCars);
				
				/*****/
				List<String> value = broadcast.value();
				for (String string : value) {
					System.out.println("broadcast value:" + string);
				}
				/*****/
				
				JavaRDD<String> map = rdd.filter(new Function<Tuple2<String,String>, Boolean>() {

					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public Boolean call(Tuple2<String, String> tuple) throws Exception {
						List<String> list = broadcast.value();
						//tuple._2.split("\t")[3] --- car
						return list.contains(tuple._2.split("\t")[3]);
					}
				}).map(new Function<Tuple2<String,String>,String>() {

					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public String call(Tuple2<String, String> v1) throws Exception {
						//卡扣号，以及action_time   直接写入到数据库中
						//每一个log 是要缉查布控的车辆的详细信息
						String log = v1._2;
						//通过log这一条数据，能够截取到monitorId，action_time
						log.split("\t");
						return v1._2;
					}
				});
				return map;
			}
			
			/**
			 * 读取文件
			 * @param path
			 * @return
			 */
			private List<String> readFile(String path) {
				List<String> list = new ArrayList<>(); 
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
					String line = br.readLine();
					while(line != null ){
						list.add(line);
						line = br.readLine();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return list;
			}
		}).print();
	}

	private static void realTimeCalculateRoadState(JavaPairInputDStream<String, String> adRealTimeLogDStream) {
		JavaDStream<String> roadRealTimeLog = adRealTimeLogDStream.map(new Function<Tuple2<String,String>, String>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String call(Tuple2<String, String> tuple) throws Exception {
				return tuple._2;
			}
		});
		
		/**
		 * 拿到车辆的信息了
		 * 		car speed monitorId
		 * <Monitor_id,Speed>
		 */
		
		  JavaPairDStream<String, Integer> mapToPair = roadRealTimeLog.mapToPair(new PairFunction<String, String, Integer>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Tuple2<String, Integer> call(String log) throws Exception {
				String[] split = log.split("\t");
				//Tuple2(monitorId,speed)
				return new Tuple2<String, Integer>(split[1], Integer.parseInt(split[5]));
			}
		});
		  
		JavaPairDStream<String, Tuple2<Integer, Integer>> monitorId2SpeedDStream = 
				mapToPair.mapValues(new Function<Integer, Tuple2<Integer,Integer>>() {
			
			/**
			 * <monitorId	<speed,1>>
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Tuple2<Integer, Integer> call(Integer v1) throws Exception {
				return new Tuple2<Integer, Integer>(v1, 1);
			}
		});
		 /**
		  * 用优化的方式统计速度，返回的是tuple2(monitorId,(总速度，当前卡口通过的车辆总个数))
		  */
		 JavaPairDStream<String, Tuple2<Integer, Integer>> resultDStream = 
				 monitorId2SpeedDStream.reduceByKeyAndWindow(new Function2<Tuple2<Integer,Integer>, Tuple2<Integer,Integer>, Tuple2<Integer,Integer>>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Tuple2<Integer, Integer> call(Tuple2<Integer, Integer> v1, Tuple2<Integer, Integer> v2) throws Exception {
				return new Tuple2<Integer, Integer>(v1._1+v2._1, v1._2+v2._2);
			}
		}, new Function2<Tuple2<Integer, Integer>, Tuple2<Integer, Integer>, Tuple2<Integer, Integer>>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Tuple2<Integer, Integer> call(Tuple2<Integer, Integer> v1, Tuple2<Integer, Integer> v2) throws Exception {
				
				return new Tuple2<Integer, Integer>(v1._1 - v2._1,v2._2 - v2._2);
			}
		}, Durations.minutes(5), Durations.seconds(5));
		 
		 
		 /**
		  * 使用reduceByKeyAndWindow  窗口大小是1分钟，如果你的application还有其他的功能点的话，另外一个功能点不能忍受这个长的延迟。权衡一下还是使用reduceByKeyAndWindow。
		  */
		
		 resultDStream.foreachRDD(new VoidFunction<JavaPairRDD<String, Tuple2<Integer, Integer>>>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void call(JavaPairRDD<String, Tuple2<Integer, Integer>> rdd) throws Exception {
				final SimpleDateFormat secondFormate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				
				System.out.println("==========================================");
				
				rdd.foreachPartition(new VoidFunction<Iterator<Tuple2<String,Tuple2<Integer,Integer>>>>() {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public void call(Iterator<Tuple2<String, Tuple2<Integer, Integer>>> iterator) throws Exception {
						while (iterator.hasNext()) {
							Tuple2<String, Tuple2<Integer, Integer>> tuple = iterator.next();
							String monitor = tuple._1;
							int speedCount = tuple._2._1;
							int carCount = tuple._2._2;
							
							System.out.println("当前时间："+secondFormate.format(Calendar.getInstance().getTime())+
									"卡扣编号："+monitor + "车辆总数："+carCount + "速度总数：" + speedCount+" 平均速度："+(speedCount/carCount));
						}
					}
				});
			}
		});
		
	}
}
