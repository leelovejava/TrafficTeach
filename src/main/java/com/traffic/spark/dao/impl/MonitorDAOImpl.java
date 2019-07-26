package com.traffic.spark.dao.impl;

import com.traffic.spark.dao.IMonitorDAO;
import com.traffic.spark.domain.MonitorState;
import com.traffic.spark.domain.TopNMonitor2CarCount;
import com.traffic.spark.domain.TopNMonitorDetailInfo;
import com.traffic.spark.jdbc.JDBCHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 卡口流量监控管理DAO实现类
 * @author root
 *
 */

public class MonitorDAOImpl implements IMonitorDAO {

	@Override
	//向数据库表 topn_monitor_car_count 中插入车流量最多的TopN数据
	public void insertBatchTopN(List<TopNMonitor2CarCount> topNMonitor2CarCounts) {
		 JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		 String sql = "INSERT INTO topn_monitor_car_count VALUES(?,?,?)";
		 List<Object[]> params = new ArrayList<>();
		 for (TopNMonitor2CarCount topNMonitor2CarCount : topNMonitor2CarCounts) {
			 params.add(new Object[]{topNMonitor2CarCount.getTaskId(),topNMonitor2CarCount.getMonitorId(),topNMonitor2CarCount.getCarCount()});
		}
		jdbcHelper.executeBatch(sql , params);
	}

	@Override
	//将topN的卡扣车流量明细数据 存入topn_monitor_detail_info 表中
	public void insertBatchMonitorDetails(List<TopNMonitorDetailInfo> monitorDetailInfos) {
		 JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		 String sql = "INSERT INTO topn_monitor_detail_info VALUES(?,?,?,?,?,?,?,?)";
		 List<Object[]> params = new ArrayList<>();
		 for(TopNMonitorDetailInfo m : monitorDetailInfos){
			 params.add(new Object[]{m.getTaskId(),m.getDate(),m.getMonitorId(),m.getCameraId(),m.getCar(),m.getActionTime(),m.getSpeed(),m.getRoadId()});
		 }
		 jdbcHelper.executeBatch(sql, params);
	}

	@Override
	//向数据库表monitor_state中添加累加器累计的各个值
	public void insertMonitorState(MonitorState monitorState) {
		 JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		 String sql = "INSERT INTO monitor_state VALUES(?,?,?,?,?,?)";
		 Object[] param = new Object[]{
				 monitorState.getTaskId(),
				 monitorState.getNormalMonitorCount(),
				 monitorState.getNormalCameraCount(),
				 monitorState.getAbnormalMonitorCount(),
				 monitorState.getAbnormalCameraCount(),
				 monitorState.getAbnormalMonitorCameraInfos()};
		 List<Object[]> params = new ArrayList<>();
		 params.add(param);
		 jdbcHelper.executeBatch(sql, params);
	}

	@Override
	public void insertBatchTop10Details(List<TopNMonitorDetailInfo> topNMonitorDetailInfos) {
		 JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		 String sql = "INSERT INTO top10_speed_detail VALUES(?,?,?,?,?,?,?,?)";
		 List<Object[]> params = new ArrayList<>();
		 for(TopNMonitorDetailInfo m : topNMonitorDetailInfos){
			 params.add(new Object[]{m.getTaskId(),m.getDate(),m.getMonitorId(),m.getCameraId(),m.getCar(),m.getActionTime(),m.getSpeed(),m.getRoadId()});
		 }
		 jdbcHelper.executeBatch(sql, params);
	}

 
}
