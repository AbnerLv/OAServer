package com.lzb.oa.bean;

import java.util.Date;

public class EmpInfo {
	private String emp_nickname;   //�ǳ�
	private String emp_name;       //Ա������
	private String emp_sex;        //Ա���Ա�
	private String emp_age;        //Ա������
	private String emp_phone_no;   //Ա���ֻ���
	private String emp_email;      //Ա����������
	private String emp_no;         //Ա�����
	private String emp_department; //Ա����������
	private String emp_position;   //Ա����ְλ
	private Date emp_entry_date;   //Ա����ְ����
	private Date emp_birthday;     //Ա������
	private String emp_nation;     //Ա�����
	private String emp_identify;   //Ա�������֤��
	private String emp_city;       //Ա�����ڳ���
	private String emp_address;    //Ա����ͥ��ַ
	private String emp_password;   //��¼����
	
	
	public String getEmp_nickname() {
		return emp_nickname;
	}
	public void setEmp_nickname(String emp_nickname) {
		this.emp_nickname = emp_nickname;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_sex() {
		return emp_sex;
	}
	public void setEmp_sex(String emp_sex) {
		this.emp_sex = emp_sex;
	}
	public String getEmp_age() {
		return emp_age;
	}
	public void setEmp_age(String emp_age) {
		this.emp_age = emp_age;
	}
	public String getEmp_phone_no() {
		return emp_phone_no;
	}
	public void setEmp_phone_no(String emp_phone_no) {
		this.emp_phone_no = emp_phone_no;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	public String getEmp_department() {
		return emp_department;
	}
	public void setEmp_department(String emp_department) {
		this.emp_department = emp_department;
	}
	public String getEmp_position() {
		return emp_position;
	}
	public void setEmp_position(String emp_position) {
		this.emp_position = emp_position;
	}
	public Date getEmp_entry_date() {
		return emp_entry_date;
	}
	public void setEmp_entry_date(Date emp_entry_date) {
		this.emp_entry_date = emp_entry_date;
	}
	public Date getEmp_birthday() {
		return emp_birthday;
	}
	public void setEmp_birthday(Date emp_birthday) {
		this.emp_birthday = emp_birthday;
	}
	public String getEmp_nation() {
		return emp_nation;
	}
	public void setEmp_nation(String emp_nation) {
		this.emp_nation = emp_nation;
	}
	public String getEmp_identify() {
		return emp_identify;
	}
	public void setEmp_identify(String emp_identify) {
		this.emp_identify = emp_identify;
	}
	public String getEmp_city() {
		return emp_city;
	}
	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public String getEmp_password() {
		return emp_password;
	}
	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	public EmpInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpInfo( String emp_nickname, String emp_name,
			String emp_sex, String emp_age, String emp_phone_no,
			String emp_email, String emp_no, String emp_department,
			String emp_position, Date emp_entry_date, Date emp_birthday,
			String emp_nation, String emp_identify, String emp_city,
			String emp_address, String emp_password) {
		super();
		
		this.emp_nickname = emp_nickname;
		this.emp_name = emp_name;
		this.emp_sex = emp_sex;
		this.emp_age = emp_age;
		this.emp_phone_no = emp_phone_no;
		this.emp_email = emp_email;
		this.emp_no = emp_no;
		this.emp_department = emp_department;
		this.emp_position = emp_position;
		this.emp_entry_date = emp_entry_date;
		this.emp_birthday = emp_birthday;
		this.emp_nation = emp_nation;
		this.emp_identify = emp_identify;
		this.emp_city = emp_city;
		this.emp_address = emp_address;
		this.emp_password = emp_password;
	}
	
	
	

}
