package com.traffic.spark.skynet;

import com.traffic.spark.constant.Constants;
import com.traffic.spark.util.StringUtils;
import org.apache.spark.util.AccumulatorV2;

public class SelfDefineAccumulator extends AccumulatorV2<String, String> {
    String returnResult = "";

    /**
     * 与reset() 方法中保持一致，返回true。
     *
     * @return
     */
    @Override
    public boolean isZero() {
        //normalMonitorCount=0|normalCameraCount=0|abnormalMonitorCount=0|abnormalCameraCount=0|abnormalMonitorCameraInfos=
        return "normalMonitorCount=0|normalCameraCount=0|abnormalMonitorCount=0|abnormalCameraCount=0|abnormalMonitorCameraInfos= ".equals(returnResult);
    }

    @Override
    public AccumulatorV2<String, String> copy() {
        SelfDefineAccumulator acc = new SelfDefineAccumulator();
        acc.returnResult = this.returnResult;
        return acc;
    }

    /**
     * 每个分区初始值
     */
    @Override
    public void reset() {
        //normalMonitorCount=0|normalCameraCount=0|abnormalMonitorCount=0|abnormalCameraCount=0|abnormalMonitorCameraInfos=
        returnResult = Constants.FIELD_NORMAL_MONITOR_COUNT + "=0|"
                + Constants.FIELD_NORMAL_CAMERA_COUNT + "=0|"
                + Constants.FIELD_ABNORMAL_MONITOR_COUNT + "=0|"
                + Constants.FIELD_ABNORMAL_CAMERA_COUNT + "=0|"
                + Constants.FIELD_ABNORMAL_MONITOR_CAMERA_INFOS + "= ";
    }

    /**
     * 每个分区会拿着 reset 初始化的值 ，在各自的分区内相加
     *
     * @param v
     */
    @Override
    public void add(String v) {
//        System.out.println("add returnResult ="+returnResult+", v="+v);
        returnResult = myAdd(returnResult, v);
    }

    /**
     * 每个分区最终的结果和初始值 returnResult=""  做累加
     *
     * @param other
     */
    @Override
    public void merge(AccumulatorV2<String, String> other) {
        //这里初始值就是 "" ,每个分区之后都是一个大的字符串

        SelfDefineAccumulator accumulator = (SelfDefineAccumulator) other;
//        System.out.println("merge   returnResult="+returnResult+" , accumulator.returnResult="+accumulator.returnResult);
        returnResult = myAdd(returnResult, accumulator.returnResult);
    }

    @Override
    public String value() {
        return returnResult;
    }


    private String myAdd(String v1, String v2) {
//        System.out.println("myAdd v1="+v1);
//        System.out.println("myAdd v2="+v2);
        if (StringUtils.isEmpty(v1)) {
            return v2;
        }
        String[] valArr = v2.split("\\|");
        for (String string : valArr) {
            String[] fieldAndValArr = string.split("=");
            String field = fieldAndValArr[0];
            String value = fieldAndValArr[1];
            String oldVal = StringUtils.getFieldFromConcatString(v1, "\\|", field);
            if (oldVal != null) {
                //只有这个字段是string，所以单独拿出来
                if (Constants.FIELD_ABNORMAL_MONITOR_CAMERA_INFOS.equals(field)) {
                    if (value.startsWith(" ~")) {
                        value = value.substring(2);
                    }
                    v1 = StringUtils.setFieldInConcatString(v1, "\\|", field, oldVal + "~" + value);
                } else {
                    //其余都是int类型，直接加减就可以
                    int newVal = Integer.parseInt(oldVal) + Integer.parseInt(value);
                    v1 = StringUtils.setFieldInConcatString(v1, "\\|", field, String.valueOf(newVal));
                }
            }
        }
        return v1;
    }
}
