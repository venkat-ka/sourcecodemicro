package com.appsdeveloperblog.photoapp.api.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.appsdeveloperblog.photoapp.api.users.shared.UserDto;

public interface UserService extends UserDetailsService{
UserDto createUser(UserDto userDetail);
UserDto getUserDetailsByEmail(String email);
UserDto getUserByUserId(String userId);
}
