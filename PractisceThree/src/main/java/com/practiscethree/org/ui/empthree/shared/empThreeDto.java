package com.practiscethree.org.ui.empthree.shared;

import java.io.Serializable;

public class empThreeDto implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6411228833274079258L;
	
	
	private String empId;
	private String Email;
	
	
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
