package com.traffic.spark.areaRoadFlow

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * 无聊测试代码
 * 测试groupByKey对分区是否有影响
 */
object TestGroupByKey {
  def main(args: Array[String]): Unit = {
    //    val conf = new SparkConf().setMaster("local[8]").setAppName("test")
    val conf = new SparkConf().setAppName("test")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val lines: RDD[String] = sc.parallelize(List[String](
      "zhangshan,A,100",
      "zhangshan,B,99",
      "zhangshan,C,98",
      "zhangshan,D,97",
      "lisi,Z,1",
      "lisi,X,2",
      "lisi,V,3",
      "lisi,O,4"
    ))
    val nameKemu: RDD[(String, Int)] = lines.map(str => {
      val split: Array[String] = str.split(",")
      ((split(0) + "-" + split(1)), split(2).toInt)
    })
    val nameKemuReduce: RDD[(String, Int)] = nameKemu.reduceByKey(_ + _, 8)
      .sortBy(_._2, false, 8)
    //    nameKemuReduce.mapPartitionsWithIndex((index: Int, iter: Iterator[(String, Int)]) => {
    //      val list: List[(String, Int)] = iter.toList
    //      for (oneTp <- list) {
    //        println(s"分区是    $index    名字班级是   ${oneTp._1}      分数是    ${oneTp._2} ")
    //      }
    //      list.iterator
    //    }).count()
    val tempResult: RDD[(String, (String, Int))] = nameKemuReduce.map(tp => {
      val nameKecen: String = tp._1
      val fenshu: Int = tp._2.toInt
      val split: Array[String] = nameKecen.split("-")
      (split(0), (split(1), fenshu))
    })

    /**
     * 1、搜集后在excutor里面打印
     */
    tempResult.groupByKey(8).foreach(println)

    /**
     * 2、搜集后在excutor取出前三个打印
     */
    //    tempResult.groupByKey().foreach(tp=>{
    //      val list: List[(String, Int)] = tp._2.toList
    //      for(a<-list){
    //        println(s"搜集后在excutor取出前三个打印----key = ${tp._1}---value = $a")
    //      }
    //    })
    //
    //
    //    val res: RDD[(String, Iterable[(String, Int)])] = tempResult.groupByKey()
    //    res.foreach(println)
    ////    res.collect().foreach(println)
    //
    //
    //    val rdd: RDD[(String, Iterator[(String, Int)])] = tempResult.groupByKey().map(tp => {
    //      val list: List[(String, Int)] = tp._2.toList
    //      val list01: List[(String, Int)] = list.sortBy(_._2)
    //      (tp._1, list01.iterator)
    //    })
    //    rdd.foreach(tp => {
    //      val list: List[(String, Int)] = tp._2.toList
    //      for (a <- list) {
    //        println(s"key = ${tp._1}----value = $a")
    //      }
    //    })
  }
}
