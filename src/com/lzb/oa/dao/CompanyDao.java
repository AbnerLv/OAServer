package com.lzb.oa.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.lzb.oa.entity.MeettingEntity;
import com.lzb.oa.entity.NoticeEntity;
import com.lzb.oa.util.JsonUtil;

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


}