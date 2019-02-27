package com.bjsxt.spark.domain;

public class CarInfoPer5M {
	private long taskId;
	private String monitorId;
	private String rangeTime;
	private String cars;
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public String getMonitorId() {
		return monitorId;
	}
	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}
	public String getRangeTime() {
		return rangeTime;
	}
	public void setRangeTime(String rangeTime) {
		this.rangeTime = rangeTime;
	}
	public String getCars() {
		return cars;
	}
	public void setCars(String cars) {
		this.cars = cars;
	}
	public CarInfoPer5M(long taskId, String monitorId, String rangeTime, String cars) {
		super();
		this.taskId = taskId;
		this.monitorId = monitorId;
		this.rangeTime = rangeTime;
		this.cars = cars;
	}
	public CarInfoPer5M() {
		super();
	}
}
