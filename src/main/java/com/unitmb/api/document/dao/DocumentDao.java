package com.unitmb.api.document.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unitmb.api.document.model.APICode;
import com.unitmb.api.document.model.APIDocument;
import com.unitmb.api.internal.dao.UnitMBApiDao;

@Repository
public class DocumentDao  extends UnitMBApiDao {
	
	public APIDocument getDocumentById(int id) {
		APIDocument document = null;
		try {
			document = jdbcTemplate.queryForObject("select * from Document where documentId = ? ", new Object[] {id}, rowMapper(APIDocument.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return document;
	}
	
	public List<Map<String, Object>> getParamById(int docId) {
		List<Map<String, Object>> list = null;
		try {
			list = jdbcTemplate.queryForList("select * from Param where documentId = ? ", docId);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Map<String, Object>> getResultById(int docId) {
		List<Map<String, Object>> list = null;
		try {
			list = jdbcTemplate.queryForList("select * from Result where documentId = ? ", docId);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Map<String, Object>> getCodeById(int docId) {
		List<Map<String, Object>> list = null;
		try {
			list = jdbcTemplate.queryForList("select * from Code where documentId = ? ", docId);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Transactional
	public int saveDocument(APIDocument document) {
		String insert = " insert into Document(documentId, httpUrl, methodType, description)values(?, ?, ?, ?)";
		return jdbcTemplate.update(insert, document.getDocumentId(), document.getHttpUrl(), document.getMethodType(), document.getDescription());
	}
	
	@Transactional
	public int updateDocument(APIDocument document) {
		String update = "update Document set httpUrl=?, methodType=?, description=? WHERE documentId=?";
		return jdbcTemplate.update(update, document.getHttpUrl(), document.getMethodType(), document.getDescription(), document.getDocumentId());
	}
	@Transactional
	public int saveOrUpdateAPIDocument(APIDocument document) {
		String insert = "replace into Document(documentId, httpUrl, methodType, description)values(?, ?, ?, ?)";
		return jdbcTemplate.update(insert, document.getDocumentId(), document.getHttpUrl(), document.getMethodType(), document.getDescription());
	}

	public int saveOrUpdateAPICodes(List<APICode> codes) {
		String insert = "replace into Code(codeId, codeNumber, description, documentId) values ";
		for(int i=0; i<codes.size(); i++) {
			insert += ("(?, ?, ?, ?)" + (i == codes.size() - 1 ? ";" : ","));
		}
		return jdbcTemplate.update(insert, codes.toArray());
	}

}
