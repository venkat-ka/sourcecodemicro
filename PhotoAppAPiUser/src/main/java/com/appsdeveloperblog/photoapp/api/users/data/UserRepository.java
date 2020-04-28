package com.appsdeveloperblog.photoapp.api.users.data;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<userEntity, Long> {
	userEntity findByEmail(String Email);
}
