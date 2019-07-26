package com.traffic.spark.skynet;

import com.traffic.spark.constant.Constants;
import com.traffic.spark.util.StringUtils;
import org.apache.spark.AccumulatorParam;

/**
 * 自定义累加器要实现AccumulatorParam接口
 *
 * @author root
 */
public class MonitorAndCameraStateAccumulator implements AccumulatorParam<String> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    /**
     * 初始化RDD每个分区的值
     * init：调用SparkContext.accululator时传递的initialValue，就是""
     * return返回累加器每个分区中的初始值。
     */
    @Override
    public String zero(String init) {
        /**
         * "normalMonitorCount=0|normalCameraCount=0|abnormalMonitorCount=0|abnormalCameraCount=0|abnormalMonitorCameraInfos=' '"
         */
        return Constants.FIELD_NORMAL_MONITOR_COUNT + "=0|"
                + Constants.FIELD_NORMAL_CAMERA_COUNT + "=0|"
                + Constants.FIELD_ABNORMAL_MONITOR_COUNT + "=0|"
                + Constants.FIELD_ABNORMAL_CAMERA_COUNT + "=0|"
                + Constants.FIELD_ABNORMAL_MONITOR_CAMERA_INFOS + "= " + init;
    }


    /**
     * v1就是上次累加后的结果,第一次调用的时候就是zero方法return的值,v2是传进来的字符串
     * <p>
     * v1:normalMonitorCount=0|normalCameraCount=0|abnormalMonitorCount=0|abnormalCameraCount=0|abnormalMonitorCameraInfos=' '
     * v2:abnormalMonitorCount=1|abnormalCameraCount=3|abnormalMonitorCameraInfos="0002":07553,07554,07556
     **/
    @Override
    public String addAccumulator(String v1, String v2) {
        return myAdd(v1, v2);
    }

    /**
     * addAccumulator方法之后，最后会执行这个方法，将每个分区最后的value加到初始化的值。
     * 这里的initValue就是我们初始化的值那个“”。v2是已经经过addAccumulator这个方法累加后每个分区处理的值。
     */
    @Override
    public String addInPlace(String initValue, String v2) {
//		System.out.println("initValue ="+initValue);
//		System.out.println("v2 ="+v2);
        return myAdd(initValue, v2);
    }

    /**
     * @param v1 连接串,上次累加后的结果
     * @param v2 本次累加传入的值
     * @return 更新以后的连接串
     * <p>
     * v1:normalMonitorCount=0|normalCameraCount=0|abnormalMonitorCount=1|abnormalCameraCount=3|
     * abnormalMonitorCameraInfos= ~"0002":07553,07554,07556~"0008":11111,22222~"0004":07553,07554,07556~"0000":12891,13024
     * v2:normalMonitorCount=8|normalCameraCount=3|abnormalMonitorCount=2|abnormalCameraCount=4|
     * abnormalMonitorCameraInfos=
     */
    private String myAdd(String v1, String v2) {
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
