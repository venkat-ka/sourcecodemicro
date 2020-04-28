package com.appdeveloperblog.photo.api.gateway.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends BasicAuthenticationFilter{

	Environment environment;
	
	public AuthorizationFilter(AuthenticationManager authenticationManager, Environment environment) {
		super(authenticationManager);
		this.environment = environment;
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest req,
			HttpServletResponse res, FilterChain chain)
					throws IOException, ServletException {
		//System.out.println(environment.getProperty("authorization.token.header.name"));
		String authorizationHeader = req.getHeader(environment.getProperty("authorization.token.header.name"));
		//System.out.println(authorizationHeader);
		if(authorizationHeader == null || !authorizationHeader.startsWith(environment.getProperty("authorization.token.header.prefix"))) {
			chain.doFilter(req, res);
			return;
		}
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
		System.out.println(req);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
	
	}
	
	public UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req){
		String authorizationHeader = req.getHeader(environment.getProperty("authorization.token.header.name"));
		if(authorizationHeader == null) {
			return null;
		}
		String token = authorizationHeader.replace(environment.getProperty("authorization.token.header.prefix"),"");
		System.out.println(token);
		System.out.println(environment.getProperty("token.secret"));
		String userId = Jwts.parser()
				.setSigningKey(environment.getProperty("token.secret"))
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	
		if(userId == null)
		{
			return null;
		}
		
		return new UsernamePasswordAuthenticationToken(userId, null, new ArrayList<>());
	}
	
}
