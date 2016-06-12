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
 * ÐÞ¸ÄÃÜÂë
 * @author Abner
 * @date 2015-10-2
 *
 */
@WebServlet(name="ModifyPasswordServlet",urlPatterns = "/modifyPassword.json")
public class ModifyPasswordServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JSONObject jsonObj = getClientJSON(request);
		String userName = jsonObj.getString("username");
		String oldPass = jsonObj.getString("oldPassword");
		String newPass = jsonObj.getString("newPassword");
		ResponseEntity entity = new ResponseEntity();
		int code = UserDao.getInstance().modifyPassword(userName, oldPass, newPass);
		entity.setCode(code);
		sendXml(response, JsonUtil.createJsonString(entity));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
