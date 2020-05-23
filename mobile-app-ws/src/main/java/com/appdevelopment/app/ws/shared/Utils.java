package com.appdevelopment.app.ws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;
@Service
public class Utils {
	public String genereteUserId() {
		return UUID.randomUUID().toString();
	}
}
