package com.appsdeveloperblog.photoapp.api.users.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
	
	Environment environment;
	
	@Autowired
	 public FeignErrorDecoder(Environment environment) {
		// TODO Auto-generated constructor stub
		this.environment = environment;
	}
	@Override
	public Exception decode(String methodKey, Response response) {
		switch (response.status()) {
		case 400:
			break;
		case 404: {
			// response.reason()
			if (methodKey.contains("getAlbums")) {
				//System.out.println(environment.getProperty("albums.exceptions.albums.not.found"));
				return new ResponseStatusException(HttpStatus.valueOf(response.status()), environment.getProperty("albums.exceptions.albums.not.found"));
			}
			break;
		}
		default:
			return new Exception(response.reason());

		}
		return null;
	}
}
