package com.usermanagment.org.Models;

import com.usermanagment.org.data.UserManagmentEntity;

public class CreateResponseStoreUser {
	private String storename;
	private String dutyHours;
	private String salary;
	private String UserManagmentEntity;
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
//	public String getUsermanagment_userid() {
//		return Usermanagment_userid;
//	}
//	public void setUsermanagment(String Usermanagment_userid) {
//		this.Usermanagment_userid = Usermanagment_userid;
//	}
	public String getUserManagmentEntity() {
		return UserManagmentEntity;
	}
	public void setUserManagmentEntity(String userManagmentEntity) {
		UserManagmentEntity = userManagmentEntity;
	}
	
}
