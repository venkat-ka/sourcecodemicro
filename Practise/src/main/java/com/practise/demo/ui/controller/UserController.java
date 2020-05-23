package com.practise.demo.ui.controller;

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
import com.practise.demo.ui.model.empDetails;
import com.practise.demo.ui.service.UserService;
import com.practise.demo.ui.shared.UserDto;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
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
	
	@PostMapping
	public String createUser(@Valid @RequestBody empDetails userDetails) {
		

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		System.out.println("fff");
		System.out.println(userDto);
		userService.createUser(userDto);
		return "Create EMP User";
		
	}
	
}
