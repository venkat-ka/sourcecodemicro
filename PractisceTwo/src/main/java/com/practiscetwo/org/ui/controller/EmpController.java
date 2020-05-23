package com.practiscetwo.org.ui.controller;

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

import com.practiscetwo.org.ui.service.EmpService;
import com.practiscetwo.org.userDto.EmpDto;
import com.practiscetwo.ui.model.empdetail.empRequest;

@RestController
@RequestMapping("/users")
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@PostMapping()
	public String createUser(@Valid @RequestBody empRequest empDetail) {
		ModelMapper ModelMap = new ModelMapper();
		ModelMap.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		EmpDto EmpDto = ModelMap.map(empDetail, EmpDto.class);
		empService.createUser(EmpDto);
		return "Create";
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
