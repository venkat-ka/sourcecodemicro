package com.appsdeveloperblog.photoapp.api.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
	@NotNull(message="FirstNAme cannot be null")
	@Size(min=2,message="FirstName must not less than two charachter")
	
	private String firstName;
	
	@NotNull(message="LastName cannot be null")
	@Size(min=2,message="LastName must not less than two charachter")
	private String lastName;
	
	@NotNull(message="Password Cannot be empty")
	@Size(min=8, max=16, message="Password should be within from 8 to 16")
	private String password;
	
	@NotNull(message="Email Cannot be empty")
	@Email
	private String email;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
