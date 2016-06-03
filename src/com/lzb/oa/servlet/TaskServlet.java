package com.lzb.oa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzb.oa.dao.TaskManDAO;
import com.lzb.oa.entity.RoomerInfo;
import com.lzb.oa.util.DevidePage;

/**
 * Servlet implementation class TaskServlet
 */
@WebServlet(name = "TaskServlet", urlPatterns="/task_info.json")
public class TaskServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private List<RoomerInfo> tasks = null;
    private int toatlData = 0;
    
    public TaskServlet(){
    	try {
			tasks = TaskManDAO.getInstance().getTaskInfo();
			toatlData = TaskManDAO.getInstance().getTotal();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageNo = request.getParameter("pageNo");
		System.out.println("pageNo = "+ pageNo + "toatlData = "+ toatlData);
		int currentPage = 1;
		if(pageNo !=null){
			currentPage = Integer.parseInt(pageNo);
		}
		DevidePage pageU = new DevidePage(4, toatlData ,currentPage);
		int start = pageU.getFromIndex();
		int end = pageU.getToIndex();
		Gson mGson = new Gson();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();  //页面输出JSONArray的内容 
        if(start > end){
        	out.print("");  
		}else{
			String json = mGson.toJson(tasks.subList(start, end));
			System.out.println(json);
			out.print(json);  
		}
		out.flush();
		out.close();
	
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
