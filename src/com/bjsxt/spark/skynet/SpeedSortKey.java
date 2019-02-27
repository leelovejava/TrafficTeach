package com.bjsxt.spark.skynet;

import java.io.Serializable;

public class SpeedSortKey implements Comparable<SpeedSortKey>,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long lowSpeed;
	private long normalSpeed;
	private long mediumSpeed;
	private long highSpeed;

	public SpeedSortKey() {
		super();
	}

	public SpeedSortKey(long lowSpeed, long normalSpeed, long mediumSpeed, long highSpeed) {
		super();
		this.lowSpeed = lowSpeed;
		this.normalSpeed = normalSpeed;
		this.mediumSpeed = mediumSpeed;
		this.highSpeed = highSpeed;
	}

	@Override
	public int compareTo(SpeedSortKey other) {
		if(highSpeed - other.getHighSpeed() != 0){
			return (int)(highSpeed - other.getHighSpeed());
		}else if (mediumSpeed - other.getMediumSpeed() != 0) {
			return (int)(mediumSpeed - other.getMediumSpeed());
		}else if (normalSpeed - other.getNormalSpeed() != 0) {
			return (int)(normalSpeed - other.getNormalSpeed());
		}else if (lowSpeed - other.getLowSpeed() != 0) {
			return (int)(lowSpeed - other.getLowSpeed());
		}
		return 0;
	}

	public long getLowSpeed() {
		return lowSpeed;
	}

	public void setLowSpeed(long lowSpeed) {
		this.lowSpeed = lowSpeed;
	}

	public long getNormalSpeed() {
		return normalSpeed;
	}

	public void setNormalSpeed(long normalSpeed) {
		this.normalSpeed = normalSpeed;
	}

	public long getMediumSpeed() {
		return mediumSpeed;
	}

	public void setMediumSpeed(long mediumSpeed) {
		this.mediumSpeed = mediumSpeed;
	}

	public long getHighSpeed() {
		return highSpeed;
	}

	public void setHighSpeed(long highSpeed) {
		this.highSpeed = highSpeed;
	}

	@Override
	public String toString() {
		return "SpeedSortKey [lowSpeed=" + lowSpeed + ", normalSpeed=" + normalSpeed + ", mediumSpeed=" + mediumSpeed + ", highSpeed=" + highSpeed + "]";
	}
}
