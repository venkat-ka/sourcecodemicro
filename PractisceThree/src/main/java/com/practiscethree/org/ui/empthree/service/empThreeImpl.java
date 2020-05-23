package com.practiscethree.org.ui.empthree.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practiscethree.org.ui.empthree.data.empThreeEntity;
import com.practiscethree.org.ui.empthree.data.empThreeRepository;
import com.practiscethree.org.ui.empthree.shared.empThreeDto;

@Service
public class empThreeImpl implements empThreeService {


	
	@Autowired
	empThreeRepository empRepo;

	public empThreeImpl(empThreeRepository empRepo) {
		super();
		this.empRepo = empRepo;
	}
	
	public empThreeDto createUser(empThreeDto empThreeDto) {
		empThreeDto.setEmpId(UUID.randomUUID().toString());
		ModelMapper ModelMap = new ModelMapper();
		ModelMap.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		empThreeEntity empth = ModelMap.map(empThreeDto, empThreeEntity.class);
		empRepo.save(empth);
		return null;
	}
	

}
