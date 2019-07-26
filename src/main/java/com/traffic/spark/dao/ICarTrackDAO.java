package com.traffic.spark.dao;

import com.traffic.spark.domain.CarTrack;

import java.util.List;


public interface ICarTrackDAO {
	
	/**
	 * 批量插入车辆轨迹信息
	 * @param carTracks
	 */
	void insertBatchCarTrack(List<CarTrack> carTracks);
}
