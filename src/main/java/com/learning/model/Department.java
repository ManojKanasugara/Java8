package com.learning.model;

public class Department {

	private int depId;
	private String depName;
	private String depCode;
	private String depHead;
	private float depRevenue;
	private long totalMembers;

	Department() {
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	public String getDepHead() {
		return depHead;
	}

	public void setDepHead(String depHead) {
		this.depHead = depHead;
	}

	public float getDepRevenue() {
		return depRevenue;
	}

	public void setDepRevenue(float depRevenue) {
		this.depRevenue = depRevenue;
	}

	public long getTotalMembers() {
		return totalMembers;
	}

	public void setTotalMembers(long totalMembers) {
		this.totalMembers = totalMembers;
	}

}
