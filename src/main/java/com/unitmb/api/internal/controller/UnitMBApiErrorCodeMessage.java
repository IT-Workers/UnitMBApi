package com.unitmb.api.internal.controller;

import java.util.HashMap;
import java.util.Map;

public abstract class UnitMBApiErrorCodeMessage {

	protected static String SUCCESS = "0000";
	
	protected static String ERROR = "-1";
	
	protected static String PROMPT_ALERT_TYPE = "alert";
	
	protected static String PROMPT_TOAST_TYPE = "toast";
	
	protected static String PROMPT_DIALOG_TYPE = "dialog";
	
	protected static String SAVE_SUCCESS_MESSAGE = "保存成功！";
	
	protected static String EDIT_SUCCESS_MESSAGE = "修改成功！";
	
	protected static String SAVE_FAIL_MESSAGE = "保存失败！";
	
	protected static final Map<String, String> CODEMAP = new HashMap<String, String>(); 
	
	/**
	 * 初始化错误编码信息
	 */
	static {
		CODEMAP.put("0001", "用户名或者密码错误！");
	}
}
