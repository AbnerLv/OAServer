package com.lzb.oa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.lzb.oa.dao.TaskManagerDAO;

/**
 * Servlet implementation class TaskServlet
 */
@WebServlet(name = "TaskServlet", urlPatterns="/task_info.json")
public class TaskServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray tasks = null;
		try {
			tasks = TaskManagerDAO.getInstance().getTaskInfo();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		 //页面输出JSONArray的内容  
        PrintWriter out = response.getWriter();  
        out.print(tasks);  
        out.flush();
        out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
