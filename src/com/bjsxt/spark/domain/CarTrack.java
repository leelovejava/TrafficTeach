package com.bjsxt.spark.domain;

/**
 * 保存车辆轨迹信息 domain
 * @author root
 *
 */
public class CarTrack {
	private long taskId;
	private String date;
	private String car;
	private String track;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	public CarTrack(long taskId, String date, String car, String track) {
		super();
		this.taskId = taskId;
		this.date = date;
		this.car = car;
		this.track = track;
	}
	public CarTrack() {
		super();
	}
}
