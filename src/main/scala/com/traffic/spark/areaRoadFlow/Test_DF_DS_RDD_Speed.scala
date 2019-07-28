package com.traffic.spark.areaRoadFlow

/**
 * 测试  RDD FD DS速度
 */

import java.util.UUID

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Dataset, SparkSession}

object Test_DF_DS_RDD_Speed {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder().appName("无聊耍耍").master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    val firstRdd: RDD[(String, Int)] = spark.sparkContext.parallelize(0 to 400000).map(num => {
      (UUID.randomUUID().toString, num)
    })
    firstRdd
    firstRdd.cache()

    val beginTimeRdd: Long = System.currentTimeMillis()
    firstRdd.map(tp => {
      tp._1 + "-" + tp._2
    }).collect()
    val endTimeRdd: Long = System.currentTimeMillis()

    import spark.implicits._
    val beginTimeDF: Long = System.currentTimeMillis()
    firstRdd.toDF().map(row => {
      row.get(0) + "-" + row.get(1)
    }).collect()
    val endTimeDF: Long = System.currentTimeMillis()

    val beginTimeDS: Long = System.currentTimeMillis()
    firstRdd.toDS().map(tp => {
      tp._1 + "-" + tp._2
    }).collect()
    val endTimeDS: Long = System.currentTimeMillis()

    println(s"RDD算子耗时${endTimeRdd - beginTimeRdd}")
    println(s"DF算子耗时${endTimeDF - beginTimeDF}")
    println(s"DS算子耗时${endTimeDS - beginTimeDS}")
  }
}
