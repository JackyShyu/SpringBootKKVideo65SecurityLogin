package org.shyu.springboot.controller;

import org.shyu.springboot.model.UserInfo;
import org.shyu.springboot.service.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserInfoController {
	@Autowired
	private UserInfoServiceImpl userInfoService;
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public UserInfo getUserInfo(@PathVariable("username") String username) {
		return userInfoService.getActiveUser(username);
	}

}
