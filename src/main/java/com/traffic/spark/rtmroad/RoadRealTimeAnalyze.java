package com.traffic.spark.rtmroad;

import com.traffic.spark.conf.ConfigurationManager;
import com.traffic.spark.constant.Constants;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
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
import org.apache.spark.streaming.api.java.*;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import scala.Tuple2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;


public class RoadRealTimeAnalyze {
    public static void main(String[] args) throws InterruptedException {
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

        Map<String, Object> kafkaParams = new HashMap<>();
        String brokers = ConfigurationManager.getProperty(Constants.KAFKA_METADATA_BROKER_LIST);
        kafkaParams.put("bootstrap.servers", brokers);
        kafkaParams.put("key.deserializer", StringDeserializer.class);
        kafkaParams.put("value.deserializer", StringDeserializer.class);

        // 构建topic set
        String kafkaTopics = ConfigurationManager.getProperty(Constants.KAFKA_TOPICS);
        String[] kafkaTopicsSplited = kafkaTopics.split(",");

        Set<String> topics = new HashSet<String>();
        for (String kafkaTopic : kafkaTopicsSplited) {
            topics.add(kafkaTopic);
        }

//		JavaPairInputDStream<String, String> carRealTimeLogDStream = KafkaUtils.createDirectStream(
//				jssc,
//				String.class,
//				String.class,
//				StringDecoder.class,
//				StringDecoder.class,
//				kafkaParams,
//				topics);
//
        JavaInputDStream<ConsumerRecord<String, String>> carRealTimeLogDStream = KafkaUtils.createDirectStream(
                jssc,
                LocationStrategies.PreferConsistent(),
                ConsumerStrategies.<String, String>Subscribe(topics, kafkaParams));
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
        jssc.stop();
    }

    /**
     * 读取文件方法
     */
    public static List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line = br.readLine();
            while (line != null) {
                list.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }


    private static void controlCar(final String path, JavaPairInputDStream<String, String> carRealTimeLogDStream) {

        carRealTimeLogDStream.transform(new Function<JavaPairRDD<String, String>, JavaRDD<String>>() {
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

                JavaRDD<String> map = rdd.filter(new Function<Tuple2<String, String>, Boolean>() {

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
                }).map(new Function<Tuple2<String, String>, String>() {

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

//			/**
//			 * 读取文件
//			 * @param path
//			 * @return
//			 */
//			private List<String> readFile(String path) {
//				List<String> list = new ArrayList<>();
//				try {
//					BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
//					String line = br.readLine();
//					while(line != null ){
//						list.add(line);
//						line = br.readLine();
//					}
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//				return list;
//			}
        }).print();
    }

    private static void realTimeCalculateRoadState(JavaInputDStream<ConsumerRecord<String, String>> adRealTimeLogDStream) {
        JavaDStream<String> roadRealTimeLog = adRealTimeLogDStream.map(new Function<ConsumerRecord<String, String>, String>() {
            @Override
            public String call(ConsumerRecord<String, String> cr) throws Exception {
                String key = cr.key();
//				System.out.println("key = "+key);
                return cr.value();
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
                mapToPair.mapValues(new Function<Integer, Tuple2<Integer, Integer>>() {

                    /**
                     * <monitorId	<speed,1>>
                     */
                    private static final long serialVersionUID = 1L;

                    @Override
                    public Tuple2<Integer, Integer> call(Integer speed) throws Exception {
                        return new Tuple2<Integer, Integer>(speed, 1);
                    }
                });
        /**
         * 用优化的方式统计速度，返回的是tuple2(monitorId,(总速度，当前卡口通过的车辆总个数))
         */
        JavaPairDStream<String, Tuple2<Integer, Integer>> resultDStream =
                monitorId2SpeedDStream.reduceByKeyAndWindow(new Function2<Tuple2<Integer, Integer>, Tuple2<Integer, Integer>, Tuple2<Integer, Integer>>() {
                    /**
                     *
                     */
                    private static final long serialVersionUID = 1L;

                    @Override
                    public Tuple2<Integer, Integer> call(Tuple2<Integer, Integer> v1, Tuple2<Integer, Integer> v2) throws Exception {
                        return new Tuple2<Integer, Integer>(v1._1 + v2._1, v1._2 + v2._2);
                    }
                }, new Function2<Tuple2<Integer, Integer>, Tuple2<Integer, Integer>, Tuple2<Integer, Integer>>() {

                    /**
                     *
                     */
                    private static final long serialVersionUID = 1L;

                    @Override
                    public Tuple2<Integer, Integer> call(Tuple2<Integer, Integer> v1, Tuple2<Integer, Integer> v2) throws Exception {

                        return new Tuple2<Integer, Integer>(v1._1 - v2._1, v2._2 - v2._2);
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

                /**
                 * 广播变量
                 */
                List<String> readFile = readFile("I:\\ControlCar.txt");

                JavaSparkContext sc = new JavaSparkContext(rdd.context());
                final Broadcast<List<String>> broadcast = sc.broadcast(readFile);

                final SimpleDateFormat secondFormate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                rdd.foreachPartition(new VoidFunction<Iterator<Tuple2<String, Tuple2<Integer, Integer>>>>() {
                    /**
                     *
                     */
                    private static final long serialVersionUID = 1L;

                    @Override
                    public void call(Iterator<Tuple2<String, Tuple2<Integer, Integer>>> iterator) throws Exception {
                        /**
                         * 使用广播变量
                         */
                        List<String> value = broadcast.value();
                        for (String s : value) {
                            System.out.println("bc value = " + s);
                        }


                        while (iterator.hasNext()) {
                            Tuple2<String, Tuple2<Integer, Integer>> tuple = iterator.next();
                            String monitor = tuple._1;
                            int speedCount = tuple._2._1;
                            int carCount = tuple._2._2;

                            System.out.println("当前时间：" + secondFormate.format(Calendar.getInstance().getTime()) +
                                    "卡扣编号：" + monitor + "车辆总数：" + carCount + "速度总数：" + speedCount + " 平均速度：" + (speedCount / carCount));
                        }
                    }
                });
            }
        });

    }
}
