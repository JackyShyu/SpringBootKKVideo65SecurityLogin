package org.shyu.springboot.dao;

import org.shyu.springboot.model.UserInfo;

public interface UserInfoDao {
	public UserInfo getActiveUser(String userName);
}
