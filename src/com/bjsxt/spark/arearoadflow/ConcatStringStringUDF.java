package com.bjsxt.spark.arearoadflow;

import org.apache.spark.sql.api.java.UDF3;

/**
 * 将两个字段拼接起来（使用指定的分隔符）
 * @author Administrator
 *
 */
public class ConcatStringStringUDF implements UDF3<String, String, String, String> {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String call(String area_name, String road_id, String split) throws Exception {
		return area_name + split + road_id;
	}

}
