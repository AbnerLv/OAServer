package com.lzb.oa.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import com.lzb.oa.bean.RoomerInfo;
import com.lzb.oa.util.JsonUtil;

public class CustomerManagerDAO {

	private DBManager manager;
	private static CustomerManagerDAO dao;

	public static CustomerManagerDAO getInstance()
			throws ClassNotFoundException, IOException {
		if (dao == null) {
			dao = new CustomerManagerDAO();
		}
		return dao;
	}

	public CustomerManagerDAO() throws ClassNotFoundException, IOException {
		manager = DBManager.getInstance();
	}

	public JSONArray getCustomerInfo() {
		String sql = "select * from roomer_info order by roomer_date desc";

		JSONArray info = new JSONArray();
		try {

			manager.connDB();
			ResultSet rs = manager.executeQuery(sql);
			while (rs.next()) {
				String roomer_no = rs.getString("roomer_no");
				String roomer_name = rs.getString("roomer_name");
				String roomer_phone_no = rs.getString("roomer_phone_no");
				String roomer_date = rs.getDate("roomer_date").toString();

				RoomerInfo rInfo = new RoomerInfo(roomer_no, roomer_name,
						roomer_phone_no, roomer_date);
				String json = JsonUtil.createJsonString(rInfo);
				info.add(json);
			}
			manager.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}

}
