package com.traffic.spark.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.traffic.spark.conf.ConfigurationManager;
import com.traffic.spark.constant.Constants;

/**
 * 参数工具类
 *
 * @author Administrator
 */
public class ParamUtils {

    /**
     * 从命令行参数中提取任务id
     *
     * @param args     命令行参数
     * @param taskType 参数类型(任务id对应的值是Long类型才可以)，对应my.properties中的key
     * @return 任务id
     * spark.local.taskId.monitorFlow
     */
    public static Long getTaskIdFromArgs(String[] args, String taskType) {
        boolean local = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);

        if (local) {
            return ConfigurationManager.getLong(taskType);
        } else {
            try {
                if (args != null && args.length > 0) {
                    return Long.valueOf(args[0]);
                } else {
                    System.out.println("集群提交任务，需要参数");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    /**
     * 从JSON对象中提取参数
     *
     * @param jsonObject JSON对象
     * @return 参数
     * {"name":"zhangsan","age":"18"}
     */
    public static String getParam(JSONObject jsonObject, String field) {
        JSONArray jsonArray = jsonObject.getJSONArray(field);
        if (jsonArray != null && jsonArray.size() > 0) {
            return jsonArray.getString(0);
        }
        return null;
    }

}
