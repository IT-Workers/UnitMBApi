package com.unitmb.api.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unitmb.api.user.dao.UserDao;
import com.unitmb.api.user.model.User;

@Service
public class UserService {

	@Resource
	private UserDao userDao;
	
	public User login(User user) {
		return userDao.getUserByUserNameAndPassWord(user.getUserName(), user.getPassWord());
	}
	
	@Transactional
	public boolean addUser(User user) {
		return userDao.inserUser(user) > 0;
	}
}
