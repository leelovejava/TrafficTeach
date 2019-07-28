package com.com.bjsxt.spark.util

import org.apache.spark.util.AccumulatorV2

import scala.collection.mutable

/**
  * map -> (date,carCount)
  */
case class DateCarCount(dateCarCountMap: mutable.Map[String, Long])

class SelfDateCarCountScala extends AccumulatorV2[DateCarCount, DateCarCount] {
  /**
    * 初始化累计器的值,这个值是最后要在merge合并的时候累加到最终结果内
    */
  var returnResult = DateCarCount(mutable.Map[String, Long]())

  /**
    * 与reset() 方法中保持一致，返回true。
    */
  override def isZero: Boolean = {
    returnResult == DateCarCount(mutable.Map[String, Long]())
  }

  /**
    * 复制一个新的累加器,在这里就是如果用到了就会复制一个新的累加器。
    */
  override def copy(): AccumulatorV2[DateCarCount, DateCarCount] = {
    val acc: SelfDateCarCountScala = new SelfDateCarCountScala()
    acc.returnResult = this.returnResult
    acc
  }

  /**
    * 重置AccumulatorV2中的数据，这里初始化的数据是在RDD每个分区内部，每个分区内的初始值。
    */
  override def reset(): Unit = {
    returnResult = DateCarCount(mutable.Map[String, Long]())
  }


  /**
    * 每个分区累加数据
    * 这里是拿着初始的result值和每个分区的数据累加
    */
  override def add(v: DateCarCount): Unit = {
    returnResult = myAdd(returnResult, v)
  }

  /**
    * 分区之间总和累加数据
    * 这里拿着初始的result值 和每个分区最终的结果累加
    *
    */
  override def merge(other: AccumulatorV2[DateCarCount, DateCarCount]): Unit = {
    val v: SelfDateCarCountScala = other.asInstanceOf[SelfDateCarCountScala]
    returnResult = myAdd(returnResult, v.returnResult)
  }

  /**
    * 累计器对外返回的最终的结果
    */
  override def value: DateCarCount = returnResult

  /**
    *
    * @param returnResult
    * @param v
    * @return
    */
  def myAdd(returnResult: DateCarCount, v: DateCarCount): DateCarCount = {
    val map: mutable.Map[String, Long] = v.dateCarCountMap
    map.foreach(mp => {
      val key: String = mp._1
      val value: Long = mp._2
      returnResult.dateCarCountMap.put(key, value)
    })
    returnResult
  }
}
