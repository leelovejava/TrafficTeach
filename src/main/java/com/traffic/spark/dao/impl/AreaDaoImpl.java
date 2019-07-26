package com.traffic.spark.dao.impl;

import com.traffic.spark.dao.IAreaDao;
import com.traffic.spark.domain.Area;
import com.traffic.spark.jdbc.JDBCHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AreaDaoImpl implements IAreaDao {

    public List<Area> findAreaInfo() {
        final List<Area> areas = new ArrayList<Area>();

        String sql = "SELECT * FROM area_info";

        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
        jdbcHelper.executeQuery(sql, null, new JDBCHelper.QueryCallback() {

            public void process(ResultSet rs) throws Exception {
                if (rs.next()) {
                    String areaId = rs.getString(1);
                    String areaName = rs.getString(2);
                    areas.add(new Area(areaId, areaName));
                }
            }
        });
        return areas;
    }

}
