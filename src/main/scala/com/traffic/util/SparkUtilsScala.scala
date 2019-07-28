package com.com.bjsxt.spark.util

import com.alibaba.fastjson.JSONObject
import com.traffic.spark.constant.Constants
import com.traffic.spark.util.ParamUtils
import org.apache.spark.api.java.JavaRDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object SparkUtilsScala {

  def getCameraRDDByDateRange(ssc: SparkSession, parms: JSONObject) = {

    val startDate: String = ParamUtils.getParam(parms, Constants.PARAM_START_DATE)
    val endDate: String = ParamUtils.getParam(parms, Constants.PARAM_END_DATE)
    val sql: String = "SELECT *  FROM monitor_flow_action " + "WHERE date>='" + startDate + "' " + "AND date<='" + endDate + "'"
    ssc.sql(sql)
  }

  def getMonitorRDDByDateRange(ssc: SparkSession) = {
    val sql: String = "SELECT * FROM monitor_camera_info"
    ssc.sql(sql)
  }
  def getAreaRDDByDateRange(ssc: SparkSession) = {
    val sql: String = "SELECT * FROM area_info"
    ssc.sql(sql)
  }
}
