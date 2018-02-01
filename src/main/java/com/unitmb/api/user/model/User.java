package com.unitmb.api.user.model;

import java.io.Serializable;
import java.util.Date;

import com.unitmb.api.internal.model.UnitMBApiModel;

public class User extends UnitMBApiModel implements Serializable{

	/**
	 * @author Sun yan
	 */
	private static final long serialVersionUID = 584603179908613884L;
	
	private int userId;
	
	private String userName;
	
	private String passWord;
	
	private Date createTime;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
