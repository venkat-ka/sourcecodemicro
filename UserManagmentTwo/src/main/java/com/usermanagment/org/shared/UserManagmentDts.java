package com.usermanagment.org.shared;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class UserManagmentDts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1704620109650023519L;
	private String id;
	private String fullname;
	private String department;
	private String role;
	private String userId;
	
	
	public UserManagmentDts(String fullname, String department, String role, String userId) {
		super();
		this.fullname = fullname;
		this.department = department;
		this.role = role;
		this.userId = userId;
	}


	public UserManagmentDts() {
		
		// TODO Auto-generated constructor stub
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getId() {
		return id;
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
