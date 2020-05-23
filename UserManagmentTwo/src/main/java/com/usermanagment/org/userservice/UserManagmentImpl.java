package com.usermanagment.org.userservice;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.usermanagment.org.data.UserManagmentEntity;
import com.usermanagment.org.data.UserManagmentRepository;
import com.usermanagment.org.shared.UserManagmentDts;

@Service
public class UserManagmentImpl implements UserManagmentService {
	@Autowired
	UserManagmentRepository userRepo;
	
	public UserManagmentImpl(UserManagmentRepository userRepo) {
		
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserManagmentDts createUserManagment(UserManagmentDts userDetails) {
		
		System.out.println("nnn m mmmmm vvvv");
		
		// TODO Auto-generated method stub
		ModelMapper userMap = new ModelMapper();
		userMap.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserManagmentEntity userMEntity = userMap.map(userDetails, UserManagmentEntity.class);
		userRepo.save(userMEntity);
		UserManagmentDts returnVal = userMap.map(userDetails, UserManagmentDts.class);
		return returnVal;
	}

}
