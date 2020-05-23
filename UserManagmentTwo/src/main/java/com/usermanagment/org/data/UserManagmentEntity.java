package com.usermanagment.org.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="usermanagment")

public class UserManagmentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1882291799458579998L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false, length=50, unique=true)
	private String fullname;
	
	@Column(nullable = false, length =100)
	private String department;
	
	@Column(nullable = false, length =100)
	private String role;
	
	@Column(nullable = false, length=100, unique = true)
	private String userId;
	
//	@OneToOne(mappedBy = "UserManagmentEntity", cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY, optional = false)
//	private StoreUserEntity StoreUserEntity;
//	
//public StoreUserEntity getStoreUserEntity() {
//		return StoreUserEntity;
//	}
//	public void setStoreUserEntity(StoreUserEntity storeUserEntity) {
//		StoreUserEntity = storeUserEntity;
//	}
	//
//public List<StoreUserEntity> getStoreEntity() {
//		return storeEntity;
//	}
//	public void setStoreEntity(List<StoreUserEntity> storeEntity) {
//		this.storeEntity = storeEntity;
//	}
	//	
//	public StoreUserEntity getStoreEntity() {
//		return storeEntity;
//	}
//	public void setStoreEntity(StoreUserEntity storeEntity) {
//		this.storeEntity = storeEntity;
//	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
