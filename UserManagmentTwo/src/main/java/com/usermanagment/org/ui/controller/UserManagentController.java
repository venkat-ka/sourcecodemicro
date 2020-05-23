package com.usermanagment.org.ui.controller;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;
import com.usermanagment.org.Models.CreateRequestStoreUser;
import com.usermanagment.org.Models.CreateRequestUserManagment;
import com.usermanagment.org.Models.CreateResponseStoreUser;
import com.usermanagment.org.Models.CreateResponseUserManagment;
import com.usermanagment.org.shared.StoreUserDts;
import com.usermanagment.org.shared.UserManagmentDts;
import com.usermanagment.org.userservice.StoreUserService;
import com.usermanagment.org.userservice.UserManagmentService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jdk.internal.jline.internal.Log;


@RestController
@RequestMapping("/usermanage")
public class UserManagentController {
	
	@Autowired
	UserManagmentService userManagService;
	
	@Autowired
	StoreUserService createstoreuser;
	
	private static final Logger LOG = Logger.getLogger(UserManagentController.class.getName());
	
	@Autowired
	private Environment env;
//	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<CreateResponseUserManagment> createManagment(@Valid @RequestBody CreateRequestUserManagment userDetails) {
//		ModelMapper modelmap = new ModelMapper();
//		modelmap.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//		UserManagmentDts userManagmentDts = modelmap.map(userDetails, UserManagmentDts.class);
//		UserManagmentDts createUser = userManagService.createUserManagment(userManagmentDts);
//		CreateResponseUserManagment returnValue = modelmap.map(createUser, CreateResponseUserManagment.class);
//		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
//	}
	
	@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<CreateResponseUserManagment> createManagment(@RequestParam(value="fileUpl") MultipartFile fileUpl, @Valid CreateRequestUserManagment userDetails, @RequestHeader(value="Authorization") String Auth)throws IOException {
		
		String token = Auth.replace("Bearer", "");
	
		Claims claims = Jwts.parser()         
			       .setSigningKey(env.getProperty("token.secret"))
			       .parseClaimsJws(token).getBody();
		System.out.println("Subject: " + claims.getSubject());
		userDetails.setUserId(claims.getSubject());
		/* End */
	//	res
		ModelMapper modelmap = new ModelMapper();
		modelmap.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserManagmentDts userManagmentDts = modelmap.map(userDetails, UserManagmentDts.class);
		UserManagmentDts createUser = userManagService.createUserManagment(userManagmentDts);
		CreateResponseUserManagment returnValue = modelmap.map(createUser, CreateResponseUserManagment.class);
		
		
		
		
/* FIle Upload */
		
		
		if(fileUpl != null) {
			String path =  fileUpl.getOriginalFilename();
			String fExt = Files.getFileExtension(path);
			System.out.println(fExt);
			File ConvertFile = new File("/home/venkatesh/uploadrestfile/"+createUser.getFullname()+"-uploaded");
			//https://stackoverflow.com/questions/23446928/spring-boot-uploading-files-path
			//System.out.println(fileN.getName());
			ConvertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(ConvertFile);
			fout.write(fileUpl.getBytes());
			fout.close();
			}
		
		/* End */
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
	
	@PostMapping(value="/status/check", consumes = {MediaType.APPLICATION_JSON_VALUE},
		produces= {MediaType.APPLICATION_JSON_VALUE}	
	)
	public ResponseEntity<CreateResponseStoreUser> storeManage(@Valid @RequestBody CreateRequestStoreUser storeUser, @RequestHeader(value="Authorization") String Auth)throws IOException{
		
		String token = Auth.replace("Bearer", "");
		
		Claims claims = Jwts.parser()         
			       .setSigningKey(env.getProperty("token.secret"))
			       .parseClaimsJws(token).getBody();
		
		//return ResponseEntity.status(HttpStatus.CREATED).body(storeUser);
		ModelMapper dataSave = new ModelMapper();
		dataSave.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		System.out.println(" ?...?");
		StoreUserDts storeDts = dataSave.map(storeUser, StoreUserDts.class);
		StoreUserDts storret = createstoreuser.createStoreUser(storeDts, claims.getSubject());
		//storret.setUsermanagmententity(storeUser.getUsermanagment().getUserId());
		CreateResponseStoreUser storedRes = dataSave.map(storret, CreateResponseStoreUser.class);
		//System.out.println(storeUser.getUsermanagment().getUserId());
		storedRes.setUserManagmentEntity(claims.getSubject());
		//return new ResponseEntity<String>("Created", HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.CREATED).body(storedRes);
		
	}
}
