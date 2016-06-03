package com.lzb.oa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lzb.oa.dao.SettingDAO;
import com.lzb.oa.dao.TaskManDAO;


@WebServlet(name="/HaveTasksServlet",urlPatterns="/getHaveTasks.json")
public class HaveTasksServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String emp_no = request.getParameter("emp_no");
		System.out.println("emp_no = " + emp_no);
		try {
			String tasksJson = SettingDAO.getInstance().getHaveTasks(emp_no);
			sendXml(response,tasksJson);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
