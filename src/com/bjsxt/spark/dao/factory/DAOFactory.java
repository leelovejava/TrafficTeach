package com.bjsxt.spark.dao.factory;

import com.bjsxt.spark.dao.IAreaDao;
import com.bjsxt.spark.dao.ICarTrackDAO;
import com.bjsxt.spark.dao.IMonitorDAO;
import com.bjsxt.spark.dao.IRandomExtractDAO;
import com.bjsxt.spark.dao.ITaskDAO;
import com.bjsxt.spark.dao.IWithTheCarDAO;
import com.bjsxt.spark.dao.impl.AreaDaoImpl;
import com.bjsxt.spark.dao.impl.CarTrackDAOImpl;
import com.bjsxt.spark.dao.impl.MonitorDAOImpl;
import com.bjsxt.spark.dao.impl.RandomExtractDAOImpl;
import com.bjsxt.spark.dao.impl.TaskDAOImpl;
import com.bjsxt.spark.dao.impl.WithTheCarDAOImpl;

/**
 * DAO工厂类
 * @author root
 *
 */
public class DAOFactory {
	
	
	public static ITaskDAO getTaskDAO(){
		return new TaskDAOImpl();
	}
	
	public static IMonitorDAO getMonitorDAO(){
		return new MonitorDAOImpl();
	}
	
	public static IRandomExtractDAO getRandomExtractDAO(){
		return new RandomExtractDAOImpl();
	}
	
	public static ICarTrackDAO getCarTrackDAO(){
		return new CarTrackDAOImpl();
	}
	
	public static IWithTheCarDAO getWithTheCarDAO(){
		return new WithTheCarDAOImpl();
	}

	public static IAreaDao getAreaDao() {
		return  new AreaDaoImpl();
		
	}
}
