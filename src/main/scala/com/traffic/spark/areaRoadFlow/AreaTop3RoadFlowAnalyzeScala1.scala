package com.traffic.spark.areaRoadFlow

import java.lang

import com.alibaba.fastjson.{JSON, JSONObject}
import com.traffic.spark.conf.ConfigurationManager
import com.traffic.spark.constant.Constants
import com.traffic.spark.dao.ITaskDAO
import com.traffic.spark.dao.factory.DAOFactory
import com.traffic.spark.domain.Task
import com.traffic.spark.util.ParamUtils
import com.com.bjsxt.spark.util.SparkUtilsScala
import com.spark.test.MockDataByMysql
import org.apache.spark.SparkContext
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

import scala.collection.mutable.ListBuffer

/**
 * ！！！！！！！！！！！！！！！MYSQL数据库首先要有数据！！！！！！！！！！！！！！！！！！！！！
 * ！！！！！次方法生成视图的！！！！！！！！！！MockDataByMysql.MockData(sc, ssc)
 * 采用传统rdd方式
 *
 * 计算出每一个区域top3的道路流量
 * 每一个区域车流量最多的3条道路   每条道路有多个卡扣
 *
 * @author root
 *         ./spark-submit
 *         --master spark://node1:7077
 *         --jars ../lib/mysql-connector-java-5.1.6.jar,../lib/fastjson-1.2.11.jar
 *         --driver-class-path ../lib/mysql-connector-java-5.1.6.jar:../lib/fastjson-1.2.11.jar
 *         ../lib/Test.jar 4
 *
 *         这是一个分组取topN  SparkSQL分组取topN
 *         区域，道路流量排序         按照区域和道路进行分组
 *
 */
object AreaTop3RoadFlowAnalyzeScala1 {
  def main(args: Array[String]): Unit = {
    var sc: SparkContext = null
    var ssc: SparkSession = null
    /**
     * 判断应用程序是否在本地执行
     */
    val onLocal: Boolean = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL)

    /**
     * 本地Mysql生成视图或者从Hive查询
     */
    if (onLocal) {
      //这里不会真正的创建SparkSession,而是根据前面这个SparkContext来获取封装SparkSession,因为不会创建存在两个SparkContext的。
      ssc = SparkSession.builder().master("local").appName("test").getOrCreate()
      //      val ssss = ssc
      //      import ssss.implicits._
      sc = ssc.sparkContext

      /**
       * ！！！！！！！！！！！基于本地测试采用Mysql数据！！！！！！！！！！！！！！
       * 如果在集群中运行的话，直接操作Hive中的表就可以
       * 本地模拟数据注册成一张临时表
       * monitor_flow_action	数据表：监控车流量所有数据
       * monitor_camera_info	标准表：卡扣对应摄像头标准表
       * area_info	区域表：区域对应的区域名称
       */
      MockDataByMysql.MockData(sc, ssc)
    } else {
      println("++++++++++++开启hive的支持+++++++++++++++++")
      ssc = SparkSession.builder().appName(Constants.SPARK_APP_NAME).enableHiveSupport().getOrCreate()
      sc = ssc.sparkContext
      ssc.sql("usr traffic")
    }
    sc.setLogLevel("ERROR")

    /**
     * 采用的是task5 的时间日期，反正task4只要时间就行
     */
    val taskId: lang.Long = ParamUtils.getTaskIdFromArgs(args, Constants.SPARK_LOCAL_TASKID_MONITOR_ONE_STEP_CONVERT)
    val taskDAO: ITaskDAO = DAOFactory.getTaskDAO
    val task: Task = taskDAO.findTaskById(taskId)
    if (task == null) {
      println("没有当前taskID对应的对象")
      System.exit(1)
    }
    val parms: JSONObject = JSON.parseObject(task.getTaskParams())

    /**
     * 通过params（json字符串）查询monitor_flow_action
     * 获取指定日期内检测的monitor_flow_action中车流量数据，返回RDD<Row>
     */
    val cameraDF: DataFrame = SparkUtilsScala.getCameraRDDByDateRange(ssc, parms)
    //转换为RDD
    val cameraRdd: RDD[Row] = cameraDF.rdd
    cameraRdd.cache()

    /**
     * 查询area_action
     * 获取指定日期内检测的area_info中的数据，返回RDD<Row>
     */
    val areaDF: DataFrame = SparkUtilsScala.getAreaRDDByDateRange(ssc)
    val areaRdd: RDD[Row] = areaDF.rdd
    areaRdd.cache()

    /**
     * 将areaRdd 转换为 (area_id,area_name)格式的 rdd广播出去
     */
    val map: collection.Map[String, String] = areaRdd.map(row => {
      (row.getAs[String]("area_id"), row.getAs[String]("area_name"))
    }).collectAsMap()
    val areaIdNameMap: Broadcast[collection.Map[String, String]] = sc.broadcast(map)

    /**
     * ------------------------统计每个区域经过车辆数最多的top3道路及通过的车辆数
     */

