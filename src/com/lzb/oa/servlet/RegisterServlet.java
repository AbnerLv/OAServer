package com.lzb.oa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.lzb.oa.dao.UserDao;
import com.lzb.oa.entity.ResponseEntity;
import com.lzb.oa.utils.JsonUtil;

/**
 * �û�ע��
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
		ResponseEntity success = new ResponseEntity();
		int code = UserDao.getInstance().register(empPhoneNo, empNickname, empNo, empName, empPassword);
	
		success.setSuccess(""+code);
		sendXml(response, JsonUtil.createJsonString(success));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
