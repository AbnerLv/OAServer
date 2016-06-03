package com.lzb.oa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.lzb.oa.dao.CustomerManDAO;
import com.lzb.oa.dao.CompanyDao;
import com.lzb.oa.entity.MeettingEntity;

/**
 * 获取客户的详细信息
 */
@WebServlet(name="/MeettingServlet",urlPatterns="/get_meetting_info.json")
public class MeettingServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
	    List<MeettingEntity> meettingList = null;
		Gson mGson = new Gson();
		String json = null;
		try {
			meettingList = CompanyDao.getInstance().getMeetingInfo();
			json = mGson.toJson(meettingList);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 //页面输出JSONArray的内容  
		System.out.println("MeetingDetail---json---"+json);
        PrintWriter out = response.getWriter();  
        out.print(json);  
        out.flush();
        out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
