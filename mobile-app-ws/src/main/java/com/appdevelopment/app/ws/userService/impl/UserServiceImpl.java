package com.appdevelopment.app.ws.userService.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdevelopment.app.ws.shared.Utils;
import com.appdevelopment.app.ws.ui.model.request.UserDetailRequestModel;
import com.appdevelopment.app.ws.ui.model.response.UserRest;
import com.appdevelopment.app.ws.userService.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	Map<String, UserRest> users;
	
	Utils utils;
	
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}

	@Override
	public UserRest createUser(UserDetailRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());

		returnValue.setEmail(userDetails.getEmail());
		String userId = utils.genereteUserId();
		returnValue.setUserId(userId);
		if (users == null)
			users = new HashMap<>();
		users.put(userId, returnValue);
		return returnValue;
	}
	
}
