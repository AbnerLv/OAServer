package com.lzb.oa.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	private DBManager manager;
	private static UserDAO dao = null;

	public static UserDAO getInstance() throws ClassNotFoundException,
			IOException {
		if (dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}

	public UserDAO() throws ClassNotFoundException, IOException {
		manager = DBManager.getInstance();

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
	public boolean validate(String username, String password) {
		boolean flag = false;
		String sql = "select * from emp_info where emp_password='"
				+ password + "' and emp_nickname='" + username
				+ "' or emp_no ='" + username + "' or emp_phone_no='"
				+ username + "'";
		// Object[] params = new
					// Object[]{password,username,username,username};
		try {
			manager.connDB();
			boolean row = manager.executeQuery(sql).next();
			System.out.println("sql = " + sql);
			if (row) {
				flag = true;
			}
			manager.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
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
			while(rs.next()){
				password = rs.getString("emp_password");
			}
			manager.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("password = " + password);
		return password;
	}

}
