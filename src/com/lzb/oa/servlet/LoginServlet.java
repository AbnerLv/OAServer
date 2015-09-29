package com.lzb.oa.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.alibaba.fastjson.JSONObject;
import com.lzb.oa.bean.Response;
import com.lzb.oa.bean.User;
import com.lzb.oa.dao.UserDAO;
import com.lzb.oa.util.JsonUtil;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");

		StringBuffer json = new StringBuffer();  
		String line = null;  
		try {  
		    BufferedReader reader = request.getReader();  
		    while((line = reader.readLine()) != null) {  
		        json.append(line);  
		    }  
		}  
		catch(Exception e) {  
		   e.printStackTrace();  
		}  
		System.out.println("client json data="+json);  
		  
		JSONObject jsonObj = JSONObject.parseObject(json.toString());  
		  
		String username = jsonObj.getString("UserName");
		String password = jsonObj.getString("PassWord");
		System.out.println("username:" + username + "   password = " + password);

		Response response2 = new Response();
		
		try {
			if(UserDAO.getInstance().validate(username, password)){
				response2.setSuccess("1");
			}else{
				response2.setSuccess("0");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		StringBuilder builder = new StringBuilder(
				JsonUtil.createJsonString(response2));
		System.out.println(builder.toString());
		sendXml(response, JsonUtil.createJsonString(response2));
	}

	private void sendXml(HttpServletResponse response, String content) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		OutputStream out = response.getOutputStream();
		out.write(content.getBytes("utf-8"));
		out.flush();
		out.close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
