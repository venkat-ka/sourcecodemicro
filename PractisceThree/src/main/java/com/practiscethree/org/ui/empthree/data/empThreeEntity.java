package com.practiscethree.org.ui.empthree.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empThree")

public class empThreeEntity implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 386729909722767006L;

	@Id
	@GeneratedValue
	private long Id;
	
	@Column(nullable = false, unique = true, length=120)
	private String Email;
	
	@Column(nullable = false, unique=true)
	private String empId;
	
	


	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
}
