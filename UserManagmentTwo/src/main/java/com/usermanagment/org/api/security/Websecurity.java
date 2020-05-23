package com.usermanagment.org.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.usermanagment.org.userservice.UserManagmentService;

@Configuration
@EnableWebSecurity
public class Websecurity extends WebSecurityConfigurerAdapter{
//	
//private UserManagmentService userservice;
//
//public Websecurity(UserManagmentService userservice) {
//
//	this.userservice = userservice;
//}

@Override
protected void configure(HttpSecurity HTTP) throws Exception {
	HTTP.csrf().disable();
	HTTP.authorizeRequests().antMatchers("/**").hasIpAddress("192.168.43.205");
}
}
