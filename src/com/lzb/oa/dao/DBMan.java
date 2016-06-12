package com.lzb.oa.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PropertyResourceBundle;

public class DBMan {

	private static DBMan manager = null;
	private PropertyResourceBundle bundle;
	private static String jdbcDrive = null;
	private String dbHost = null;
	private String dbPort = null;
	private String dbName = null;
	private String dbUser = null;
	private String dbPasswd = null;
	private String strConn = null;

	private Connection conn = null;
	private PreparedStatement pstm = null;
	private CallableStatement cstm = null;

	private DBMan() throws IOException {
		bundle = new PropertyResourceBundle(
				DBMan.class.getResourceAsStream("dbconfig.properties"));
		this.dbHost = getString("dbhost");
		this.dbPort = getString("dbport");
		this.dbName = getString("dbname");
		this.dbUser = getString("dbuser");
		this.dbPasswd = getString("dbpassword");

		jdbcDrive = "com.mysql.jdbc.Driver";
		strConn = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName+"?useUnicode=true&characterEncoding=UTF-8";
	}

	/**
	 * 
	 * @param key
	 *            �����ļ��еļ�ֵ
	 * @return ����key����ȡ��Ӧ��ֵ
	 */
	private String getString(String key) {
		return bundle.getString(key);
	}

	/**
	 * 
	 * @throws ClassNotFoundException
	 */
	private void initDB() throws ClassNotFoundException {
		Class.forName(jdbcDrive);
	}

	public static DBMan getInstance() throws IOException,
			ClassNotFoundException {
		if (manager == null) {
			manager = new DBMan();
			manager.initDB();
		}
		return manager;
	}

	/**
	 * �������ݿ�
	 * 
	 * @throws SQLException
	 */
	public void connDB() throws SQLException {
		conn = DriverManager.getConnection(strConn, dbUser, dbPasswd);

	}

	/**
	 * ִ�в�ѯ����
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String sql) {

		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * ִ�и������
	 * 
	 * @param sql
	 *            sql���
	 * @return either (1) the row count for SQL Data Manipulation Language (DML)
	 *         statements or (2) 0 for SQL statements that return nothing
	 * @throws SQLException
	 */
	public int executeUpdate(String sql) {
		int result = 0;
		if (conn != null) {
			Statement statement = null;
			try {
				conn.setAutoCommit(false);
				statement = conn.createStatement();
				result = statement.executeUpdate(sql);
				conn.commit(); // ע�⣬����֮�������ύ
			} catch (Throwable e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				throw new RuntimeException(e);
			} 
		}
		return result;
	}

}
