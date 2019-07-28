package com.traffic.spark.skynet

import com.alibaba.fastjson.{JSON, JSONObject}
import com.traffic.spark.conf.ConfigurationManager
import com.traffic.spark.constant.Constants
import com.traffic.spark.dao.{IMonitorDAO, ITaskDAO}
import com.traffic.spark.dao.factory.DAOFactory
import com.traffic.spark.domain.{MonitorState, Task}
import com.traffic.spark.util.{DateUtils, ParamUtils}
import com.com.bjsxt.spark.util.{DateCarCount, DateCarInfos, MonitorStatus, SelfDateCarCountScala, SelfDateCarInfosScala, SelfDefineAccumulatorScala, SparkUtilsScala}
import com.spark.test.MockDataScala
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * 卡扣流量监控模块
 *	 1.检测卡扣状态
 *  2.获取车流排名前N的卡扣号
 *  3.数据库保存累加器5个状态（正常卡扣数，异常卡扣数，正常摄像头数，异常摄像头数，异常摄像头的详细信息）
 *  4.topN 卡口的车流量具体信息存库
 *  5.获取高速通过的TOPN卡扣
 *  6.获取车辆高速通过的TOPN卡扣，每一个卡扣中车辆速度最快的前10名
 *  7.区域碰撞分析
 *  8.卡扣碰撞分析
 *
 * ./spark-submit  --master spark://node1:7077,node2:7077
 * --class com.bjsxt.spark.skynet.MonitorFlowAnalyze
 * --driver-class-path ../lib/mysql-connector-java-5.1.6.jar:../lib/fastjson-1.2.11.jar
 * --jars ../lib/mysql-connector-java-5.1.6.jar,../lib/fastjson-1.2.11.jar
 * ../lib/ProduceData2Hive.jar
 * 1
 *
 * @author root
 *
 */
