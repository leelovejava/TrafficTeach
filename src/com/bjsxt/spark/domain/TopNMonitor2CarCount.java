package com.bjsxt.spark.domain;

/**
 * 获取车流量排名前N的卡口
 *
 * @author root
 */
public class TopNMonitor2CarCount {
    private long taskId;
    private String monitorId;
    private int carCount;

    public String getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(String monitorId) {
        this.monitorId = monitorId;
    }

    public TopNMonitor2CarCount(long taskId, String monitorId, int carCount) {
        super();
        this.taskId = taskId;
        this.monitorId = monitorId;
        this.carCount = carCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public TopNMonitor2CarCount() {

    }
}
