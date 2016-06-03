package com.lzb.oa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.lzb.oa.dao.CustomerManDAO;

/**
 * 获取顾客信息
 * @author lzb
 * @date 2015-10-2
 */
@WebServlet(name="CustomerInfoServlet",urlPatterns="/customer_info.json")
public class CustomerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray info = null;
		try {
			info = CustomerManDAO.getInstance().getCustomerInfo();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		 //页面输出JSONArray的内容  
        PrintWriter out = response.getWriter();  
        out.print(info);  
        out.flush();
        out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
