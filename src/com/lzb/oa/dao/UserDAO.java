package com.lzb.oa.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lzb.oa.entity.EmpInfo;
import com.lzb.oa.util.JsonUtil;

public class UserDAO {

	private DBMan manager;
	private static UserDAO dao = null;

	public static UserDAO getInstance() throws ClassNotFoundException,
			IOException {
		if (dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}

	public UserDAO() throws ClassNotFoundException, IOException {
		manager = DBMan.getInstance();

	}

	/**
	 * 员工登录
	 * 
	 * @param username
	 *            员工昵称, 员工编号, 员工手机号
	 * @param password
	 *            密码
	 * @return
	 */
	public String checkLogin(String username, String password) {

		String sql = "select * from emp_info where emp_password='" + password
				+ "' and emp_nickname='" + username + "' or emp_no ='"
				+ username + "' or emp_phone_no='" + username + "'";
		String json = null;
		try {
			manager.connDB();
			ResultSet rs =  manager.executeQuery(sql);
			
			System.out.println("sql = " + sql);
			
			while(rs.next()){
				String emp_nickname = rs.getString("emp_nickname");
				String emp_name = rs.getString("emp_name");
				String emp_sex = rs.getString("emp_sex");
				String emp_age = rs.getString("emp_age");
				String emp_phone_no = rs.getString("emp_phone_no");
				String emp_email = rs.getString("emp_email");
				String emp_no = rs.getString("emp_no");
				String emp_department = rs.getString("emp_department");
				String emp_position = rs.getString("emp_position");
				Date emp_entry_date = rs.getDate("emp_entry_date");
				Date emp_birthday = rs.getDate("emp_birthday");
				String emp_nation = rs.getString("emp_nation");
				String emp_identify = rs.getString("emp_identify");
				String emp_city = rs.getString("emp_city");
				String emp_address = rs.getString("emp_address");
				String emp_password = rs.getString("emp_password");
				EmpInfo emp = new EmpInfo(emp_nickname, emp_name, emp_sex, emp_age, emp_phone_no, emp_email, emp_no, 
						emp_department, emp_position, emp_entry_date, emp_birthday, emp_nation, emp_identify, emp_city, emp_address, emp_password);
				json = JsonUtil.createJsonString(emp);
				
			}  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(json == null){
			EmpInfo emp = new EmpInfo(username, null, null, null, null, null, null, 
					null, null, null, null, null, null, null, null, "0");
			json = JsonUtil.createJsonString(emp);
		}
		return json;
	}

	public String BackPassword(String emp_no, String emp_phone_no,
			String emp_identify) {
		String sql = "select emp_password from emp_info where emp_no = '"
				+ emp_no + "' and emp_phone_no = '" + emp_phone_no
				+ "' and emp_identify = '" + emp_identify + "'";
		String password = null;
		try {
			manager.connDB();
			ResultSet rs = manager.executeQuery(sql);
			while (rs.next()) {
				password = rs.getString("emp_password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("password = " + password);
		return password;
	}

	public int ChangePassword(String username, String oldPassword,
			String newPassword) {
		String sql = "update emp_info set emp_password = '" + newPassword
				+ "' where emp_password='" + oldPassword
				+ "' and emp_nickname='" + username + "' or emp_no ='"
				+ username + "' or emp_phone_no='" + username + "'";
		System.out.println(sql);
		int flag = 0;
		try {
			manager.connDB();
			flag = manager.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public int register(String empPhoneNo, String empNickname,
			String empNo, String empName, String empPassword) {
		int flag = 0;
		String sql = "update emp_info set emp_nickname = '" + empNickname
				+ "',emp_name = '" + empName + "', emp_phone_no = '"
				+ empPhoneNo + "',emp_password = '" + empPassword
				+ "' where emp_no = '" + empNo + "'";
		System.out.println(sql);
		try {
			manager.connDB();
			flag = manager.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
