package com.unitmb.api.document.model;

import java.io.Serializable;

import com.unitmb.api.internal.model.UnitMBApiModel;

public class APIDocument extends UnitMBApiModel implements Serializable{

	/**
	 * @author Sun yan
	 */
	private static final long serialVersionUID = 4383402642362201852L;
	
	public static final int METHOD_GET = 0;
	
	public static final int METHOD_POST = 1;
	
	public static final int METHOD_PUT = 2;
	
	public static final int METHOD_DELETE = 3;
	
	private int documentId;
	
	private String httpUrl;
	
	private int methodType;
	
	private String description;

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getHttpUrl() {
		return httpUrl;
	}

	public void setHttpUrl(String httpUrl) {
		this.httpUrl = httpUrl;
	}

	public int getMethodType() {
		return methodType;
	}

	public void setMethodType(int methodType) {
		this.methodType = methodType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
