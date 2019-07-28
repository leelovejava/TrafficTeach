package com.traffic.spark.areaRoadFlow

import com.spark.test.MockDataByMysql
import com.traffic.spark.conf.ConfigurationManager
import com.traffic.spark.constant.Constants
import org.apache.spark.SparkContext
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
 * ！！！！！！！！！！！！！！！MYSQL数据库首先要有数据！！！！！！！！！！！！！！！！！！！！！
 * * ！！！！！次方法生成视图的！！！！！！！！！！MockDataByMysql.MockData(sc, ssc)
 * ！！！！！！！！！！！！！！！！！！！！！！！！采用开窗函数！！！！！！！！！！！！！！！！！！！！！！！！！！！
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
 **/
object AreaTop3RoadFlowAnalyzeScala2 {
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
      ssc = SparkSession.builder().appName(Constants.SPARK_APP_NAME)
        .config("spark.sql.autoBroadcastJoinThreshold", "1048576000").enableHiveSupport().getOrCreate()
      sc = ssc.sparkContext
      ssc.sql("usr traffic")
    }
    sc.setLogLevel("ERROR")

    ssc.udf.register("group_concat_distinct", new GroupConcatDistinctUDAFScala())
    val result: DataFrame = ssc.sql(
      """
        | select
        |	temp.area_name,temp.road_id,temp.carCount,temp.monitor_infos,row_number() over(partition by area_name order by carCount desc) as rank
        | from
        |	(SELECT
        |		area_name,road_id,COUNT(car) carCount,group_concat_distinct(monitor_id) monitor_infos
        |	FROM
        |		monitor_flow_action t1 LEFT JOIN area_info t2
        |	ON
        |		t1.area_id=t2.area_id GROUP BY area_name,road_id) temp
        | HAVING rank <=3
      """.stripMargin)
    result.show(24, false)



    //    val result: DataFrame = ssc.sql(
    //      """
    //        |  SELECT area_name,road_id,COUNT(car) carCount,group_concat_distinct(monitor_id) monitor_infos
    //        |  FROM monitor_flow_action t1 LEFT JOIN area_info t2
    //        |  ON t1.area_id=t2.area_id
    //        |  GROUP BY area_name,road_id
    //      """.stripMargin
    //      )
    //    result.show(1000)

    //    val result: DataFrame = ssc.sql("SELECT " +
    //      "area_name,road_id,COUNT(car) carCount " +
    //      "FROM monitor_flow_action t1 LEFT JOIN area_info t2 ON t1.area_id=t2.area_id GROUP BY area_name,road_id ")
    //    result.show(100)
  }
}
