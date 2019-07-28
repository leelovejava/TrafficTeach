package com.com.bjsxt.spark.util

import org.apache.spark.util.AccumulatorV2

import scala.collection.mutable.ListBuffer

/**
 * 正常卡扣数，正常摄像头数，异常卡扣数，异常摄像头数，异常摄像头的详细信息
 */
case class MonitorStatus(var noramlMonitorCount: Int, var noramlCameraCount: Int,
                         var abnoramlMonitorCount: Int, var abnoramlCameraCount: Int,
                         var abnoramlCameraCountInfo: ListBuffer[String]) {}

class SelfDefineAccumulatorScala extends AccumulatorV2[MonitorStatus, MonitorStatus] {
  /**
   * 初始化累计器的值,这个值是最后要在merge合并的时候累加到最终结果内
   */
  var returnResult = MonitorStatus(0, 0, 0, 0, ListBuffer[String]())

  /**
   * 与reset() 方法中保持一致，返回true。
   */
  override def isZero: Boolean = {
    returnResult == MonitorStatus(0, 0, 0, 0, ListBuffer[String]())
  }

  /**
   * 复制一个新的累加器,在这里就是如果用到了就会复制一个新的累加器。
   */
  override def copy(): AccumulatorV2[MonitorStatus, MonitorStatus] = {
    val acc: SelfDefineAccumulatorScala = new SelfDefineAccumulatorScala()
    acc.returnResult = this.returnResult
    acc
  }

  /**
   * 重置AccumulatorV2中的数据，这里初始化的数据是在RDD每个分区内部，每个分区内的初始值。
   */
  override def reset(): Unit = {
    returnResult = MonitorStatus(0, 0, 0, 0, ListBuffer[String]())
    //    true
  }

  /**
   * 每个分区累加数据
   * 这里是拿着初始的result值和每个分区的数据累加
   */
  override def add(v: MonitorStatus): Unit = {
    returnResult = myAdd(returnResult, v)
  }

  /**
   * 分区之间总和累加数据
   * 这里拿着初始的result值 和每个分区最终的结果累加
   *
   */
  override def merge(other: AccumulatorV2[MonitorStatus, MonitorStatus]): Unit = {
    val accumulator: SelfDefineAccumulatorScala = other.asInstanceOf[SelfDefineAccumulatorScala]
    myAdd(returnResult, accumulator.returnResult)
  }

  /**
   * 累计器对外返回的最终的结果
   */
  override def value: MonitorStatus = returnResult

  /**
   * @param returnResult
   * @param v
   * @return
   */
  def myAdd(returnResult: MonitorStatus, v: MonitorStatus): MonitorStatus = {
    returnResult.noramlMonitorCount += v.noramlMonitorCount
    returnResult.noramlCameraCount += v.noramlCameraCount
    returnResult.abnoramlMonitorCount += v.abnoramlMonitorCount
    returnResult.abnoramlCameraCount += v.abnoramlCameraCount
    returnResult.abnoramlCameraCountInfo.appendAll(v.abnoramlCameraCountInfo)
    println(v.abnoramlCameraCountInfo)
    returnResult
  }
}