object MonitorFlowAnalyzeScala {
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
       * 基于本地测试生成模拟测试数据，如果在集群中运行的话，直接操作Hive中的表就可以
       * 本地模拟数据注册成一张临时表
       * monitor_flow_action	数据表：监控车流量所有数据
       * monitor_camera_info	标准表：卡扣对应摄像头标准表
       */
      MockDataScala.MockData(sc, ssc)
    } else {
      println("++++++++++++开启hive的支持+++++++++++++++++")
      ssc = SparkSession.builder().appName(Constants.SPARK_APP_NAME).enableHiveSupport().getOrCreate()
      sc = ssc.sparkContext
      ssc.sql("usr traffic")
    }
    sc.setLogLevel("ERROR")
    /**
     * 从配置文件my.properties中拿到spark.local.taskId.monitorFlow的taskId
     */
    val taskId: Long = ParamUtils.getTaskIdFromArgs(args, Constants.SPARK_LOCAL_TASKID_MONITOR)
    if (taskId == 0L) {
      println("集群提交需要参数 taskId.....")
      System.exit(1)
    }

    /**
     * 获取ITaskDAO的对象，通过taskId查询出来的数据封装到Task（自定义）对象
     */
    val taskDAO: ITaskDAO = DAOFactory.getTaskDAO
    val task: Task = taskDAO.findTaskById(taskId)
    if (task == null) {
      println("没有这个参数taskID")
      System.exit(1) //status 非正常退出程序，终止JVM进程。
    }

    /**
     * task.getTaskParams()是一个json格式的字符串   封装到taskParamsJsonObject
     * 将 task_parm字符串转换成json格式数据。
     */
    val parms: JSONObject = JSON.parseObject(task.getTaskParams())

    /**
     * 通过params（json字符串）查询monitor_flow_action
     * 获取指定日期内检测的monitor_flow_action中车流量数据，返回JavaRDD<Row>
     */
    val cameraDF: DataFrame = SparkUtilsScala.getCameraRDDByDateRange(ssc, parms)

    /**
     * 创建了一个自定义的累加器
     */
    val selfDefineAccumulatorScala = new SelfDefineAccumulatorScala()
    ssc.sparkContext.register(selfDefineAccumulatorScala, "SelfAccumulator")

    /**
     * 将row类型的DF 转换成kv格式的RDD   k:monitor_id  v:row
     */
    val cameraRDD: RDD[Row] = cameraDF.rdd
    val monitor2DetailRDD: RDD[(String, Row)] = cameraRDD.map(row => {
      (row.getAs[String]("monitor_id"), row)
    })

    /**
     * monitor2DetailRDD进行了持久化
     */
    monitor2DetailRDD.cache()

    /**
     * 实时数据
     * 按照卡扣号分组，对应的数据是：每个卡扣号(monitor)对应的Row信息
     * 由于一共有9个卡扣号，这里groupByKey后一共有9组数据。
     * ("0008",("cameraIds=02322,01213,03442|cameraCount=3"))
     * (monitor_id,(count,camera_ids))
     */
    val monitorId2RowsRDD: RDD[(String, Iterable[Row])] = monitor2DetailRDD.groupByKey()

    val aggregateMonitorId2DetailRDD: RDD[(String, (Int, mutable.Set[String]))] = monitorId2RowsRDD.map(tp => {
      val monitorId: String = tp._1
      val rows: Iterator[Row] = tp._2.iterator
      var cameraInfos: mutable.Set[String] = mutable.Set[String]()
      var count = 0
      for (row <- rows) {
        val camera_id: String = row.getAs[String]("camera_id")
        count += 1
        cameraInfos.add(camera_id)
      }
      (monitorId, (count, cameraInfos))
    })
    aggregateMonitorId2DetailRDD.cache()

    /**
     *
     */
    aggregateMonitorId2DetailRDD.reduce((tp1, tp2) => {
      ("aa", (10, tp1._2._2))
    })
    val tuples: Array[(String, (Int, mutable.Set[String]))] = aggregateMonitorId2DetailRDD.collect()
    var count = 0
    tuples.foreach(tp => {
      count += tp._2._1
    })
    val allCarCount: Broadcast[Int] = sc.broadcast(count)

    /**
     * 获取Monitor的DF
     */
    val monitorDF: DataFrame = SparkUtilsScala.getMonitorRDDByDateRange(ssc)

    /**
     * 标准数据
     * aggregateMonitorId2DetailRDD
     * (monitor_id(count,camera_ids))
     */
    val standleMonitorId2DetailRDD: RDD[(String, (Int, mutable.Set[String]))] = monitorDF.rdd.map(row => {
      (row.getAs[String]("monitor_id"), row.getAs[String]("camera_id"))
    }).groupByKey().map(tp => {
      val monitor_id: String = tp._1
      val camera_ids: Iterator[String] = tp._2.iterator
      var carCount = 0;
      val cameraInfos: mutable.Set[String] = mutable.Set[String]()
      for (camera_id <- camera_ids) {
        carCount += 1
        cameraInfos.add(camera_id)
      }
      (monitor_id, (carCount, cameraInfos))
    })
    standleMonitorId2DetailRDD.cache()
    standleMonitorId2DetailRDD.count()

    val leftJoinData: RDD[(String, ((Int, mutable.Set[String]), Option[(Int, mutable.Set[String])]))] = standleMonitorId2DetailRDD.leftOuterJoin(aggregateMonitorId2DetailRDD)

    /**
     * 检测卡扣状态
     * carCount2MonitorRDD
     * K:car_count V:monitor_id
     * RDD(卡扣对应车流量总数,对应的卡扣号)
     */
    val carCount2MonitorRDD: RDD[(Int, String)] = leftJoinData.map(tp => {
      val monitorId: String = tp._1
      //      val value1: ((Int, mutable.Set[String]), Option[(Int, mutable.Set[String])]) = tp._2
      //      val value2: Option[(Int, mutable.Set[String])] = tp._2._2
      //      val value3: (Int, mutable.Set[String]) = tp._2._2.get
      //      val value4: Int = tp._2._2.get._1

      //carCount
      val carCount = allCarCount.value
      //标准的库的cameraInfos
      val BZCameraInfos: List[String] = tp._2._1._2.iterator.toList


      //实时的库的cameraInfos
      val NoBZCameraInfos: List[String] = tp._2._2.get._2.iterator.toList
      //标准的库的cameraCount
      val BZCameraCount: Int = BZCameraInfos.count(_ => {
        true
      })

      //不标准的库的cameraCount
      val NoBZCameraCount: Int = NoBZCameraInfos.count(_ => {
        true
      })

      //正常卡扣数，正常摄像头数，异常卡扣数，异常摄像头数，异常摄像头的详细信息
      if (BZCameraCount == NoBZCameraCount) {
        selfDefineAccumulatorScala.add(MonitorStatus(1,
          BZCameraCount,
          0,
          0,
          ListBuffer[String]()))
      } else {
        //异常的cameraCount
        val YCCameraCount = BZCameraCount - NoBZCameraCount
        //异常的cameraInfos
        val YCCameraInfos: ListBuffer[String] = ListBuffer[String]()

        for (cameraInfo <- BZCameraInfos) {
          //        while (BZCameraInfos.hasNext) {
          //          val cameraInfo: String = BZCameraInfos.next()
          if (!NoBZCameraInfos.contains(cameraInfo)) {
            println(cameraInfo)
            YCCameraInfos.append(cameraInfo)
          }
        }
        selfDefineAccumulatorScala.add(MonitorStatus(0,
          NoBZCameraCount,
          1,
          YCCameraCount,
          YCCameraInfos))
      }
      (carCount, monitorId)
    })

    //    carCount2MonitorRDD.foreach(println)

    /**
     * action 类算子触发以上操作
     *
     */
    carCount2MonitorRDD.count()

    /**
     * 往数据库表  monitor_state 中保存 累加器累加的五个状态
     * 这里面只有一条记录
     */

    val abnoramlCameraCountInfos: ListBuffer[String] = selfDefineAccumulatorScala.returnResult.abnoramlCameraCountInfo
    var infoStr = ""
    for (abnoramlCameraCountInfo <- abnoramlCameraCountInfos) {
      infoStr = infoStr + "~" + abnoramlCameraCountInfo
    }
    println(infoStr)
    val monitorState = new MonitorState(taskId,
      selfDefineAccumulatorScala.returnResult.noramlMonitorCount.toString,
      selfDefineAccumulatorScala.returnResult.noramlCameraCount.toString,
      selfDefineAccumulatorScala.returnResult.abnoramlMonitorCount.toString,
      selfDefineAccumulatorScala.returnResult.abnoramlCameraCount.toString,
      infoStr)

    /**
     * 向数据库表monitor_state中添加累加器累计的各个值
     */
    val monitorDAO: IMonitorDAO = DAOFactory.getMonitorDAO
    monitorDAO.insertMonitorState(monitorState)

    //------------------------------------------------------------------------------------

    /**
     * 获取车流排名前N的卡扣号
     * 并放入数据库表  topn_monitor_car_count 中
     * return  KV格式的RDD  K：monitor_id V:monitor_id
     * 返回的是topN的(monitor_id,monitor_id)
     */
    //    val sortRdd: RDD[(Int, String)] = carCount2MonitorRDD.sortByKey(false)
    //    sortRdd.foreach(println)

    /**
     * 获取top5 卡口的车流量具体信息，存入数据库表 topn_monitor_detail_info 中
     */
    //    val topMonitor: Array[String] = sortRdd.map(_._2).collect()
    //    val top5: Array[String] = Array[String](topMonitor(0), topMonitor(1), topMonitor(2), topMonitor(3), topMonitor(4))
    //    val top5Broadcast: Broadcast[Array[String]] = sc.broadcast(top5)
    //
    //    val top5Infos: RDD[(String, Row)] = monitor2DetailRDD.filter(tp => {
    //      top5Broadcast.value.contains(tp._1)
    //    })
    //    top5Infos.foreach(println)

    /**
     * 获取车辆高速通过的TOPN卡扣
     */
    //    val speedSort: RDD[(String, Iterable[SpeedSortKeyScala])] = monitor2DetailRDD.map(tp => {
    //      var lowSpeed = 0
    //      var normalSpeed = 0
    //      var mediumSpeed = 0
    //      var highSpeed = 0
    //      val speed: Int = Integer.valueOf(tp._2.getAs[String]("speed"))
    //      if (speed >= 0 && speed < 60) {
    //        lowSpeed += 1
    //      }
    //      else if ((speed >= 60 && speed < 90)) {
    //        normalSpeed += 1
    //      }
    //
    //      else if (speed >= 90 && speed < 120) {
    //        mediumSpeed += 1
    //      }
    //      else {
    //        highSpeed += 1
    //      }
    //      (tp._1, new SpeedSortKeyScala(lowSpeed, normalSpeed, mediumSpeed, highSpeed))
    //    }).sortBy(_._2).groupByKey()
    //    println("println(获取车辆高速通过的TOPN卡扣)")
    //    speedSort.foreach(println)

    /**
     * 获取车辆高速通过的TOPN卡扣，每一个卡扣中车辆速度最快的前10名，并存入数据库表 top10_speed_detail 中
     */
    //    val top10HightSpeed: RDD[(String, Row)] = monitor2DetailRDD.sortBy(tp => {
    //      Integer.valueOf(tp._2.getAs[String]("speed"))
    //    }, false)
    //    val top10HigtCar: RDD[(String, Iterator[Row])] = top10HightSpeed.groupByKey().map(tp => {
    //      val hightRows: ListBuffer[Row] = ListBuffer[Row]()
    //      val sortRow: Iterator[Row] = tp._2.iterator
    //      var top = 10;
    //      for (row <- sortRow) {
    //        if (top > 0) {
    //          hightRows.append(row)
    //          top -= 1
    //        }
    //      }
    //      (tp._1, hightRows.iterator)
    //    })
    //    println("获取车辆高速通过的TOPN卡扣，每一个卡扣中车辆速度最快的前10名，并存入数据库表 top10_speed_detail 中")
    //    top10HigtCar.foreach(tp => {
    //      val iterable: Iterable[Row] = tp._2.toIterable
    //      for (iter <- iterable) {
    //        println(s"卡扣为${tp._1}最高速的车有$iter")
    //      }
    //    })

    /**
     * 区域碰撞分析,直接打印显示出来。
     * "0001","0002" 指的是两个区域
     * 同一时间段内不同卡扣下出现的相同车辆（比如卡扣0001，0002）
     * 同一时间段内不同区域出现的相同车辆（比如区域01，区域02）
     */
    //        //0001下出现的车辆
    //        val car0001: RDD[String] = monitor2DetailRDD.filter(tp => {
    //          tp._1.equals("0001")
    //        }).map(tp => {
    //          tp._2.getAs[String]("car")
    //        }).distinct()
    //        //0002下出现的车辆
    //        val car0002: RDD[String] = monitor2DetailRDD.filter(tp => {
    //          tp._1.equals("0002")
    //        }).map(tp => {
    //          tp._2.getAs[String]("car")
    //        }).distinct()
    //        val sameCar: RDD[String] = car0001.intersection(car0002)
    //        sameCar.foreach(car=>{println(s"0001和0002卡扣下同时出现的车辆有$car")})

    /**
     * 0001下的车辆轨迹分析
     */
    //    val guiJi: RDD[(String, Iterable[Row])] = monitor2DetailRDD.filter(_._1.endsWith("0001"))
    //      .map(tp=>{(tp._2.getAs[String]("car"),tp._2)})
    //      .sortBy(_._2.getAs[String]("action_time"))
    //      .groupByKey()
    //    guiJi.foreach(tp=>{
    //      println(s"${tp._1}车的轨迹是-----------------------------------------")
    //      val iter: Iterator[Row] = tp._2.iterator
    //      while (iter.hasNext){
    //        println(iter.next())
    //      }
    //    })

    //--------------------------------------------------------------------------------------------------------------------------
    /**
     * 随机抽取10%的车辆统计轨迹
     */

    /**
     * 把所有的row数据转化为  (date,row) 格式
     */
    val dateRowRdd: RDD[(String, Row)] = monitor2DetailRDD.map(tp => {
      val date: String = DateUtils.getDateHour(tp._2.getAs[String]("action_time")).split("_")(0)
      (date, tp._2)
    })
    dateRowRdd.cache()

    /**
     * dateCar 把哪天通过了那些车记录下来
     * 转为((date,car)格式并去重方便后面计算
     */
    val dateCar: RDD[(String, String)] = dateRowRdd.map(tp => {
      (tp._1, tp._2.getAs[String]("car"))
    }).distinct()

    /**
     * 自定义累加器统计每天需要的抽样carCount
     * 数据格式 (date:carCount)
     * 比如2019年6月9日 需要抽样100辆车
     */
    val selfDateCarCountScala: SelfDateCarCountScala = new SelfDateCarCountScala()
    sc.register(selfDateCarCountScala, "selfDateCarCountScala")

    //计算出每天需要统计多少car 放入自定义累加器中
    dateCar.countByKey().foreach(tp => {
      val date: String = tp._1
      val carCount: Long = (tp._2 * 0.1).toLong
      selfDateCarCountScala.add(DateCarCount(mutable.Map[String, Long]((date, carCount))))
    })

    /**
     * 将累加器中的值保存下来，避免累加器重复累加，并广播出去
     */
    val dateCarCountMap: mutable.Map[String, Long] = selfDateCarCountScala.returnResult.dateCarCountMap
    val dateCarCount: Broadcast[mutable.Map[String, Long]] = sc.broadcast(dateCarCountMap)

    /**
     * 自定义累加器selfDateCarInfosScala 存入每天抽样的carInfo
     * 数据格式 (date:List(car,car,car))
     * *比如2019年6月9日 需要抽样的车有川A12131，京A12312
     */
    val selfDateCarInfosScala: SelfDateCarInfosScala = new SelfDateCarInfosScala()
    sc.register(selfDateCarInfosScala, "selfDateCarInfosScala")

    /**
     * 计算出每天统计出来的car 放入 selfDateCarInfosScala中  数据格式为 (date,list(car))
     * 最后的count仅用于触发
     */
    dateRowRdd.sortBy(_._2.getAs[String]("action_time"))
      .groupByKey()
      .map(tp => {
        val date: String = tp._1
        val carRows: Iterator[Row] = tp._2.iterator
        var allCarCount = 0
        //如果没有值默认给100，不过应该都有值
        val chouYangCount: Long = dateCarCount.value.get(date).getOrElse(100)
        while (carRows.hasNext) {
          carRows.next()
          if (allCarCount % chouYangCount == 0) {
            selfDateCarInfosScala.add(new DateCarInfos(mutable.Map[String, ListBuffer[String]]((date, ListBuffer[String](carRows.next().getAs[String]("car"))))))
          }
          allCarCount += 1
        }
      }).count()

    /**
     * 取出累加器中的值避免重复计算,并广播出去
     */
    val dateCarInfosMap: mutable.Map[String, ListBuffer[String]] = selfDateCarInfosScala.returnResult.dateCarInfosMap
    val dateCarInfos: Broadcast[mutable.Map[String, ListBuffer[String]]] = sc.broadcast(dateCarInfosMap)

    // 先过滤再通过时间排序
    val result: RDD[(String, Iterable[Row])] = dateRowRdd.filter(tp => {
      val date: String = tp._1
      dateCarInfos.value.contains(date) && dateCarInfos.value.get(date).get.contains(tp._2.getAs[String]("car"))
    }).sortBy(_._2.getAs[String]("action_time")).groupByKey()
    result.count()


    result.foreach(tp => {
      println(s"在${tp._1}这天-------------------------------------")
      val rows: Iterator[Row] = tp._2.iterator
      rows.foreach(row => {
        println(s"${row.getAs[String]("car")}的行车信息为$row")
      })
    })
  }
}
