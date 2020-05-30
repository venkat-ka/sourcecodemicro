package com.appsdeveloperblog.photoapp.api.users.ui.controllers;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.appsdeveloperblog.photoapp.api.users.service.UserService;
import com.appsdeveloperblog.photoapp.api.users.shared.UserDto;
import com.appsdeveloperblog.photoapp.api.users.ui.model.CreateUserRequestModel;
import com.appsdeveloperblog.photoapp.api.users.ui.model.CreateUserResponseModel;
import com.appsdeveloperblog.photoapp.api.users.ui.model.UserResponseModel;
import com.google.common.io.Files;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private Environment env;
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploadfile";
	@Autowired
	UserService userService;
	
	@GetMapping("/status/check")
	public String status(){
		System.out.println("dddd cam");
		return "Working on Port "+ env.getProperty("local.server.port")+", with token "+
				env.getProperty("token.secret");
	}
	
//	@PostMapping(
//			consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE},
//			
//			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE }
//			)
//	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody  CreateUserRequestModel userDetails, @RequestParam(value="filename") MultipartFile filename )
//			throws IOException{
//		
//		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
//		UserDto createUser = userService.createUser(userDto);
//		CreateUserResponseModel reurnValue = modelMapper.map(createUser, CreateUserResponseModel.class);
//		return ResponseEntity.status(HttpStatus.CREATED).body(reurnValue);
//		
//	}
	
	@RequestMapping(
			method=RequestMethod.POST,
			consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
			
//			
//			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE }
			)
	public ResponseEntity<CreateUserResponseModel> createUser(@RequestParam(value="fileN", required = false) MultipartFile fileN,@Valid CreateUserRequestModel userDetails)
			throws IOException{
		
		
		
		
		//, @RequestPart CreateUserRequestModel userDetails
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		UserDto createUser = userService.createUser(userDto);
		
		CreateUserResponseModel reurnValue = modelMapper.map(createUser, CreateUserResponseModel.class);
		System.out.println("first st");
		System.out.println(fileN);
		if(fileN != null) {
			System.out.println("se st");
		String path =  fileN.getOriginalFilename();
		String fExt = Files.getFileExtension(path);
		System.out.println(fExt);
		System.out.println("th st");
		File ConvertFile = new File("/Users/venkateshkrishnakumar/Desktop/dev/uploadrestfile/"+createUser.getUserId()+"-uploaded");
		//https://stackoverflow.com/questions/23446928/spring-boot-uploading-files-path
		//System.out.println(fileN.getName());
		ConvertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(ConvertFile);
		fout.write(fileN.getBytes());
		fout.close();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(reurnValue);//ResponseEntity.status(HttpStatus.CREATED).body(reurnValue);
		
	}
//
//	@PostMapping(
//			consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE},
//			
//			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE }
//			)
//	public ResponseEntity<String> createUser( @RequestParam(value="filename") MultipartFile filename )
//			throws IOException{
//		//@Valid @RequestBody  CreateUserRequestModel userDetails,
//		//CreateUserResponseModel
////		ModelMapper modelMapper = new ModelMapper();
////		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
////		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
////		UserDto createUser = userService.createUser(userDto);
////		CreateUserResponseModel reurnValue = modelMapper.map(createUser, CreateUserResponseModel.class);
//		return new ResponseEntity<String>("Ok", HttpStatus.OK);//ResponseEntity.status(HttpStatus.CREATED).body(reurnValue);
//		
//	}
//	@PostMapping(
//			consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE },
//			
//			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE }
//			)
//	public ResponseEntity<String> createUser(@Valid String userDetails, @RequestParam(value="filename") MultipartFile filename )
//			throws IOException{
//		
//		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
//		UserDto createUser = userService.createUser(userDto);
//		CreateUserResponseModel reurnValue = modelMapper.map(createUser, CreateUserResponseModel.class);
//		return new ResponseEntity<>("Success", HttpStatus.CREATED);
//		
//	}
	
	
//	@RequestMapping(
//			method=RequestMethod.POST,
//			consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
//			
//			
//			)
//	public void createUser( @RequestParam(value="filename") MultipartFile filename )
//	throws IOException{
//		//@Valid @RequestBody  CreateUserRequestModel userDetails,
////		System.out.println(filename);
////		ModelMapper modelMapper = new ModelMapper();
////		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
////		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
////		UserDto createUser = userService.createUser(userDto);
////		CreateUserResponseModel reurnValue = modelMapper.map(createUser, CreateUserResponseModel.class);
////		return ResponseEntity.status(HttpStatus.CREATED).body(reurnValue);
//		//ResponseEntity<CreateUserResponseModel>
//		
//	}
	@RequestMapping(value="/upload", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam(value="filename") MultipartFile filename)throws IOException{
		
		String path =  filename.getOriginalFilename();
		
		File ConvertFile = new File("/home/venkatesh/uploadrestfile/"+path+"-uploaded");
		//https://stackoverflow.com/questions/23446928/spring-boot-uploading-files-path
		
		ConvertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(ConvertFile);
		fout.write(filename.getBytes());
		fout.close();
		return new ResponseEntity<>("File Uploaded Successfully", HttpStatus.OK);
	}
	
	@GetMapping(value="/{userId}", produces= { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserResponseModel> getUser(@PathVariable("userId") String userId){
		
	
		UserDto userDrto = userService.getUserByUserId(userId);
		UserResponseModel returnValue = new ModelMapper().map(userDrto, UserResponseModel.class);
		
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
}
