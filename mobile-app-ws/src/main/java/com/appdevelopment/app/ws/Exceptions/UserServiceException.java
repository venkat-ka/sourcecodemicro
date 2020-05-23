package com.appdevelopment.app.ws.Exceptions;

public class UserServiceException  extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1133755363824540293L;
	
	public String message;
	public UserServiceException(String message) {
		super(message);
			System.out.println(message);
			
		
	}
}
