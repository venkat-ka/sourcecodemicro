package com.usermanagment.org.data;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="StoreUser")
public class StoreUserEntity implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2156220908675820973L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, length=50, unique=true)
	private String storename;
	
	@Column(nullable = false, length=50)
	private String dutyHours;
	
	@Column(nullable = false, length=150)
	private String salary;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval=true)
    @JoinColumn(name = "usermanagment_userid", referencedColumnName = "userId")
	private UserManagmentEntity usermanagment;

	

	public StoreUserEntity() {
		
		// TODO Auto-generated constructor stub
	}

	public StoreUserEntity(String storename, String dutyHours, String salary) {
		super();
		this.storename = storename;
		this.dutyHours = dutyHours;
		this.salary = salary;
		
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserManagmentEntity getUsermanagment() {
		return usermanagment;
	}

	public void setUsermanagment(UserManagmentEntity usermanagment) {
		this.usermanagment = usermanagment;
	}
	
	
//
//	public UserManagmentEntity getUserManagmentEntity() {
//		return userManagmentEntity;
//	}
//
//	public void setUserManagmentEntity(UserManagmentEntity userManagmentEntity) {
//		this.userManagmentEntity = userManagmentEntity;
//	}




	

	

	
	
}
