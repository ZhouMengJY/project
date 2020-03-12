package com.hnsic.entity;

public class Sysadmin {
	private String SysadminID;
	private String password;
	private String remarks;
	public String getSysadminID() {
		return SysadminID;
	}
	public void setSysadminID(String sysadminID) {
		SysadminID = sysadminID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
