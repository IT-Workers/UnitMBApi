package com.unitmb.api.document.model;

import java.io.Serializable;

import com.unitmb.api.internal.model.UnitMBApiModel;

public class APICode extends UnitMBApiModel implements Serializable{

	/**
	 * @author Sun yan
	 */
	private static final long serialVersionUID = 5504515344730710137L;
	
	private int codeId;
	
	private String codeNumber;
	
	private String description;
	
	private int documentId;

	public int getCodeId() {
		return codeId;
	}

	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}

	public String getCodeNumber() {
		return codeNumber;
	}

	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
