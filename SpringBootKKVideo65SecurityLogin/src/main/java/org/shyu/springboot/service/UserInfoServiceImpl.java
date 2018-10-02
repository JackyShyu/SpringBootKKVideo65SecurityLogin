package org.shyu.springboot.service;

import org.shyu.springboot.dao.UserInfoDaoImpl;
import org.shyu.springboot.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	//@Autowired
	//private UserInfoRepository userInfoRepository;
	
	@Autowired
	private UserInfoDaoImpl userInfoDaoImpl;
	
	@Override
	public UserInfo getActiveUser(String userName) {
		//return userInfoRepository.findById(userName).get();
		
		return userInfoDaoImpl.getActiveUser(userName);
	}
}
