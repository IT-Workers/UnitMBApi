package com.unitmb.api.user.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unitmb.api.internal.controller.UnitMBApiController;
import com.unitmb.api.user.model.User;
import com.unitmb.api.user.service.UserService;

@Scope("request")
@RestController
@RequestMapping(path = "/user")
public class UserController extends UnitMBApiController{
	
	@Resource
	private UserService userService;
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public void login(User user) {
		User u = userService.login(user);
		if(u == null) {
			error("0001", PROMPT_ALERT_TYPE);
		}else {
			success(u);
		}
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public void addUser(User user) {
		userService.addUser(user);
	}
}
