package com.traffic.spark.domain;


/**
 * 卡口的明细数据domain
 * @author root
 *
 */
public class TopNMonitorDetailInfo   {
	private long taskId;
 	private String date;
 	private String monitorId;
 	private String cameraId;
 	private String car;
 	private String actionTime;
 	private String speed;
 	private String roadId;
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMonitorId() {
		return monitorId;
	}
	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}
	public String getCameraId() {
		return cameraId;
	}
	public void setCameraId(String cameraId) {
		this.cameraId = cameraId;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getActionTime() {
		return actionTime;
	}
	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getRoadId() {
		return roadId;
	}
	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}
	public TopNMonitorDetailInfo(long taskId, String date, String monitorId, String cameraId, String car, String actionTime, String speed, String roadId) {
		super();
		this.taskId = taskId;
		this.date = date;
		this.monitorId = monitorId;
		this.cameraId = cameraId;
		this.car = car;
		this.actionTime = actionTime;
		this.speed = speed;
		this.roadId = roadId;
	}
	public TopNMonitorDetailInfo() {
		super();
	}
}
