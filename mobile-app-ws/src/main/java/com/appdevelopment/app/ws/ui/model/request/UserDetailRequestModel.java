package com.appdevelopment.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailRequestModel {
	@NotNull(message="FirstName Cannot be Null")
	private String firstName;
	@NotNull(message="LastName Cannot Null")
	private String lastName;
	@NotNull(message="Email cannot Null")
	@Email
	private String email;
	@NotNull(message="Password cannot be null")
	@Size(min=8,max=16, message="Password should be with 8 to 16 Charachter")
	private String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
