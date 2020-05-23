//package com.appdevelopment.app.ws.Exceptions;
//
//import java.util.Date;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import com.appdevelopment.app.ws.ui.model.response.ErrorMessage;
//
//@ControllerAdvice
//public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
//	@ExceptionHandler(value = { Exception.class })
//	public ResponseEntity<Object> handleAnyExceptions(Exception ex, WebRequest request) {
//		
//		String errorMessageDescription = ex.getLocalizedMessage();
//
//		if (errorMessageDescription == null)
//
//			errorMessageDescription = ex.toString();
//		System.out.println("dddeee");
//		System.out.println(errorMessageDescription);
//		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
//
//		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//
//	@ExceptionHandler(value = { NullPointerException.class, UserServiceException.class })
//	public ResponseEntity<Object> handleSpecificException(Exception ex, WebRequest request) {
//		String errorMessageDescription = ex.getLocalizedMessage();
//		System.out.println("vvv");
//		System.out.println("dddeee");
//		System.out.println(errorMessageDescription);
//		if (errorMessageDescription == null)
//			errorMessageDescription = ex.toString();
//		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
//		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//
//	
//
//}
