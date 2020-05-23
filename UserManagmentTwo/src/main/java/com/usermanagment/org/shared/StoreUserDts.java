package com.usermanagment.org.shared;

import java.io.Serializable;
import java.util.List;

import com.usermanagment.org.data.UserManagmentEntity;

public class StoreUserDts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9043316437197502947L;
	private Long id;
	
	private String storename;
	private String dutyHours;
	private String salary;
	private String usermanagmententity;
	


	public String getStorename() {
		return storename;
	}

//	public StoreUserDts( String storename, String dutyHours, String salary) {
//		super();
//		
//		this.storename = storename;
//		this.dutyHours = dutyHours;
//		this.salary = salary;
//		
//	}

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsermanagmententity() {
		return usermanagmententity;
	}

	public void setUsermanagmententity(String usermanagmententity) {
		this.usermanagmententity = usermanagmententity;
	}


}
