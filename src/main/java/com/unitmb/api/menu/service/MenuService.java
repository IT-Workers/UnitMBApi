package com.unitmb.api.menu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.unitmb.api.menu.dao.MenuDao;

@Service
public class MenuService {

	@Resource
	private MenuDao menuDao;
	
	public List<Map<String, Object>> getLeftMenu(){
		List<Map<String, Object>> list = menuDao.getAllMenu();
		return createLeftMenu(list);
	}
	
	private List<Map<String, Object>> createLeftMenu(List<Map<String, Object>> list){
		if(list == null) {
			return null;
		}
		List<Map<String, Object>> parentMenuList = new ArrayList<Map<String,Object>>();
		for(Map<String, Object> parent : list) {
			if(parent.get("parentMenuId") == null) {
				List<Map<String, Object>> chMenuList = new ArrayList<Map<String,Object>>();
				for(Map<String, Object> child : list) {
					if(parent.get("menuId").equals(child.get("parentMenuId"))) {
						chMenuList.add(child);
					}
				}
				parent.put("childMenuList", chMenuList);
				parentMenuList.add(parent);
			}
		}
		return parentMenuList;
	}
}
