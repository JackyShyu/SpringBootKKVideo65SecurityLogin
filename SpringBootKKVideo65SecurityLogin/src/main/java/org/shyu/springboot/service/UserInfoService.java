package org.shyu.springboot.service;

import org.shyu.springboot.model.UserInfo;

public interface UserInfoService {
	public abstract UserInfo getActiveUser(String username);
}
