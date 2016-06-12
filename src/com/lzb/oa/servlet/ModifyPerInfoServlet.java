package com.lzb.oa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzb.oa.dao.UserDao;
import com.lzb.oa.entity.EmpEntity;
import com.lzb.oa.entity.ResponseEntity;
import com.lzb.oa.utils.JsonUtil;

/**
 * ÐÞ¸ÄÃÜÂë
 * @author Abner
 * @date 2015-10-2
 *
 */
@WebServlet(name="ModifyPerInfoServlet",urlPatterns = "/modifyPerInfo.json")
public class ModifyPerInfoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JSONObject jsonObj = getClientJSON(request);
		Gson gson = new Gson();
		EmpEntity empEntity = gson.fromJson(jsonObj.toString(),  new TypeToken<EmpEntity>(){}.getType());
		ResponseEntity entity = new ResponseEntity();
		int code = UserDao.getInstance().modifyPerInfo(empEntity);
		entity.setCode(code);
		sendXml(response, JsonUtil.createJsonString(entity));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
