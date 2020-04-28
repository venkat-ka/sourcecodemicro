package com.pickthing.app.ws.ui.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickthing.app.ws.ui.model.request.UserDetailsRequest;
import com.pickthing.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping
	public String getUsers() {
		return "All Users";
	}
	
	@GetMapping(path="/{userId}")
	public String getusers(String userId) {
		return "Useri Id";
	}
	
	@PostMapping()
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequest UserDetails) {
		UserRest retValue = new UserRest();
		retValue.setFirstName(UserDetails.getFirstName());
		retValue.setLastName(UserDetails.getLastName());
		retValue.setEmail(UserDetails.getEmail());
		return new ResponseEntity<UserRest>(retValue, HttpStatus.OK);
	}
	
	@DeleteMapping(path="{userId}")
	public String deleteUser(String UserId) {
		return "Delete Users";
	}
	
	@PutMapping(path="{userId}")
	public String UpdateUsers(String userId) {
		return "Update Users";
	}
	
}
