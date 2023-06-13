package com.productcat.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RestExceptionHandler {

      @ExceptionHandler(IDNotFoundException.class)	
	public ResponseEntity<ApiError> IDNotFoundExceptionHandler(IDNotFoundException ie,HttpServletRequest hr)
	{
		ApiError api=new ApiError();
		api.setCode(HttpStatus.NOT_FOUND.value());
		api.setDate(new Date());
		api.setMessage(ie.getMessage());
		api.setError(HttpStatus.NOT_FOUND);
		api.setPath(hr.getRequestURI());
		return new ResponseEntity<ApiError>(api,HttpStatus.NOT_FOUND);
				
		
		
	}
}
