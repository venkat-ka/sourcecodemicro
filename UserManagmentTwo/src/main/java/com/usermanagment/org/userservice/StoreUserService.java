package com.usermanagment.org.userservice;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.usermanagment.org.shared.StoreUserDts;

public interface StoreUserService extends UserDetailsService {
	StoreUserDts createStoreUser(StoreUserDts storeusr, String userid);
}
