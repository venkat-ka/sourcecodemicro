package com.practiscethree.org.ui.empthree.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class empThreeDetail {
	
	@NotNull(message="Email should not empty")
	@Email(message = "Invalid Email")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

