package com.traffic.spark.arearoadflow;

import org.apache.spark.sql.api.java.UDF1;

public class RemoveRandomPrefixUDF implements UDF1<String, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	//1_海淀区：建材城西路
	public String call(String val) throws Exception {
		return val.split("_")[1];
	}

}
