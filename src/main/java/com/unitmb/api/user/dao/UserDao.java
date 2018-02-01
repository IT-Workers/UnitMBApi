package com.unitmb.api.user.dao;

import java.util.Collection;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.unitmb.api.internal.dao.UnitMBApiDao;
import com.unitmb.api.internal.tool.UnitMBApiTool;
import com.unitmb.api.user.model.User;

/**
 * 
 * @author Sun yan
 *
 */
@Repository
public class UserDao extends UnitMBApiDao{
	/**
	 * 通过用户名和密码获取用户
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public User getUserByUserNameAndPassWord(String userName, String passWord) {
		User user = null;
		try {
			user = jdbcTemplate.queryForObject("select * from User where userName = ? and passWord = ? ", new Object[] {userName, UnitMBApiTool.Security.md5(passWord)}, rowMapper(User.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	public int inserUser(User user) {
		return jdbcTemplate.update("insert into User(username, password) values(?, ?)",
				user.getUserName(), UnitMBApiTool.Security.md5(user.getPassWord()));
	}
	/**
	 * 更新用户数据
	 * @param userId
	 * @param filedValue
	 * @return
	 */
	public int updateUser(int userId, Map<String, Object> filedValue) {
		String update = "upate User set ";
		Object[] fileds = filedValue.keySet().toArray();
		int len = fileds.length;
		for(int i=0; i<len; i++) {
			update += fileds[i] + ((len -1) == i ? " ? " : " ? , ");
		}
		update += " where userId = ?";
		Collection<Object> vaules = filedValue.values();
		vaules.add(userId);
		return jdbcTemplate.update(update, vaules.toArray());
	}
}
