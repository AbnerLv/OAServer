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
	private ResultSet rs = null;

	private DBMan() throws IOException {
		bundle = new PropertyResourceBundle(
				DBMan.class.getResourceAsStream("dbconfig.properties"));
		this.dbHost = getString("dbhost");
		this.dbPort = getString("dbport");
		this.dbName = getString("dbname");
		this.dbUser = getString("dbuser");
		this.dbPasswd = getString("dbpassword");

		jdbcDrive = "com.mysql.jdbc.Driver";
		strConn = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
	}

	/**
	 * 
	 * @param key
	 *            配置文件中的键值
	 * @return 根据key，获取相应的值
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
	 * 连接数据库
	 * 
	 * @throws SQLException
	 */
	public void connDB() throws SQLException {
		conn = DriverManager.getConnection(strConn, dbUser, dbPasswd);
		conn.setAutoCommit(false);
	}

	/**
	 * 关闭数据库
	 * 
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		if (pstm != null) {
			pstm.close();
		}
		if (cstm != null) {
			cstm.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	/**
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            sql语句的中参数值
	 * @throws SQLException
	 */
	private void setPrepareStatementParams(String sql, Object[] params)
			throws SQLException {
		pstm = conn.prepareStatement(sql); // 对sql预编译
		if (params != null) {
			for (int i = 0; i < params.length; i++) // 设置sql语句中的变量值
			{
				pstm.setObject(i + 1, params[i]);
			}
		}
	}

	/**
	 * @param sql
	 *            sql语句
	 * @param params
	 *            // sql语句的中参数值
	 * @return fanh
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String sql, Object[] params)
			throws SQLException {
		ResultSet rs = null;
		manager.setPrepareStatementParams(sql, params);
		return rs;
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		
		Statement statement = null;
		statement = conn.createStatement();
		return statement.executeQuery(sql);
	}

	/**
	 * 
	 * @param sql
	 * 
	 * @param params
	 * 
	 * @return
	 * @throws SQLException
	 */
	public boolean executeUpdate(String sql, Object[] params)
			throws SQLException {
		boolean result = false;
		manager.setPrepareStatementParams(sql, params);
		conn.commit();
		result = true;
		return result;
	}

	/**
	 * 
	 * @param sql
	 *            sql语句
	 * @return either (1) the row count for SQL Data Manipulation Language (DML)
	 *         statements or (2) 0 for SQL statements that return nothing
	 * @throws SQLException
	 */
	public int executeUpdate(String sql) throws SQLException {
		int result = 0;
		Statement statement = null;
		statement = conn.createStatement();
		result = statement.executeUpdate(sql);
		return result;
	}
	
	public void commit() throws SQLException{
		conn.commit(); // 注意，更新之后，事务提交
		
	}

}
