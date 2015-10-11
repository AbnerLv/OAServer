package com.lzb.oa.servlet.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.lzb.oa.dao.CustomerManagerDAO;
import com.lzb.oa.dao.UserDAO;
import com.lzb.oa.servlet.BaseServlet;

/**
 * 获取客户的详细信息
 */
@WebServlet(name="/CustomerDetail",urlPatterns="/get_customer_detail.json")
public class CustomerDetail extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jsonObj = getClientJSON(request);
		String roomerNo = jsonObj.getString("roomer_no");
		String json = null;
		try {
			json = CustomerManagerDAO.getInstance().getCustomerDetailInfo(roomerNo);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		sendXml(response, json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
