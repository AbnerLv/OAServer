package com.lzb.oa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzb.oa.dao.TaskManDAO;



@WebServlet(name = "GetNotHaveTasksServlet", urlPatterns="/getNotHaveTasks.json")
public class GetNotHaveTasksServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String tasksJson = TaskManDAO.getInstance().getNotHaveTasks();
			sendXml(response,tasksJson);
	
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
