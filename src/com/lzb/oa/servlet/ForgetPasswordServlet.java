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
 * Íü¼ÇÃÜÂë
 * 
 * @author lvzhenbin
 * @Date 2015-09-30
 */
@WebServlet(name = "ForgetPasswordServlet", urlPatterns = "/forgetPassword.json")
public class ForgetPasswordServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		JSONObject jsonObj = getClientJSON(request);
		String emp_no = jsonObj.getString("empNo");
		String emp_phone_no = jsonObj.getString("phoneNo");
		String emp_identify = jsonObj.getString("identify");

		ResponseEntity entity = new ResponseEntity();
		String emp_password = UserDao.getInstance().forgetPassword(emp_no, emp_phone_no, emp_identify);
		entity.setMessage(emp_password);
		sendXml(response, JsonUtil.createJsonString(entity));

	}
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
