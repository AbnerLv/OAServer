package com.lzb.oa.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

/**
 * ����Servlet
 */

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	/**
	 * ��ȡ�ͻ��˵�JSON����
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public JSONObject getClientJSON(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("client json data=" + json);

		JSONObject.parseObject(json.toString());
		return JSONObject.parseObject(json.toString());
	}

	/**
	 * ����JSON���ݵ��ͷ���
	 * 
	 * @param response
	 * @param json
	 *            json ����
	 * @throws IOException
	 */
	public void sendXml(HttpServletResponse response, String json)
			throws IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("json result "+json);
		OutputStream out = response.getOutputStream();
		out.write(json.getBytes("utf-8"));
		out.flush();
		out.close();
	}

}
