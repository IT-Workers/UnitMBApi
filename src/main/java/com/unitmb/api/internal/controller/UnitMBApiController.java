package com.unitmb.api.internal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author Sun yan
 * 基类Controller 所有的 Controller 都应该继承此Controller
 */
public abstract class UnitMBApiController extends UnitMBApiErrorCodeMessage{
	
	@Resource
	protected HttpServletRequest request;
	
	@Resource
	protected HttpServletResponse response;
	
	protected void success() {
		witer(SUCCESS, null, null, null);
	}
	protected void success(Object data) {
		witer(SUCCESS, null, null, data);
	}
	protected void success(String message, String promptType) {
		witer(SUCCESS, message, promptType, null);
	}
	protected void error() {
		witer(ERROR, null, null, null);
	}
	protected void error(String code) {
		witer(code, CODEMAP.get(code), null, null);
	}
	protected void error(String code, Object data) {
		witer(code, CODEMAP.get(code), null, data);
	}
	protected void error(String code, String promptType) {
		witer(code, CODEMAP.get(code), promptType, null);
	}
	protected void error(String code, String promptType, Object data) {
		witer(code, CODEMAP.get(code), promptType, data);
	}
	/**
	 * 向页面返回数据
	 * @param code       请求发挥编码
	 * @param message    返回信息描述
	 * @param promptType 错误的提示类型
	 * @param data       返回的数据
	 */
	private void witer(String code, String message, String promptType, Object data) {
		PrintWriter writer = null;
		try {
			if(code == null || code.isEmpty()) {
				throw new IllegalArgumentException();
			}
			response.setHeader("Content-type", "application/json;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			writer = response.getWriter();
			JSONObject obj = new JSONObject();
			obj.put("code", code);
			if(message != null && !message.isEmpty()) {
				obj.put("message", message);
			}
			if(promptType != null && !promptType.isEmpty()) {
				obj.put("promptType", promptType);
			}
			if(data != null) {
				obj.put("data", data);
			}
			writer.write(JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty));
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer != null)
				writer.close();
		}
	}
	
}
