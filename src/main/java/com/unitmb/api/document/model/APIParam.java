package com.unitmb.api.document.model;

import java.io.Serializable;

import com.unitmb.api.internal.model.UnitMBApiModel;

public class APIParam extends UnitMBApiModel implements Serializable{

	/**
	 * @author Sun yan
	 * 文档参数
	 */
	private static final long serialVersionUID = -2957470783264771474L;
	
	public static final int PARAM_TYPE_INT = 0;
	
	public static final int PARAM_TYPE_LONG = 1;
	
	public static final int PARAM_TYPE_DOUBLE = 2;
	
	public static final int PARAM_TYPE_STRING = 3;
	
	public static final int PARAM_TYPE_BOOLEAN = 4;
	
	public static final int PARAM_TYPE_DATE = 5;
	
	private int paramId;
	
	private String paramName;
	
	private int paramType;
	
	private boolean must;
	
	private String description;
	
	private int documentId;

	public int getParamId() {
		return paramId;
	}

	public void setParamId(int paramId) {
		this.paramId = paramId;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public int getParamType() {
		return paramType;
	}

	public void setParamType(int paramType) {
		this.paramType = paramType;
	}

	public boolean isMust() {
		return must;
	}

	public void setMust(boolean must) {
		this.must = must;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

}
