package com.lzb.oa.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	private DBManager manager;
	private String sql;
	private ResultSet rs;
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

	public boolean validate(String username, String password) {
		boolean flag = false;
		try {
			manager.connDB();

			String sql = "select * from emp_info where emp_password='"
					+ password + "' and emp_nickname='" + username
					+ "' or emp_no ='" + username + "' or emp_phone_no='"
					+ username + "'";
			// Object[] params = new
			// Object[]{password,username,username,username};

			boolean row = manager.executeQuery(sql).next();
			System.out.println("sql = " + sql);
			System.out.println("row = " + row);
			if (row) {
				flag = true;
			}
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();

		}
		return flag;
	}

}
