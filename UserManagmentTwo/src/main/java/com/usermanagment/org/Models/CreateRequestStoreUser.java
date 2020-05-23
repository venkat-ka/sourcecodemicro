package com.usermanagment.org.Models;

import javax.validation.constraints.NotNull;

import com.usermanagment.org.data.UserManagmentEntity;

public class CreateRequestStoreUser {
	
	@NotNull(message ="Storename Required")
	private String storename;
	
	@NotNull(message ="DutyHours Required")
	private String dutyHours;
	
	@NotNull(message ="Salary Required")
	private String salary;
	
	private UserManagmentEntity usermanagment;
	
	

	public CreateRequestStoreUser() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CreateRequestStoreUser(@NotNull(message = "Storename Required") String storename,
			@NotNull(message = "DutyHours Required") String dutyHours,
			@NotNull(message = "Salary Required") String salary, UserManagmentEntity usermanagment) {
		super();
		this.storename = storename;
		this.dutyHours = dutyHours;
		this.salary = salary;
		this.usermanagment = usermanagment;
	}


	public String getStorename() {
		return storename;
	}


	public void setStorename(String storename) {
		this.storename = storename;
	}


	public String getDutyHours() {
		return dutyHours;
	}


	public void setDutyHours(String dutyHours) {
		this.dutyHours = dutyHours;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	public UserManagmentEntity getUsermanagment() {
		return usermanagment;
	}


	public void setUsermanagment(UserManagmentEntity usermanagment) {
		System.out.println(usermanagment);
		this.usermanagment = usermanagment;
	}

	

}
