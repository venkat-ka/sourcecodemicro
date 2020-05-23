package com.usermanagment.org.userservice;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.usermanagment.org.shared.StoreUserDts;
import com.usermanagment.org.shared.UserManagmentDts;

public interface UserManagmentService extends UserDetailsService {
  

UserManagmentDts createUserManagment(UserManagmentDts userDetails);

}
