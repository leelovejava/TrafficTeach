package com.bjsxt.spark.domain;

/**
 * 随机抽取出来的car信息 domain
 * @author root
 *
 */
public class RandomExtractCar {
	private long taskId;
	private String car;
	private String date;
	private String dateHour;
	 
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	 
	public String getDateHour() {
		return dateHour;
	}
	public void setDateHour(String dateHour) {
		this.dateHour = dateHour;
	}
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	 
	public RandomExtractCar(long taskId, String car, String date, String dateHour) {
		super();
		this.taskId = taskId;
		this.car = car;
		this.date = date;
		this.dateHour = dateHour;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public RandomExtractCar() {
		super();
	}
}
