package com.spark.test

import java.util.Properties

import org.apache.spark.SparkContext
import org.apache.spark.sql.{DataFrame, SparkSession}

object MockDataByMysql {
  def main(args: Array[String]): Unit = {
    val ssc: SparkSession = SparkSession.builder().master("local").appName("makeData").getOrCreate()
    val sc: SparkContext = ssc.sparkContext
    sc.setLogLevel("ERROR")
    MockData(sc, ssc)
  }

  def MockData(sc: SparkContext, ssc: SparkSession): Unit = {
    val properties = new Properties()
    properties.setProperty("user", "root")
    properties.setProperty("password", "123")
    val carInfos: DataFrame = ssc.read.jdbc("jdbc:mysql://node01:3306/traffic", "carTable", properties)
    carInfos.createOrReplaceTempView("monitor_flow_action")
    carInfos.show()
    val jkInfos: DataFrame = ssc.read.jdbc("jdbc:mysql://node01:3306/traffic", "jkTable", properties)
    jkInfos.createOrReplaceTempView("monitor_camera_info")
    jkInfos.show()
    val areaInfos: DataFrame = ssc.read.jdbc("jdbc:mysql://node01:3306/traffic", "area_info", properties)
    areaInfos.createOrReplaceTempView("area_info")
    areaInfos.show()
  }
}
