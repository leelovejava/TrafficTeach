package com.bjsxt.spark.arearoadflow;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.spark.sql.Row;
import org.apache.spark.sql.expressions.MutableAggregationBuffer;
import org.apache.spark.sql.expressions.UserDefinedAggregateFunction;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;

import com.bjsxt.spark.util.StringUtils;

/**
 * 组内拼接去重函数（group_concat_distinct()）
 * <p>
 * 技术点：自定义UDAF聚合函数
 *
 * @author Administrator
 */
public class GroupConcatDistinctUDAF extends UserDefinedAggregateFunction {

    private static final long serialVersionUID = -2510776241322950505L;

    /**
     * 指定输入数据的字段与类型
     */
    private StructType inputSchema = DataTypes.createStructType(Arrays.asList(
            DataTypes.createStructField("carInfo", DataTypes.StringType, true)));
    /**
     * 指定缓冲数据的字段与类型
     */
    private StructType bufferSchema = DataTypes.createStructType(Arrays.asList(
            DataTypes.createStructField("bufferInfo", DataTypes.StringType, true)));
    /**
     * 指定返回类型
     */
    private DataType dataType = DataTypes.StringType;
    // 指定是否是确定性的
    private boolean deterministic = true;

    /**
     * 输入数据的类型
     */
    @Override
    public StructType inputSchema() {
        return inputSchema;
    }

    /**
     * 聚合操作的数据类型
     */
    @Override
    public StructType bufferSchema() {
        return bufferSchema;
    }

    @Override
    public boolean deterministic() {
        return deterministic;
    }

    /**
     * 初始化
     * 可以认为是，你自己在内部指定一个初始的值
     */
    @Override
    public void initialize(MutableAggregationBuffer buffer) {
        buffer.update(0, "");
    }

    /**
     * 更新
     * 可以认为是，一个一个地将组内的字段值传递进来
     * 实现拼接的逻辑
     */
    @Override
    public void update(MutableAggregationBuffer buffer, Row input) {
        // 缓冲中的已经拼接过的monitor信息小字符串
        //|0001=1000|0002=2000|0003=3000
        String bufferMonitorInfo = buffer.getString(0);
        // 刚刚传递进来的某个车辆信息
        String inputMonitorInfo = input.getString(0);

        String[] split = inputMonitorInfo.split("\\|");
        String monitorId;
        int addNum = 1;
        for (String string : split) {
            if (string.indexOf("=") != -1) {
                monitorId = string.split("=")[0];
                addNum = Integer.parseInt(string.split("=")[1]);
            } else {
                monitorId = string;
            }
            String oldVS = StringUtils.getFieldFromConcatString(bufferMonitorInfo, "\\|", monitorId);
            if (oldVS == null) {
                bufferMonitorInfo += "|" + monitorId + "=" + addNum;
            } else {
                bufferMonitorInfo = StringUtils.setFieldInConcatString(bufferMonitorInfo, "\\|", monitorId, Integer.parseInt(oldVS) + addNum + "");
            }
            buffer.update(0, bufferMonitorInfo);
        }
    }

    /**
     * 合并
     * update操作，可能是针对一个分组内的部分数据，在某个节点上发生的
     * 但是可能一个分组内的数据，会分布在多个节点上处理
     * 此时就要用merge操作，将各个节点上分布式拼接好的串，合并起来
     * merge1:|0001=100|0002=20|0003=4
     * merge2:|0001=200|0002=30|0003=3
     * <p>
     * 海淀区 建材城西路1
     * 海淀区 建材城西路2
     */
    @Override
    public void merge(MutableAggregationBuffer buffer1, Row buffer2) {
        //缓存中的monitor信息这个大字符串
        String bufferMonitorInfo1 = buffer1.getString(0);
        //传进来
        String bufferMonitorInfo2 = buffer2.getString(0);

        // 等于是把buffer2里面的数据都拆开来更新
        for (String monitorInfo : bufferMonitorInfo2.split("\\|")) {
            /**
             * monitor_id1 100
             * monitor_id2 88
             *
             *
             */
            Map<String, String> map = StringUtils.getKeyValuesFromConcatString(monitorInfo, "\\|");
            for (Entry<String, String> entry : map.entrySet()) {
                String monitor = entry.getKey();
                int carCount = Integer.parseInt(entry.getValue());
                String oldVS = StringUtils.getFieldFromConcatString(bufferMonitorInfo1, "\\|", monitor);
                //当没有获取到本次monitor对应的值时
                if (oldVS == null) {
                    if ("".equals(bufferMonitorInfo1)) {
                        //当第一次聚合的时候，没有初始的传进来的bufferMonitorInfo1，默认为""
                        bufferMonitorInfo1 += monitor + "=" + carCount;
                    } else {
                        //当上一次传进来的字符串不包含本次的monitor时，就拼上
                        bufferMonitorInfo1 += "|" + monitor + "=" + carCount;
                    }
                } else {
                    int oldVal = Integer.valueOf(oldVS);
                    oldVal += carCount;
                    bufferMonitorInfo1 = StringUtils.setFieldInConcatString(bufferMonitorInfo1, "\\|", monitor, oldVal + "");
                }
                buffer1.update(0, bufferMonitorInfo1);
            }
        }
    }

    @Override
    public DataType dataType() {
        return dataType;
    }

    /**
     * evaluate方法返回数据的类型要和dateType的类型一致，不一致就会报错
     */
    @Override
    public Object evaluate(Row row) {
        return row.getString(0);
    }

}
