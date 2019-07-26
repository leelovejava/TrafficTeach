package com.traffic.spark.dao;

import com.traffic.spark.domain.RandomExtractCar;
import com.traffic.spark.domain.RandomExtractMonitorDetail;

import java.util.List;

/**
 * 随机抽取car信息管理DAO类
 * @author root
 *
 */
public interface IRandomExtractDAO {
	void insertBatchRandomExtractCar(List<RandomExtractCar> carRandomExtracts);
	
	void insertBatchRandomExtractDetails(List<RandomExtractMonitorDetail> r);
	
}
