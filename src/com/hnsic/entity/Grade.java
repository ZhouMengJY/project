package com.hnsic.entity;

public class Grade {		//寝室扣分
	private String dateID;	//编号
	private String time;	//时间
	private String dormID;	//寝室号
	private String roomID;	//房间号
	private String points;	//扣分原因
	private String score;	//寝室得分
	private String remarks;	//备注
	
	
	public String getDateID() {
		return dateID;
	}
	public void setDateID(String dateID) {
		this.dateID = dateID;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDormID() {
		return dormID;
	}
	public void setDormID(String dormID) {
		this.dormID = dormID;
	}
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
			
}
