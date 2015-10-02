package com.lzb.oa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.lzb.oa.bean.Response;
import com.lzb.oa.dao.UserDAO;
import com.lzb.oa.util.JsonUtil;

/**
 * ÐÞ¸ÄÃÜÂë
 * @author Abner
 * @date 2015-10-2
 *
 */
@WebServlet(name="ChangePassServlet",urlPatterns = "/change_pass.json")
public class ChangePassServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JSONObject jsonObj = getClientJSON(request);
		String userName = jsonObj.getString("userName");
		String oldPass = jsonObj.getString("oldPass");
		String newPass = jsonObj.getString("newPass");
		Response response2 = new Response();
		int success = 0;
		try {
			success = UserDAO.getInstance().ChangePassword(userName, oldPass, newPass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		response2.setSuccess(success+"");
		sendXml(response, JsonUtil.createJsonString(response2));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
