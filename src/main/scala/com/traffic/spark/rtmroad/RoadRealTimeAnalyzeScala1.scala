package com.traffic.spark.rtmroad

import java.text.SimpleDateFormat
import java.util.Calendar

import com.traffic.spark.conf.ConfigurationManager
import com.traffic.spark.constant.Constants
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.kafka010.KafkaUtils
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.{Durations, StreamingContext}

object RoadRealTimeAnalyzeScala1 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("test").setMaster("local")
    // 构建Spark Streaming上下文
    val ssc = new StreamingContext(conf, Durations.seconds(5))
    ssc.sparkContext.setLogLevel("ERROR")
    // checkpoint 保留计算信息
    ssc.checkpoint("./MyCheckpoint")
    val brokers: String = ConfigurationManager.getProperty(Constants.KAFKA_METADATA_BROKER_LIST)
    val kafkaParms: Map[String, Object] = Map[String, Object](
      "bootstrap.servers" -> brokers,
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "MyGroupId-Traffic",
      "auto.offset.reset" -> "earliest",
      "enable.auto.commit" -> "true"
    )
    // 设置topic
    val topics: Array[String] = Array[String]("MyMockRealTimeData")

    val stream: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream(
      ssc,
      PreferConsistent,
      Subscribe[String, String](topics, kafkaParms)
    )
    /**
     * 转换为卡扣和一辆车的速度
     */
    val monitorSpeed: DStream[(String, Int)] = stream.map(tp => {
      val row: String = tp.value()
      val split: Array[String] = row.split("\t")
      (split(1), split(5).toInt)
    })
    /**
     * 转换为卡扣，（速度count，carcount）
     */
    val someCount: DStream[(String, (Int, Int))] = monitorSpeed.mapValues((_, 1))

    /**
     * 用优化的方式统计速度，返回的是tuple2(monitorId,(总速度，当前卡口通过的车辆总个数))
     */
    val result: DStream[(String, (Int, Int))] = someCount.reduceByKeyAndWindow(
      (v1: Tuple2[Int, Int], v2: Tuple2[Int, Int]) => {
        (v1._1 + v2._1, v1._2 + v2._2)
      },
      (v1: Tuple2[Int, Int], v2: Tuple2[Int, Int]) => {
        (v1._1 - v2._1, v1._2 - v2._2)
      }, Durations.minutes(5), Durations.seconds(5))

    // 打印结果
    result.foreachRDD(rdd => {
      rdd.foreachPartition(iter => {
        while (iter.hasNext) {
          val tuple: (String, (Int, Int)) = iter.next()
          val monitorId: String = tuple._1
          val speedCount: Int = tuple._2._1
          val carCount: Int = tuple._2._2
          val secondFormate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
          println("当前时间：" + secondFormate.format(Calendar.getInstance.getTime) + "  卡扣编号：" + monitorId + "  车辆总数：" + carCount + "  速度总数：" + speedCount + " 平均速度：" + (speedCount / carCount))
        }
      })
    })
    ssc.start()
    ssc.awaitTermination()
    ssc.stop()
  }
}
