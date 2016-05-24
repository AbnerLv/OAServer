package com.lzb.oa.entity;

public class MeettingEntity {
	
	private String theme;
	private String time;
	private String content;
	private String address;
	private String endTime;
	
	
	public MeettingEntity(String theme, String time, String content,
			String address,String endTime) {
		this.theme = theme;
		this.time = time;
		this.content = content;
		this.address = address;
		this.endTime = endTime;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	
	

}
