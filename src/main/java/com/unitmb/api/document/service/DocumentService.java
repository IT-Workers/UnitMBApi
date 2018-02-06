package com.unitmb.api.document.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.unitmb.api.document.dao.DocumentDao;
import com.unitmb.api.document.model.APICode;
import com.unitmb.api.document.model.APIDocument;

@Service
public class DocumentService {

	@Resource
	private DocumentDao documentDao;
	
	public JSONObject getDocumentDetailById(int id){
		APIDocument document = documentDao.getDocumentById(id);
		if(document == null) {
			document = new APIDocument();
			document.setDocumentId(id);
			document.setMethodType(APIDocument.METHOD_GET);
			return (JSONObject) JSONObject.toJSON(document);	
		}else {
			JSONObject obj = (JSONObject) JSONObject.toJSON(document);	
			obj.put("params", documentDao.getParamById(id));
			obj.put("results", documentDao.getResultById(id));
			obj.put("codes", documentDao.getCodeById(id));
			return obj;
		}
	}

	public boolean saveOrUpdateAPIDocument(APIDocument document) {
		return documentDao.saveOrUpdateAPIDocument(document) > 0 ;
	}

	public boolean saveOrUpdateAPICodes(List<APICode> codes) {
		return documentDao.saveOrUpdateAPICodes(codes) > 0 ;
	}
}
