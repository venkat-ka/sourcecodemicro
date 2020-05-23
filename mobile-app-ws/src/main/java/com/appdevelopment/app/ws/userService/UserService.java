package com.appdevelopment.app.ws.userService;

import com.appdevelopment.app.ws.ui.model.request.UserDetailRequestModel;
import com.appdevelopment.app.ws.ui.model.response.UserRest;

public interface UserService {
 UserRest createUser(UserDetailRequestModel UserDetails);
}
