package com.practise.demo.ui.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.demo.ui.emp.data.empEntity;
import com.practise.demo.ui.emp.data.empRepository;
import com.practise.demo.ui.shared.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	empRepository userRepository;
	
	public UserServiceImpl(empRepository userRepository) {
		
		this.userRepository = userRepository;
	}

	@Override
	public UserDto createUser(UserDto userDetail) {
		
		userDetail.setEmpId(UUID.randomUUID().toString());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		empEntity EmpEntity = modelMapper.map(userDetail, empEntity.class);
		EmpEntity.setEncryptedPassword("test");
		userRepository.save(EmpEntity);
		return null;
	}
	
}
