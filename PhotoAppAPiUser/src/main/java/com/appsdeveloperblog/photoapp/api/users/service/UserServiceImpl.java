package com.appsdeveloperblog.photoapp.api.users.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.appsdeveloperblog.photoapp.api.users.data.AlbumServiceClient;
import com.appsdeveloperblog.photoapp.api.users.data.UserRepository;
import com.appsdeveloperblog.photoapp.api.users.data.userEntity;
import com.appsdeveloperblog.photoapp.api.users.shared.UserDto;
import com.appsdeveloperblog.photoapp.api.users.ui.model.AlbumResponseModel;
import com.appsdeveloperblog.photoapp.api.users.ui.model.FileStorageException;
import com.appsdeveloperblog.photoapp.api.users.ui.model.MyFileNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	//RestTemplate restTemplate;
	Environment environment;
	AlbumServiceClient albumServiceClient;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AlbumServiceClient albumServiceClient, Environment environment) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.albumServiceClient = albumServiceClient;
		this.environment = environment;
		
	}
	@Override
	public UserDto createUser(UserDto userDetails) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		userDetails.setUserId(randomUserId);
		userDetails.setFilename(randomUserId);
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		ModelMapper modelMapper = new ModelMapper();
		System.out.println(userDetails);
		//userDetails.setFilename("testing Filename");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		userEntity UserEntity = modelMapper.map(userDetails, userEntity.class);
		
		userRepository.save(UserEntity);
		UserDto returnValue = modelMapper.map(UserEntity, UserDto.class);
		return returnValue; 
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		userEntity userEntity = userRepository.findByEmail(username);
		if(userEntity==null) throw new UsernameNotFoundException(username);
		
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
	}
	@Override
	public UserDto getUserDetailsByEmail(String email) {
		// TODO Auto-generated method stub
				userEntity userEntity = userRepository.findByEmail(email);
				if(userEntity==null) throw new UsernameNotFoundException(email);
		return new ModelMapper().map(userEntity, UserDto.class);
	}
	@Override
	public UserDto getUserByUserId(String userId) {
		userEntity userEntity = userRepository.findByUserId(userId);
		if(userEntity == null)throw new UsernameNotFoundException("user Not Found");
		UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
		/*
		String albumsurl = String.format(environment.getProperty("album.url"), userId);
		
		ResponseEntity<List<AlbumResponseModel>> albumsListResponse = restTemplate.exchange(albumsurl,HttpMethod.GET, null, new ParameterizedTypeReference<List<AlbumResponseModel>>() {});
		List<AlbumResponseModel> albumsList = albumsListResponse.getBody();
		*/
		logger.info("Before calling album Microseervice");
		List<AlbumResponseModel> albumsList=albumServiceClient.getAlbums(userId);
		logger.info("After calling album Microseervice");
		userDto.setAlbums(albumsList);
		return userDto;
	}
	
}
