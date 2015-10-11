package com.lzb.oa.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.lzb.oa.dao.UserDAO;
import com.lzb.oa.entity.Response;
import com.lzb.oa.servlet.BaseServlet;
import com.lzb.oa.util.JsonUtil;

/**
 * ÓÃ»§×¢²á
 */
@WebServlet(name="/ResgisterServlet", urlPatterns="/register.json")
public class RegisterServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jsonObj = getClientJSON(request);
		String empPhoneNo = jsonObj.getString("empPhoneNo");
		String empNickname = jsonObj.getString("empNickname");
		String empNo = jsonObj.getString("empNo");
		String empName = jsonObj.getString("empName");
		String empPassword = jsonObj.getString("pass");
		Response success = new Response();
		int flag = 0;
		try {
			flag = UserDAO.getInstance().register(empPhoneNo, empNickname, empNo, empName, empPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		success.setSuccess(""+flag);
		sendXml(response, JsonUtil.createJsonString(success));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
