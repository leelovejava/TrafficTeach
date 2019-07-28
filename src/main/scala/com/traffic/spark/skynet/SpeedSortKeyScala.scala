package com.traffic.spark.skynet

case class SpeedSortKeyScala(lowSpeed: Int,
                             normalSpeed: Int,
                             mediumSpeed: Int,
                             highSpeed: Int) extends Ordered[SpeedSortKeyScala] {
  override def compare(that: SpeedSortKeyScala): Int = {
    var result: Int = this.highSpeed.compareTo(that.highSpeed)
    if (result == 0) {
      result = this.mediumSpeed.compareTo(that.mediumSpeed)
      if (result == 0) {
        result = this.normalSpeed.compareTo(that.normalSpeed)
        if (result == 0) {
          result = this.lowSpeed.compareTo(that.lowSpeed)
        }
      }
    }
    result
  }
}
