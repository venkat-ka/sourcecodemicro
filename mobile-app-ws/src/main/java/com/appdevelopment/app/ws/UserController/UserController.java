package com.appdevelopment.app.ws.UserController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdevelopment.app.ws.Exceptions.UserServiceException;
import com.appdevelopment.app.ws.ui.model.request.UserDetailRequestModel;
import com.appdevelopment.app.ws.ui.model.request.updateUserDetailRequestModel;
import com.appdevelopment.app.ws.ui.model.response.UserRest;
import com.appdevelopment.app.ws.userService.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	Map<String, UserRest> users;
	@Autowired
	UserService userService;
	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {

		return "Page " + page + "Limit" + limit + "Sort" + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@Valid @PathVariable String userId) {

//		if (true)
//			throw new UserServiceException("A user service exception thrown");

		if (users.containsKey(userId)) {

			return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
		} else {
			throw new UserServiceException("A user service exception thrown");
			//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@PostMapping(
			consumes = { 
						MediaType.APPLICATION_XML_VALUE, 
						MediaType.APPLICATION_JSON_VALUE 
						}, produces = {
						MediaType.APPLICATION_XML_VALUE, 
						MediaType.APPLICATION_JSON_VALUE 
						})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailRequestModel userDetails) {
		
		//To Activate CRUD Enable Code
		UserRest returnValue = new UserRest();
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());

		returnValue.setEmail(userDetails.getEmail());
		String userId = UUID.randomUUID().toString();
		returnValue.setUserId(userId);
		if (users == null)
			users = new HashMap<>();
		users.put(userId, returnValue);
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
		
		
//		UserRest returnValue = userService.createUser(userDetails);
		//return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}

	@PutMapping(path = "{userId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser( @PathVariable String userId,
			@Valid @RequestBody updateUserDetailRequestModel UserDetails) {
//		System.out.println("fff user Id == ");
//		System.out.println(userId);
		
		UserRest storedUserDetails = users.get(userId);
		System.out.println(storedUserDetails);
		storedUserDetails.setFirstName(UserDetails.getFirstName());
		storedUserDetails.setLastName(UserDetails.getLastName());
		System.out.println(users);
		System.out.println(UserDetails.getLastName());
		users.put(userId, storedUserDetails);
		//System.out.println(storedUserDetails);
		return storedUserDetails;

	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		users.remove(id);
		return ResponseEntity.noContent().build();
	}

	/*
	 * @DeleteMapping(path="/{id}") public ResponseEntity<String>
	 * deleteUser(@PathVariable String id) { users.remove(id); return new
	 * ResponseEntity<String>("Deleted Succesfully", HttpStatus.OK); }
	 */
}
