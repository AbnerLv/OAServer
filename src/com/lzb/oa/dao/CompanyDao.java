package com.lzb.oa.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.lzb.oa.entity.EmpEntity;
import com.lzb.oa.entity.EmpInfo;
import com.lzb.oa.entity.MeettingEntity;
import com.lzb.oa.entity.NoticeEntity;
import com.lzb.oa.utils.JsonUtil;

public class CompanyDao {
	
	private DBMan manager;
	
	private static CompanyDao dao;

	public CompanyDao() throws ClassNotFoundException, IOException{
		manager = DBMan.getInstance();
	}
	public static CompanyDao getInstance()
			throws ClassNotFoundException, IOException {
		if (dao == null) {
			dao = new CompanyDao();
		}
		return dao;
	}
	
	public List<MeettingEntity> getMeetingInfo(){
		String sql = "select * from meeting ";
		List<MeettingEntity> infoList = new ArrayList<MeettingEntity>();
		try {
			manager.connDB();
			ResultSet rs = manager.executeQuery(sql);
			while (rs.next()) {
				String theme = rs.getString("meeting_theme");
				String time = rs.getDate("meeting_start").toString();
				String endTime = rs.getDate("meeting_end").toString();
				String content = rs.getString("meeting_content");
				String address = rs.getString("meeting_address");
				MeettingEntity entity = new MeettingEntity(theme,time,content,address,endTime);
				infoList.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return infoList;
	}
	
	
	public List<NoticeEntity> getNoticeInfo(){
		String sql = "select * from notice ";
		List<NoticeEntity> infoList = new ArrayList<NoticeEntity>();
		try {
			manager.connDB();
			ResultSet rs = manager.executeQuery(sql);
			while (rs.next()) {
				String theme = rs.getString("notice_theme");
				String time = rs.getDate("notice_date").toString();
				String content = rs.getString("notice_content");
				String empNo = rs.getString("notice_emp_no");
				NoticeEntity entity = new NoticeEntity(theme,time,content,empNo);
				infoList.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return infoList;
	}
	
	public String getDepartments(){
		String sql = "SELECT DISTINCT emp_department FROM emp_info";
		List<String> departments = new ArrayList<String>();
		try {
			manager.connDB();
			ResultSet rs = manager.executeQuery(sql);
			while (rs.next()) {
				String emp_department = rs.getString("emp_department");
				departments.add(emp_department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		return gson.toJson(departments);
	}
	
	public String getAllContacters(){
		String sql = "SELECT * FROM emp_info";
		List<EmpEntity> contacts = new ArrayList<EmpEntity>();
		try{
			manager.connDB();
			ResultSet rs = manager.executeQuery(sql);
			while (rs.next()) {
				String emp_nickname = rs.getString("emp_nickname");
				String emp_name = rs.getString("emp_name");
				String emp_sex = rs.getString("emp_sex");
				String emp_age = rs.getString("emp_age");
				String emp_phone_no = rs.getString("emp_phone_no");
				String emp_email = rs.getString("emp_email");
				String emp_no = rs.getString("emp_no");
				String emp_department = rs.getString("emp_department");
				String emp_position = rs.getString("emp_position");
				String emp_entry_date = rs.getDate("emp_entry_date").toString();
				String emp_birthday = rs.getDate("emp_birthday").toString();
				String emp_nation = rs.getString("emp_nation");
				String emp_identify = rs.getString("emp_identify");
				String emp_city = rs.getString("emp_city");
				String emp_address = rs.getString("emp_address");
				EmpEntity entity = new EmpEntity(emp_nickname, emp_name, emp_sex, emp_age, emp_phone_no, emp_email, emp_no, 
						emp_department, emp_position, emp_entry_date, emp_birthday, emp_nation, emp_identify, emp_city, emp_address);
				contacts.add(entity);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		return gson.toJson(contacts);
		
	}


}
