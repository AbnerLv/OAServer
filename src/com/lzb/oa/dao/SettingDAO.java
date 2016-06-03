package com.lzb.oa.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.lzb.oa.entity.TaskEntity;
import com.lzb.oa.utils.JsonUtil;

public class SettingDAO {
	private DBMan manager;
	private static SettingDAO dao;

	public static SettingDAO getInstance() throws ClassNotFoundException,
			IOException {
		if (dao == null) {
			dao = new SettingDAO();
		}
		return dao;
	}

	public SettingDAO() throws ClassNotFoundException, IOException {
		manager = DBMan.getInstance();
	}

	public String getHaveTasks(String emp_no) {
		String sql = "select roomer_info.*,house_city, house_address from roomer_info, house_info where roomer_info.roomer_house_no = house_info.house_no and roomer_emp_no = '"
				+ emp_no + "' order by roomer_date desc, roomer_period asc";
        List<TaskEntity> tasks = new ArrayList<TaskEntity>();
		try {

			manager.connDB();
			ResultSet rs = manager.executeQuery(sql);
			while (rs.next()) {

				String roomer_no = rs.getString("roomer_no");
				String roomer_name = rs.getString("roomer_name");
				String roomer_sex = rs.getString("roomer_sex");
				String roomer_phone_no = rs.getString("roomer_phone_no");
				String roomer_house_no = rs.getString("roomer_house_no");
				String roomer_date = rs.getDate("roomer_date").toString();
				String roomer_period = rs.getString("roomer_period");
				String roomer_rent = rs.getString("roomer_rent");
				String roomer_complete = rs.getString("roomer_complete");
				String roomer_emp_no = rs.getString("roomer_emp_no");
				String house_city = rs.getString("house_city");
				String house_address = rs.getString("house_address");

				TaskEntity entity = new TaskEntity(roomer_no, roomer_name,
						roomer_sex, roomer_phone_no, null, roomer_house_no,
						roomer_date, roomer_period, roomer_rent,
						roomer_complete, roomer_emp_no == null ? ""
								: roomer_emp_no,house_city,house_address);
				tasks.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String tasksJson = gson.toJson(tasks);
		System.out.println("SettingDAO---getHaveTasks JSON = " + tasksJson);
		return tasksJson;
	}

}
