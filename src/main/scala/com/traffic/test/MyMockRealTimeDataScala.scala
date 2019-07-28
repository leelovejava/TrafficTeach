package com.spark.test

import java.util.Properties

import com.traffic.spark.util.{DateUtils, StringUtils}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import scala.util.Random

class MyMockRealTimeDataScala extends Thread {
  private val random = new Random()
  private val locations: Array[String] = Array[String]("鲁", "京", "川", "深", "沪", "晋", "京", "西", "重", "湘")

  var producer: KafkaProducer[String, String] = new KafkaProducer[String, String](createProducerConfig())

  def createProducerConfig() = {
    val prop = new Properties()
    prop.put("bootstrap.servers", "node01:9092,node02:9092,node03:9092")
    prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    prop
  }

  override def run() = {
    println("正在生产数据 ... ... ")
    while (true) {
      val date: String = DateUtils.getTodayDate
      val baseActionTime: String = date + " " + StringUtils.fulFuill(random.nextInt(24) + "")
      val actionTime: String = baseActionTime + ":" + StringUtils.fulFuill(random.nextInt(60) + "") + ":" + StringUtils.fulFuill(random.nextInt(60) + "")
      val monitorId: String = StringUtils.fulFuill(4, random.nextInt(9) + "")
      val car: String = locations(random.nextInt(10)) + (65 + random.nextInt(26)).toChar + StringUtils.fulFuill(5, random.nextInt(99999) + "")
      val speed: String = random.nextInt(260) + ""

      val cameraId: String = StringUtils.fulFuill(5, random.nextInt(9999) + "")
      val roadId: String = Integer.valueOf(cameraId) % 50 + 1 + ""
      val areaId: String = StringUtils.fulFuill(2, Integer.valueOf(cameraId) % 9 + 1 + "")
      producer.send(new ProducerRecord[String, String]("MyMockRealTimeData", date + "\t" + monitorId + "\t" + cameraId + "\t" + car + "\t" + actionTime + "\t" + speed + "\t" + roadId + "\t" + areaId))
      Thread.sleep(50)
    }
  }
}

object producer {
  def main(args: Array[String]): Unit = {
    val mockRealTimeDataScala = new MyMockRealTimeDataScala()
    mockRealTimeDataScala.start()
  }
}
