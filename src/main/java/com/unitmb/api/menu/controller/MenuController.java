package com.unitmb.api.menu.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unitmb.api.internal.controller.UnitMBApiController;
import com.unitmb.api.menu.service.MenuService;
import com.unitmb.api.user.model.User;

@Scope("request")
@RestController
@RequestMapping(path = "/menu")
public class MenuController extends UnitMBApiController{
	
	@Resource
	private MenuService menuService;

	@RequestMapping(path = "/list", method = RequestMethod.POST)
	public void getMenuList(User user) {
		success(menuService.getLeftMenu());
	}
}
