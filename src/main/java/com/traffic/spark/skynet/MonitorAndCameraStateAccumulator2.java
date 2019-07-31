package com.traffic.spark.skynet;

import org.apache.spark.util.AccumulatorV2;

/**
 * Spark2 自定义累加器
 * @author  tianhao
 */
public class MonitorAndCameraStateAccumulator2 extends AccumulatorV2<String, String> {
    /**
     * 判断是否为初始值
     *
     * @return
     */
    @Override
    public boolean isZero() {
        return false;
    }


    /**
     * 拷贝累加器
     *
     * @return
     */
    @Override
    public AccumulatorV2 copy() {
        return null;
    }

    /**
     * 重置累加器中的值
     */
    @Override
    public void reset() {

    }

    /**
     * 获取累加器中的值
     *
     * @return
     */
    @Override
    public String value() {
        return null;
    }

    /**
     * 对各个task的累加器进行合并
     *
     * @param other
     */
    @Override
    public void merge(AccumulatorV2 other) {

    }

    @Override
    public void add(String v) {

    }
}
