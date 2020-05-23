package com.practiscethree.org.ui.empthree.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practiscethree.org.ui.empthree.data.empThreeEntity;
import com.practiscethree.org.ui.empthree.model.empThreeDetail;
import com.practiscethree.org.ui.empthree.service.empThreeService;
import com.practiscethree.org.ui.empthree.shared.empThreeDto;

@RestController
@RequestMapping("/empthree")
public class empThree {
	
	@Autowired
	empThreeService empThreeService;
	
	@PostMapping
	public String createuser(@Valid @RequestBody empThreeDetail empDetail) {
		
		ModelMapper ModelMap = new ModelMapper();
		ModelMap.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		empThreeDto empDto = ModelMap.map(empDetail, empThreeDto.class);
		empThreeService.createUser(empDto);
		return "Creat Three";
	}
	
	@GetMapping
	public String getUsers(){
		return "get users";
	}
	
	@GetMapping(path="{userId}")
	public String getUser(String userId) {
		return "list user";
	}
	
	@PutMapping(path= "{userId}")
	public String updateUser() {
		return "update user";
	}
}
