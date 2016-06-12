package com.lzb.oa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.lzb.oa.dao.TaskManDAO;

/**
 * 领取任务
 */
@WebServlet(name="/GetTaskServlet",urlPatterns="/task/get_task.json")
public class GetTaskServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JSONObject jsonObj = getClientJSON(request);
		String emp_no = jsonObj.getString("emp_no");
		String roomer_no = jsonObj.getString("roomer_no");
		String roomer_house_no = jsonObj.getString("roomer_house_no");
		String json = TaskManDAO.getInstance().getTask(emp_no, roomer_no,roomer_house_no);
		sendXml(response,json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
