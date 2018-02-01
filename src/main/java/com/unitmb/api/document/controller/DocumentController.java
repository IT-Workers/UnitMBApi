package com.unitmb.api.document.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unitmb.api.document.model.APIDocument;
import com.unitmb.api.document.service.DocumentService;
import com.unitmb.api.internal.controller.UnitMBApiController;

@Scope("request")
@RestController
@RequestMapping(path = "/doc")
public class DocumentController extends UnitMBApiController{

	@Resource
	private DocumentService documentService;

	@RequestMapping(path = "/detail", method = RequestMethod.POST)
	public void getDocDetail(int id) {
		success(documentService.getDocumentDetailById(id));
	}
	
	@RequestMapping(path = "/edit", method = RequestMethod.POST)
	public void docEdit(APIDocument document) {
		boolean isOk = documentService.saveOrUpdateAPIDocument(document);
		if(isOk) {
			success(SAVE_SUCCESS_MESSAGE, PROMPT_TOAST_TYPE);
		}else {
			success(SAVE_FAIL_MESSAGE, PROMPT_TOAST_TYPE);
		}
		
	}
}
