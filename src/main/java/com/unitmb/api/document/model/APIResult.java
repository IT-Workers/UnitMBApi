package com.unitmb.api.document.model;

import java.io.Serializable;

import com.unitmb.api.internal.model.UnitMBApiModel;

public class APIResult extends UnitMBApiModel implements Serializable{

	/**
	 * @author Sun yan
	 * api返回结果
	 */
	private static final long serialVersionUID = -3833279943214238657L;
	
	public static final int RESULT_TYPE_NODE = -1;
	
	public static final int RESULT_TYPE_INT = 0;
	
	public static final int RESULT_TYPE_LONG = 1;
	
	public static final int RESULT_TYPE_DOUBLE = 2;
	
	public static final int RESULT_TYPE_STRING = 3;
	
	public static final int RESULT_TYPE_BOOLEAN = 4;
	
	public static final int RESULT_TYPE_DATE = 5;
	
	private int resultId;
	
	private String resultName;
	
	private int resultType;
	
	private String description;
	
	private int documentId;

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

	public int getResultType() {
		return resultType;
	}

	public void setResultType(int resultType) {
		this.resultType = resultType;
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
