package com.traffic.spark.domain;

import java.io.Serializable;

/**
 * Taskr任务domain
 * @author root
 *
 */
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long taskId;
	private String taskName;
	private String createTime;
	private String startTime;
	private String finishTime;
	private String taskType;
	private String taskStatus;
	private String taskParams;

	public Task() {

	}
	public Task(long taskId, String taskName, String createTime, String startTime, String finishTime, String taskType, String taskStatus, String taskParams) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.createTime = createTime;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.taskType = taskType;
		this.taskStatus = taskStatus;
		this.taskParams = taskParams;
	}
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getTaskParams() {
		return taskParams;
	}
	public void setTaskParams(String taskParams) {
		this.taskParams = taskParams;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
