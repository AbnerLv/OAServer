package com.lzb.oa.bean;

import java.util.Date;

public class RoomerInfo {
	
	private String roomer_no;       //客户编号
	private String roomer_name;     //客户姓名
	private String roomer_sex;      //客户性别
	private String roomer_phone_no; //客户手机号码
	private String roomer_email;    //客户电子邮箱
	private String roomer_home_no;  //房源编号
	private Date roomer_date;       //看房日期
	private String roomer_period;   //看房时间段
	private String roomer_rent;     //客户需求
	private String roomer_complte;  //交易完成表示
	private String roomer_emp_no;   //跟进员工
	public String getRoomer_no() {
		return roomer_no;
	}
	public void setRoomer_no(String roomer_no) {
		this.roomer_no = roomer_no;
	}
	public String getRoomer_name() {
		return roomer_name;
	}
	public void setRoomer_name(String roomer_name) {
		this.roomer_name = roomer_name;
	}
	public String getRoomer_sex() {
		return roomer_sex;
	}
	public void setRoomer_sex(String roomer_sex) {
		this.roomer_sex = roomer_sex;
	}
	public String getRoomer_phone_no() {
		return roomer_phone_no;
	}
	public void setRoomer_phone_no(String roomer_phone_no) {
		this.roomer_phone_no = roomer_phone_no;
	}
	public String getRoomer_email() {
		return roomer_email;
	}
	public void setRoomer_email(String roomer_email) {
		this.roomer_email = roomer_email;
	}
	public String getRoomer_home_no() {
		return roomer_home_no;
	}
	public void setRoomer_home_no(String roomer_home_no) {
		this.roomer_home_no = roomer_home_no;
	}
	public Date getRoomer_date() {
		return roomer_date;
	}
	public void setRoomer_date(Date roomer_date) {
		this.roomer_date = roomer_date;
	}
	public String getRoomer_period() {
		return roomer_period;
	}
	public void setRoomer_period(String roomer_period) {
		this.roomer_period = roomer_period;
	}
	public String getRoomer_rent() {
		return roomer_rent;
	}
	public void setRoomer_rent(String roomer_rent) {
		this.roomer_rent = roomer_rent;
	}
	public String getRoomer_complte() {
		return roomer_complte;
	}
	public void setRoomer_complte(String roomer_complte) {
		this.roomer_complte = roomer_complte;
	}
	public String getRoomer_emp_no() {
		return roomer_emp_no;
	}
	public void setRoomer_emp_no(String roomer_emp_no) {
		this.roomer_emp_no = roomer_emp_no;
	}
	public RoomerInfo() {
		
	}
	public RoomerInfo(String roomer_no, String roomer_name, String roomer_sex,
			String roomer_phone_no, String roomer_email, String roomer_home_no,
			Date roomer_date, String roomer_period, String roomer_rent,
			String roomer_complte, String roomer_emp_no) {
		super();
		this.roomer_no = roomer_no;
		this.roomer_name = roomer_name;
		this.roomer_sex = roomer_sex;
		this.roomer_phone_no = roomer_phone_no;
		this.roomer_email = roomer_email;
		this.roomer_home_no = roomer_home_no;
		this.roomer_date = roomer_date;
		this.roomer_period = roomer_period;
		this.roomer_rent = roomer_rent;
		this.roomer_complte = roomer_complte;
		this.roomer_emp_no = roomer_emp_no;
	}
	
	
	

}
