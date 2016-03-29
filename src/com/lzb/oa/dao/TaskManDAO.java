package com.lzb.oa.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.alibaba.fastjson.JSONArray;
import com.lzb.oa.entity.Response;
import com.lzb.oa.entity.RoomerInfo;
import com.lzb.oa.util.JsonUtil;

public class TaskManDAO {

	private DBMan manager;
	private static TaskManDAO dao;
	private int total=0;

	public static TaskManDAO getInstance() throws ClassNotFoundException,
			IOException {
		if (dao == null) {
			dao = new TaskManDAO();
		}
		return dao;
	}

	public TaskManDAO() throws ClassNotFoundException, IOException {
		manager = DBMan.getInstance();
	}

	public int getTotal(){
		return total;
	}
	
	public void setTotal(int total){
		this.total = total;
	}
	public JSONArray getTaskInfo() {
		String sql = "select roomer_info.*,house_city, house_address from roomer_info, house_info where roomer_info.roomer_house_no = house_info.house_no order by roomer_date desc, roomer_period asc";
		JSONArray tasks = new JSONArray();
		try {

			manager.connDB();
			ResultSet rs = manager.executeQuery(sql);
			rs.last();
			int temp = rs.getRow();
			System.out.println("TotalData = "+temp );
			setTotal(temp);
			rs.beforeFirst();
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
				RoomerInfo rInfo = new RoomerInfo(roomer_no, roomer_name,
						roomer_sex, roomer_phone_no, null, roomer_house_no,
						roomer_date, roomer_period, roomer_rent,
						roomer_complete, roomer_emp_no == null ? ""
								: roomer_emp_no);
				rInfo.setHouse_address(house_address);
				rInfo.setHouse_city(house_city);
				String json = JsonUtil.createJsonString(rInfo);
				System.out.println(json);
				tasks.add(json);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}

	/**
	 * 领取任务
	 * @param emp_no
	 * @param rommer_no
	 * @return
	 */
	public String getTask(String emp_no, String roomer_no,String roomer_house_no) {
		String roomer_sql = "update roomer_info set roomer_emp_no = '" + emp_no
				+ "' where roomer_no = '" + roomer_no + "'";
		String house_sql = "update house_info set house_emp_no = '" + emp_no
				+ "' where house_no = '" + roomer_house_no + "'";
		String json="";
		System.out.println(roomer_sql);
		try {
			manager.connDB();
			int result_r = manager.executeUpdate(roomer_sql);
			int result_h = manager.executeUpdate(house_sql);
			Response resp = new Response();
			if(result_r > 0 && result_h > 0){
				resp.setSuccess("1");
			}else{
				resp.setSuccess("0");
			}
			json = JsonUtil.createJsonString(resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 取消任务
	 * @param rommer_no
	 * @return
	 */
	public String cancelTask(String roomer_no,String roomer_house_no) {
		System.out.println("rommer_house_no"+roomer_house_no);
		String roomer_sql = "update roomer_info set roomer_emp_no = null where roomer_no = '"+roomer_no+"'" ;
		String house_sql = "update house_info set house_emp_no = null where house_no = '"+roomer_house_no+"'";
		String json="";
		try {
			manager.connDB();
			int result_r = manager.executeUpdate(roomer_sql);
			int result_h = manager.executeUpdate(house_sql);
			Response resp = new Response();
			if(result_r > 0 && result_h > 0){
				resp.setSuccess("1");
			}else{
				resp.setSuccess("0");
			}
			json = JsonUtil.createJsonString(resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return json;
	}

}
