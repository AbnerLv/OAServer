package com.lzb.oa.servlet.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.lzb.oa.bean.Response;
import com.lzb.oa.dao.UserDAO;
import com.lzb.oa.servlet.BaseServlet;
import com.lzb.oa.util.JsonUtil;

/**
 * µÇÂ¼´¦Àí
 * 
 * @author Abner
 * @Date 2015-09-29
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login.json")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		JSONObject jsonObj = getClientJSON(request);
		String username = jsonObj.getString("UserName");
		String password = jsonObj.getString("PassWord");

		Response response2 = new Response();

		try {
			if (UserDAO.getInstance().validate(username, password)) {
				response2.setSuccess("1");
			} else {
				response2.setSuccess("0");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		sendXml(response, JsonUtil.createJsonString(response2));
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
