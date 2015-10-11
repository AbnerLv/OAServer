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
 * Íü¼ÇÃÜÂë
 * 
 * @author Abner
 * @Date 2015-09-30
 */
@WebServlet(name = "BackPasswordServlet", urlPatterns = "/back_password.json")
public class BackPasswordServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		JSONObject jsonObj = getClientJSON(request);
		String emp_no = jsonObj.getString("empNo");
		String emp_phone_no = jsonObj.getString("phoneNo");
		String emp_identify = jsonObj.getString("identify");

		System.out.println("emp_no = " + emp_no + " emp_phone_no = "
				+ emp_phone_no + " emp_identify = " + emp_identify);
		
		Response response2 = new Response();
		String emp_password = null;
		try {
			emp_password = UserDAO.getInstance().BackPassword(emp_no, emp_phone_no, emp_identify);
			response2.setEmp_password(emp_password);
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
