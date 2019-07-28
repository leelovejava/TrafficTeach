package com.spark.test

import java.util
import java.util.{Arrays, HashSet, Properties}

import com.traffic.spark.util.{DateUtils, StringUtils}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{DataTypes, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Dataset, Row, RowFactory, SaveMode, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
 * 模拟数据  数据格式如下：
 *
 * 日期	      卡口ID		  摄像头编号  车牌号	   拍摄时间	   车速	     道路ID   	 区域ID
 * date	 monitor_id	 camera_id	 car	action_time		speed	    road_id		area_id
 *
 * monitor_flow_action
 * monitor_camera_info
 *
 * @author Administrator
 */
object MockDataScala {

  def main(args: Array[String]): Unit = {
    val ssc: SparkSession = SparkSession.builder().master("local").appName("makeData").getOrCreate()
    val sc: SparkContext = ssc.sparkContext
    sc.setLogLevel("ERROR")
    MockData(sc, ssc)
  }

  def MockData(sc: SparkContext, ssc: SparkSession) = {
    val properties = new Properties()
    properties.setProperty("user", "root")
    properties.setProperty("password", "123")


    val dataList = new ListBuffer[Row]
    val random = new Random()
    val locations: Array[String] = Array[String]("鲁", "京", "粤", "浙", "沪", "上", "川", "深", "晋", "湘")
    val date: String = DateUtils.getTodayDate()

    /**
     * 模拟3000个车辆
     */
    for (i <- 1 to 3000) {
      //模拟车牌号：如：京A00001
      val car: String = locations(random.nextInt(10)) + (65 + random.nextInt(26)).toChar + StringUtils.fulfuill(5, random.nextInt(100000) + "")

      //baseActionTime 模拟24小时
      var baseActionTime: String = date + " " + StringUtils.fulFuill(random.nextInt(24) + "") //2019-05-05 08
      /**
       * 这里的for循环模拟每辆车经过不同的卡扣不同的摄像头 数据。
       */
      for (j <- 1 to (random.nextInt(300) + 1)) {
        //模拟每个车辆每被30个摄像头拍摄后 时间上累计加1小时。这样做使数据更加真实。
        if (j % 30 == 0 && j != 0) {
          var addOneHourTime: Integer = baseActionTime.split(" ")(1).toInt + 1
          if (addOneHourTime == 24) {
            addOneHourTime = 0
            baseActionTime = date + " " + StringUtils.fulFuill(addOneHourTime + "")
          }

          val cameraId: String = StringUtils.fulFuill(5, random.nextInt(100000) + "") //模拟摄像头id cameraId

          val areaId: String = StringUtils.fulFuill(2, Integer.valueOf(cameraId) % 8 + 1 + "") //模拟areaId 【一共8个区域】

          val roadId: String = Integer.valueOf(cameraId) % 50 + 1 + "" //模拟道路id 【1~50 个道路】

          val monitorId: String = StringUtils.fulFuill(4, Integer.valueOf(cameraId) % 9 + 1 + "") //模拟9个卡扣monitorId，0补全4位

          val actionTime: String = baseActionTime + ":" + StringUtils.fulFuill(random.nextInt(60) + "") + ":" + StringUtils.fulFuill(random.nextInt(60) + "") //模拟经过此卡扣开始时间 ，如：2019-05-05 08:10:20

          val speed: String = (random.nextInt(260) + 1) + "" //模拟速度

          val row: Row = RowFactory.create(date, monitorId, cameraId, car, actionTime, speed, roadId, areaId)
          dataList.append(row)
        }
      }
    }
    var rowRdd: RDD[Row] = sc.parallelize(dataList)
    val structType: StructType = StructType(List[StructField](
      StructField("date", StringType, true),
      StructField("monitor_id", StringType, true),
      StructField("camera_id", StringType, true),
      StructField("car", StringType, true),
      StructField("action_time", StringType, true),
      StructField("speed", StringType, true),
      StructField("road_id", StringType, true),
      StructField("area_id", StringType, true)))
    val df: DataFrame = ssc.createDataFrame(rowRdd, structType)
    //默认打印出来df里面的20行数据
    println("----打印 车辆信息数据----")
    println("----打印 row总数----" + df.count())
    df.show()

    df.write.mode(SaveMode.Overwrite).jdbc("jdbc:mysql://node01:3306/traffic", "carTable", properties)

    df.createOrReplaceTempView("monitor_flow_action")
    var ds: Dataset[Row] = df
    ds.write.mode(SaveMode.Overwrite).json("mmmm")

    /**
     * monitorAndCameras
     * key：monitor_id
     * value:hashSet(camera_id)
     * 基于生成的数据，生成对应的卡扣号和摄像头对应基本表
     */
    val monitorAndCameras: mutable.Map[String, mutable.Set[String]] = mutable.Map[String, mutable.Set[String]]()
    var index = 0
    for (row <- dataList) {
      var sets: mutable.Set[String] = monitorAndCameras.get(row.getAs[String](1)).getOrElse(null)
      if (sets == null) {
        sets = mutable.Set[String]()
        monitorAndCameras.put(row.getAs[String](1), sets)
      }
      //这里每隔1000条数据随机插入一条数据，模拟出来标准表中卡扣对应摄像头的数据比模拟数据中多出来的摄像头。
      // 这个摄像头的数据不一定会在车辆数据中有。即可以看出卡扣号下有坏的摄像头。
      index += 1
      if (index % 1000 == 0) {
        val str: String = StringUtils.fulFuill(7, random.nextInt(1000000) + "")
        println(s"------------------------$str")
        sets.add(str);
      }
      val cameraId: String = row.getAs[String](2)
      sets.add(cameraId)
    }
    dataList.clear()

    val monitor_ids: Iterable[String] = monitorAndCameras.keys
    for (monitor_id <- monitor_ids) {
      val camera_ids: mutable.Set[String] = monitorAndCameras.get(monitor_id).get
      var row: Row = null
      for (camera_id <- camera_ids) {
        row = RowFactory.create(monitor_id, camera_id)
        dataList.append(row)
      }
    }
    val monitorSchema: StructType = StructType(List[StructField](
      StructField("monitor_id", StringType, true),
      StructField("camera_id", StringType, true)))
    rowRdd = sc.parallelize(dataList)
    val monitorDF: DataFrame = ssc.createDataFrame(rowRdd, monitorSchema)

    monitorDF.write.mode(SaveMode.Overwrite).jdbc("jdbc:mysql://node01:3306/traffic", "jkTable", properties)

    monitorDF.write.mode(SaveMode.Overwrite).json("nnnnn")
    println("----打印monitorDF总数----" + monitorDF.count())
    monitorDF.createOrReplaceTempView("monitor_camera_info")
    println("----打印 卡扣号对应摄像头号 数据----")
    monitorDF.show()
  }
}