    /**
     * 首先转把row换成    (区域-道路,1)类型的rdd
     */
    val areaRoadRdd: RDD[(String, Int)] = cameraRdd.map(row => {
      val areaId: String = row.getAs[String]("area_id")
      val roadId: String = row.getAs[String]("road_id")
      (areaId + "-" + roadId, 1)
    })
    /**
     * 通过区域和道路排序
     */
    val areaRoadSortRdd: RDD[(String, Int)] = areaRoadRdd.reduceByKey((_ + _)).sortBy(_._2, false)

    /**
     * 转换成   (区域,(道路,车辆数)) 类型的rdd
     */
    val tempRdd: RDD[(String, (String, Int))] = areaRoadSortRdd.map(tp => {
      val areaRoad: String = tp._1
      val area: String = areaRoad.split("-")(0)
      val road: String = areaRoad.split("-")(1)
      (area, (road, tp._2))
    })

    /**
     * 统计每个区域经过车辆数最多的top3道路及通过的车辆数   取出前三即可
     */
    val tempResult: RDD[(String, Int)] = tempRdd.groupByKey().flatMap(tp => {
      var top = 0
      //取出拍好序的城区和道路
      val list: List[(String, Int)] = tp._2.iterator.toList
      //创建返回对象
      val returnList: ListBuffer[(String, Int)] = ListBuffer[(String, Int)]()
      for (value <- list) {
        if (top < 3) {
          val key: String = tp._1.toString + "-" + value._1
          returnList.append((key, value._2))
          top += 1
        }
      }
      returnList.iterator
    })
    /**
     * 将 前三的 (areaId-roadId,count) 广播出去
     */
    val broadcastResult: collection.Map[String, Int] = tempResult.collectAsMap()
    val broadcastResultMap: Broadcast[collection.Map[String, Int]] = sc.broadcast(broadcastResult)
    /**
     * 分组后转换成最终结果，带上区域名字
     */
    val result: RDD[(String, Int)] = tempResult.map(tp => {
      val areaIdName: collection.Map[String, String] = areaIdNameMap.value
      var tempArea: String = tp._1.split("-")(0)
      val tempRoad: String = tp._1.split("-")(1)
      if (areaIdName.contains(tempArea)) {
        tempArea = areaIdName.get(tempArea).get
      }
      (tempArea + "-" + tempRoad, tp._2)
    })

    /**
     * 统计每个区域经过车辆数最多的top3道路及通过的车辆数   取出前三即可
     */
    println("------------------------统计每个区域经过车辆数最多的top3道路及通过的车辆数")
    result.foreach(println)


    /**
     * ----------------------------统计每个区域经过车辆数最多的top3道路及通过的车辆数、当前道路下每个卡扣经过的车辆数
     */

    /**
     * 将row中的值转换为(areaId-roadId-monitorId,row)
     */
    val areaRoadMonitorid: RDD[(String, Int)] = cameraRdd.map(row => {
      val areaId: String = row.getAs[String]("area_id")
      val roadId: String = row.getAs[String]("road_id")
      val monitorId: String = row.getAs[String]("monitor_id")
      (areaId + "-" + roadId + "-" + monitorId, 1)
    })
    /**
     * 过滤掉非前top3的数据
     */
    val areaRoadMonitoridfilter: RDD[(String, Int)] = areaRoadMonitorid.filter(tp => {
      val areaIdRoadIdMonitorId: String = tp._1
      val split: Array[String] = areaIdRoadIdMonitorId.split("-")
      val areaIdRoadId: String = split(0) + "-" + split(1)
      val broadcastResult: collection.Map[String, Int] = broadcastResultMap.value
      broadcastResult.contains(areaIdRoadId)
    })
    /**
     * 将areaRoadMonitorid中的值合并value并排序
     */
    val areaRoadMonitoridSort: RDD[(String, Int)] = areaRoadMonitoridfilter.reduceByKey(_ + _).sortBy(_._2, false)

    /**
     * 转换成(areaname,roadId-monitorid-value)
     *
     */
    val tempResult1: RDD[(String, Iterable[String])] = areaRoadMonitoridSort.map(tp => {
      val areaIdRoadIdMonitorId: String = tp._1
      val split: Array[String] = areaIdRoadIdMonitorId.split("-")
      (split(0) + "-" + split(1), split(2) + "-" + (tp._2))
    }).groupByKey()


    /**
     * 分组后转换成最终结果，带上区域名字
     */
    val result1: RDD[(String, Iterable[String])] = tempResult1.map(tp => {
      val areaIdName: collection.Map[String, String] = areaIdNameMap.value
      var tempArea: String = tp._1.split("-")(0)
      val tempRoad: String = tp._1.split("-")(1)
      if (areaIdName.contains(tempArea)) {
        tempArea = areaIdName.get(tempArea).get
      }
      (tempArea + "-" + tempRoad, tp._2)
    })
    println("----------------------------统计每个区域经过车辆数最多的top3道路及通过的车辆数、当前道路下每个卡扣经过的车辆数")
    result1.sortByKey(false).foreach(println)
  }
}
