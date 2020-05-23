package com.usermanagment.org.Models;

import javax.validation.constraints.NotNull;

public class CreateRequestUserManagment {
	
	@NotNull(message ="Full Name Required" )
	private String fullname;
	
	@NotNull(message = "Department Required")
	private String department;
	
	@NotNull(message = "Role Required")
	private String role;
	
	private String userId;
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
