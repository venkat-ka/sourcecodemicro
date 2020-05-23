package com.usermanagment.org.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.usermanagment.org.shared.UserManagmentDts;

@Repository
public interface UserManagmentRepository extends CrudRepository<UserManagmentEntity, Long> {
	//CrudRepository
		UserManagmentEntity findByUserId(String userId);
}
