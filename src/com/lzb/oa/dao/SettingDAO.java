package com.lzb.oa.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.fastjson.JSONArray;
import com.lzb.oa.entity.RoomerInfo;
import com.lzb.oa.util.JsonUtil;

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
	
	
	public SettingDAO() throws ClassNotFoundException, IOException{
		manager = DBMan.getInstance();
	}
	
	public JSONArray getMyTask(String emp_no) {
		String sql = "select roomer_info.*,house_city, house_address from roomer_info, house_info where roomer_info.roomer_house_no = house_info.house_no and roomer_emp_no = '"+emp_no
				+"' order by roomer_date desc, roomer_period asc";
		
		JSONArray tasks = new JSONArray();
		try {
			
			manager.connDB();
			ResultSet rs = manager.executeQuery(sql);
			while(rs.next()){
				
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
				RoomerInfo rInfo = new RoomerInfo(roomer_no, roomer_name, roomer_sex, roomer_phone_no, null, roomer_house_no,
						roomer_date, roomer_period, roomer_rent, roomer_complete, roomer_emp_no==null?"":roomer_emp_no);
				rInfo.setHouse_address(house_address);
				rInfo.setHouse_city(house_city);
				String json = JsonUtil.createJsonString(rInfo);
				System.out.println(json);
				tasks.add(json);	
			}
			manager.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}

}
