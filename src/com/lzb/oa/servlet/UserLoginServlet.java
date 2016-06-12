package com.lzb.oa.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.lzb.oa.dao.UserDao;

/**
 * µÇÂ¼´¦Àí
 * 
 * @author Abner
 * @Date 2015-09-29
 */
@WebServlet(name = "UserLoginServlet", urlPatterns = "/userLogin.json")
public class UserLoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JSONObject jsonObj = getClientJSON(request);
		String username = jsonObj.getString("username");
		String password = jsonObj.getString("password");
		String json = UserDao.getInstance().checkLogin(username, password);
		sendXml(response,json);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
