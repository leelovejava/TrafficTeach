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
import com.spark.test.{MockDataByMysql, MockDataScala}
import org.apache.spark.SparkContext
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

import scala.collection.mutable.ListBuffer

/**
  * 卡扣流量转换率
  */
object MonitorOneStepConvertRateAnalyzeScala {
  def main(args: Array[String]): Unit = {
    var sc: SparkContext = null
    var ssc: SparkSession = null
    /**
      * 判断应用程序是否在本地执行
      */
    val onLocal: Boolean = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL)

    /**
      * 本地生成视图或者从Hive查询
      */
    if (onLocal) {
      //这里不会真正的创建SparkSession,而是根据前面这个SparkContext来获取封装SparkSession,因为不会创建存在两个SparkContext的。
      ssc = SparkSession.builder().master("local").appName("test").getOrCreate()
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

    val taskId: lang.Long = ParamUtils.getTaskIdFromArgs(args, Constants.SPARK_LOCAL_TASKID_MONITOR_ONE_STEP_CONVERT)
    val taskDAO: ITaskDAO = DAOFactory.getTaskDAO
    val task: Task = taskDAO.findTaskById(taskId)
    if (task == null) {
      println("没有当前taskID对应的对象")
      System.exit(1)
    }
    val parms: JSONObject = JSON.parseObject(task.getTaskParams())

    /**
      * 从数据库中查找出来我们指定的卡扣流   组装成list并广播
      * 0001,0002,0003,0004,0005
      */
    val roadFlow: String = ParamUtils.getParam(parms, Constants.PARAM_MONITOR_FLOW)
    val split: Array[String] = roadFlow.split(",")
    //定义未来广播的list
    var listRoad: ListBuffer[String] = ListBuffer[String]()
    //    定义变量road 用于临时存放listRoad中的值
    var road = ""
    for (str <- split) {
      road = road + "," + str
      listRoad.append(road.substring(1))
    }
    val listRoadBroadcast: Broadcast[ListBuffer[String]] = sc.broadcast(listRoad)

    /**
      * 通过params（json字符串）查询monitor_flow_action
      * 获取指定日期内检测的monitor_flow_action中车流量数据，返回JavaRDD<Row>
      */
    val cameraDF: DataFrame = SparkUtilsScala.getCameraRDDByDateRange(ssc, parms)
    //转换为RDD
    val rdd1: RDD[Row] = cameraDF.rdd

    /**
      * 将RDD转换为 (car,row)格式
      */
    val rdd2: RDD[(String, Row)] = rdd1.map(row => {
      (row.getAs[String]("car"), row)
    })

    /**
      * 将rdd2 先按照 row里面的时间排序，再按照car来分组
      */
//    val rdd3: RDD[(String, Iterable[Row])] = rdd2.sortBy(tp => {tp._2.getAs[String]("action_time")}).groupByKey()


    val rdd3: RDD[(String, Iterable[Row])] = rdd2.sortBy(_._2.getAs[String]("action_time")).groupByKey()

    /**
      * rrd3分好组的(car,(row,row))转换为 (car,str)
      * str 为  monitor_id按照时间顺序来拼接的字符串
      */
    val rdd4: RDD[String] = rdd3.map(tp => {
      val list: List[Row] = tp._2.iterator.toList
      var monitorIds = ""
      for (row <- list) {
        val monitorId: String = row.getAs[String]("monitor_id")
        monitorIds = monitorIds + "," + monitorId
      }
      (monitorIds.substring(1))
    })
    /**
      * 计算这一辆车，有多少次匹配到我们指定的卡扣流
      *
      * 先拿到车辆的轨迹，比如一辆车轨迹：0001,0002,0003,0004,0001,0002,0003,0001,0004
      * 返回一个二元组（切分的片段，该片段对应的该车辆轨迹中匹配上的次数）
      * ("0001",3)
      * ("0001,0002",2)
      * ("0001,0002,0003",2)
      * ("0001,0002,0003,0004",1)
      * ("0001,0002,0003,0004,0005",0)
      * ... ...
      * ("0001",13)
      * ("0001,0002",12)
      * ("0001,0002,0003",11)
      * ("0001,0002,0003,0004",11)
      * ("0001,0002,0003,0004,0005",10)
      */
    val rdd5: RDD[(String, Long)] = rdd4.flatMap(str => {
      val returnList: ListBuffer[(String, Long)] = ListBuffer[(String, Long)]()
      //获取广播变量的值
      val list: ListBuffer[String] = listRoadBroadcast.value
      for (s <- list) {
        //indexOf 从哪个位置开始查找
        var index = 0
        //这辆车有多少次匹配到这个卡扣切片的次数
        var count = 0L
        while (str.indexOf(s, index) != -1) {
          index = str.indexOf(s, index) + 1
          count += 1
        }
        returnList.append((s, count))
      }
      returnList.iterator
    })

    /**
      * 合并并打印数据
      */
    val rdd6: RDD[(String, Long)] = rdd5.reduceByKey(_ + _)
    rdd6.foreach(println)
    // 下面的方式为何不行 foreachPartition是打印迭代器了

//     rdd6.foreachPartition(println)
  }
}
