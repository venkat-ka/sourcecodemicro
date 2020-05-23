package com.practiscetwo.org.userDto;

import java.io.Serializable;

public class EmpDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6642319238366480413L;
	private String empId;
	private String firstName;
	private String lastName;
	private String password;
	private String encryptPassword;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
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
	public String getEncryptPassword() {
		return encryptPassword;
	}
	public void setEncryptPassword(String encryptPassword) {
		this.encryptPassword = encryptPassword;
	}
	
}
