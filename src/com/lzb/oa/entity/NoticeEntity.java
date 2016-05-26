package com.lzb.oa.entity;

public class NoticeEntity {
	
	private String theme;
	private String time;
	private String content;
	private String empNo;
	
	
	public NoticeEntity(String theme, String time, String content, String empNo) {
		this.theme = theme;
		this.time = time;
		this.content = content;
		this.empNo = empNo;
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
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	

}
