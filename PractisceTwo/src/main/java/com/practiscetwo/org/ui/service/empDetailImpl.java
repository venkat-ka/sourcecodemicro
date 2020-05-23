package com.practiscetwo.org.ui.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practiscetwo.org.ui.data.empEntity;
import com.practiscetwo.org.ui.data.empRepository;
import com.practiscetwo.org.userDto.EmpDto;

@Service
public class empDetailImpl implements EmpService{
	
	@Autowired
	empRepository empRepo;
	
	
	public empDetailImpl(empRepository empRepo) {
		
		this.empRepo = empRepo;
	}


	@Override
	public EmpDto createUser(EmpDto empDetails) {
		// TODO Auto-generated method stub
		empDetails.setEmpId(UUID.randomUUID().toString());
		ModelMapper modelMap = new ModelMapper();
		modelMap.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		empEntity EmpEntity =  modelMap.map(empDetails, empEntity.class);
		EmpEntity.setEncryptedpassword("testPas");
		empRepo.save(EmpEntity);
		return null;
	}

}
