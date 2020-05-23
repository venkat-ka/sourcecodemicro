package com.appdevelopment.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;

public class updateUserDetailRequestModel {
	
	@NotNull(message="FirstName Cannot be Null")
	private String firstName;
	@NotNull(message="LastName Cannot Null")
	private String lastName;
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
	
	
}
