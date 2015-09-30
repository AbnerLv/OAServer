package com.lzb.oa.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JsonUtil {
	/**
	 * change an Object to json string
	 * 
	 * @param object
	 * @return
	 */
	public static String createJsonString(Object object) {
		String jsonString = JSON.toJSONString(object);
		return jsonString;
	}

	/**
	 * change a json string to an general object
	 * 
	 * @param jsonString
	 * @param cls
	 *            the class of the object that is needed to change
	 * @return
	 */
	public static <T> T createJsonBean(String jsonString, Class<T> cls) {
		T t = JSON.parseObject(jsonString, cls);
		return t;
	}

	/**
	 * change a json string to a list which contains some objects of cls
	 * 
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> createJsonToListBean(String jsonString,
			Class<T> cls) {
		List<T> list = null;
		list = JSON.parseArray(jsonString, cls);
		return list;
	}

	/**
	 * change a json string to a list which contains some objects of Map<String,
	 * Object>
	 * 
	 * @param jsonString
	 * @return
	 */
	public static List<Map<String, Object>> createJsonToListMap(
			String jsonString) {
		List<Map<String, Object>> list = JSON.parseObject(jsonString,
				new TypeReference<List<Map<String, Object>>>() {
				});
		return list;
	}

}
