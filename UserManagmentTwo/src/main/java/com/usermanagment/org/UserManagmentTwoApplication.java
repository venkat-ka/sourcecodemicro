package com.usermanagment.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserManagmentTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagmentTwoApplication.class, args);
	}

}
