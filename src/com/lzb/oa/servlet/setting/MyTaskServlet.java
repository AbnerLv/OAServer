package com.lzb.oa.servlet.setting;

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
import com.lzb.oa.servlet.BaseServlet;

/**
 * Servlet implementation class MyTaskServlet
 */
@WebServlet(name="/MyTaskServlet",urlPatterns="/my_task.json")
public class MyTaskServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jsonObj = getClientJSON(request);
		String emp_no = jsonObj.getString("emp_no");
		System.out.println("emp_no = " + emp_no);
		JSONArray tasks = null;
		try {
			tasks = SettingDAO.getInstance().getMyTask(emp_no);
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
		doGet(request,response);
	}

}
