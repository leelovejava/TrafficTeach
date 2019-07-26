package com.traffic.spark.dao.impl;


import com.traffic.spark.constant.Constants;
import com.traffic.spark.dao.IWithTheCarDAO;
import com.traffic.spark.jdbc.JDBCHelper;
import com.traffic.spark.util.DateUtils;

public class WithTheCarDAOImpl implements IWithTheCarDAO {

    @Override
    public void updateTestData(String cars) {
        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
        String sql = "UPDATE task set task_param = ? WHERE task_id = 3";
        Object[] params = new Object[]{"{\"startDate\":[\"" + DateUtils.getTodayDate() + "\"],\"endDate\":[\"" + DateUtils.getTodayDate() + "\"],\"" + Constants.FIELD_CARS + "\":[\"" + cars + "\"]}"};
        jdbcHelper.executeUpdate(sql, params);
    }

}
