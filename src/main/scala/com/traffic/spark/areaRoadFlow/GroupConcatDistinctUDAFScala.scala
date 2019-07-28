package com.traffic.spark.areaRoadFlow

import org.apache.spark.sql.Row
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, DataTypes, IntegerType, MapType, StringType, StructType}

import scala.collection.mutable

/**
  * 组内拼接去重函数（group_concat_distinct()）
  *
  * 技术点：自定义UDAF聚合函数
  *
  * @author LPF
  *
  */
class GroupConcatDistinctUDAFScala extends UserDefinedAggregateFunction {
  /**
    * 输入数据的类型   注意数据类型
    */
  override def inputSchema: StructType = {
    DataTypes.createStructType(Array(DataTypes.createStructField("xx", StringType, true)))
  }

  /**
    * 聚合操作时，所处理的数据的类型
    */
  override def bufferSchema: StructType = {
    DataTypes.createStructType(Array(DataTypes.createStructField("oo", MapType(StringType, IntegerType), true)))
  }

  /**
    * 最终函数返回值的类型
    */
  override def dataType: DataType = {
    DataTypes.StringType
  }

  /**
    * 多次运行 相同的输入总是相同的输出，确保一致性
    */
  override def deterministic: Boolean = {
    true
  }

  /**
    * 为每个分组的数据执行初始化值
    * 两个部分的初始化：
    *   1.在map端每个RDD分区内，在RDD每个分区内 按照group by 的字段分组，每个分组都有个初始化的值
    *   2.在reduce 端给每个group by 的分组做初始值
    */
  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = mutable.Map[String, Int]()
  }

  /**
    * 每个组，有新的值进来的时候，进行分组对应的聚合值的计算
    */
  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    //    取出每个组里面初始化的Map转换成mutableMap经行计算
    val map: collection.Map[String, Int] = buffer.getMap(0)
    val returnMap: mutable.Map[String, Int] = collection.mutable.Map(map.toSeq: _*)
    //    取出输入的MonitorID
    val inputMonitorInfo: String = input.getString(0)
    if (!returnMap.contains(inputMonitorInfo)) {
      //    如果map里没有次MonitorID就放一个初始count为1的进去
      returnMap.put(inputMonitorInfo, 1)
    } else {
      //      如果有了此MonitorID就取出count，count+1放回去
      val count: Int = returnMap.get(inputMonitorInfo).get
      returnMap.put(inputMonitorInfo, count + 1)
    }
    buffer.update(0, returnMap)
  }


  /**
    * 最后merger的时候，在各个节点上的聚合值，要进行merge，也就是合并
    */
  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    //    缓冲的总的map
    val allMap: collection.Map[String, Int] = buffer1.getMap(0)
    val returnAllMap: mutable.Map[String, Int] = collection.mutable.Map(allMap.toSeq: _*)
    //    传进来的map
    val inputMap: collection.Map[String, Int] = buffer2.getMap(0)

    //    遍历inputMap 将里面的值添加进returnAllMap中缓存
    for (key <- inputMap.keys) {
      if (!returnAllMap.contains(key)) {
        returnAllMap.put(key, inputMap.get(key).get)
      } else {
        val allCount: Int = returnAllMap.get(key).get
        val someCount: Int = inputMap.get(key).get
        returnAllMap.put(key, allCount + someCount)
      }
    }
    buffer1.update(0, returnAllMap)
  }


  /**
    * 最后返回一个最终的聚合值要和dataType的类型一一对应
    */
  override def evaluate(buffer: Row): Any = {
    val map: collection.Map[String, Int] = buffer.getMap(0)
    var str: String = ""
    for (key <- map.keys) {
      str = "|" + key + "-" + map.get(key).get + str
    }
    str.substring(1)
  }
}
