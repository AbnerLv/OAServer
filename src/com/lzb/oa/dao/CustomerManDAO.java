package com.lzb.oa.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.fastjson.JSONArray;
import com.lzb.oa.entity.CustomerInfo;
import com.lzb.oa.entity.TaskEntity;
import com.lzb.oa.utils.JsonUtil;

public class CustomerManDAO {

	private DBMan manager;
	private static CustomerManDAO dao;

	public static CustomerManDAO getInstance()
			throws ClassNotFoundException, IOException {
		if (dao == null) {
			dao = new CustomerManDAO();
		}
		return dao;
	}

	public CustomerManDAO() throws ClassNotFoundException, IOException {
		manager = DBMan.getInstance();
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

				TaskEntity rInfo = new TaskEntity(roomer_no, roomer_name,
						roomer_phone_no, roomer_date);
				String json = JsonUtil.createJsonString(rInfo);
				info.add(json);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
	
	public String getCustomerDetailInfo(String roomerNo){

		String sql = "select * from roomer_info, house_info where roomer_no = '"+roomerNo+"' and roomer_info.roomer_house_no = house_info.house_no order by roomer_date desc";
	 String json = "";
		try {
			manager.connDB();
			ResultSet rs = manager.executeQuery(sql);
			while(rs.next()){
				String roomer_no = rs.getString("roomer_no");
				String roomer_rent = rs.getString("roomer_rent");
				String roomer_name = rs.getString("roomer_name");
				String roomer_sex = rs.getString("roomer_sex");
				String roomer_phone_no = rs.getString("roomer_phone_no");
				String roomer_email = rs.getString("roomer_email");
				String roomer_date = rs.getDate("roomer_date").toString();
				String roomer_period = rs.getString("roomer_period");
				String house_city = rs.getString("house_city");
				String house_address = rs.getString("house_address");
				String house_no = rs.getString("house_no");
				String house_flag = rs.getString("house_flag");
				String house_type = rs.getString("house_type");
				String house_area = rs.getString("house_area");
				String house_price = rs.getString("house_price");
				String house_green_rating = rs.getString("house_green_rating");
				String house_property = rs.getString("house_property");
				String house_owner_name = rs.getString("house_owner_name");
				String house_owner_phone_no = rs.getString("house_owner_phone_no");
				String house_out_flag = rs.getString("house_out_flag");
				String roomer_complete = rs.getString("roomer_complete");
				String roomer_emp_no = rs.getString("roomer_emp_no");
				CustomerInfo detailinfo = new CustomerInfo(house_no, house_type, house_area, house_price, house_flag, house_city, house_address, house_green_rating, house_property, house_owner_name, house_owner_phone_no, house_out_flag, roomer_no, roomer_name, roomer_sex, roomer_phone_no, roomer_email, roomer_date, roomer_period, roomer_rent, roomer_complete, roomer_emp_no);
				json = JsonUtil.createJsonString(detailinfo);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("CustomerDetail"+json);
		return json;
	}

}
