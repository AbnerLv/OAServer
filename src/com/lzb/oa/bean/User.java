package com.lzb.oa.bean;


public class User {
	
	private int id;
	private String username;
	private String password;
	private String login_emp_no;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin_emp_no() {
		return login_emp_no;
	}
	public void setLogin_emp_no(String login_emp_no) {
		this.login_emp_no = login_emp_no;
	}
	public User(int id, String username, String password, String login_emp_no) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.login_emp_no = login_emp_no;
	}
	public User() {
		super();
	}
	
	
	

}
