package com.bjsxt.spark.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.spark.dao.IAreaDao;
import com.bjsxt.spark.domain.Area;
import com.bjsxt.spark.domain.Task;
import com.bjsxt.spark.jdbc.JDBCHelper;
import com.bjsxt.spark.jdbc.JDBCHelper.QueryCallback;

public class AreaDaoImpl implements IAreaDao {

	@Override
	public List<Area> findAreaInfo() {
		final List<Area> areas = new ArrayList<>();
		
		String sql = "SELECT * FROM area_info";
		
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		jdbcHelper.executeQuery(sql, null, new QueryCallback() {
			
			@Override
			public void process(ResultSet rs) throws Exception {
				if(rs.next()) {
					String areaId = rs.getString(1);
					String areaName = rs.getString(2);
					areas.add(new Area(areaId, areaName));
				}
			}
		});
		return areas;
	}

}
