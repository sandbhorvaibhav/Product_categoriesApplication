package com.productcat.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ApiError {
	
	private Integer code;
	private Date date;
	private String message;
	private HttpStatus Error;
	private String path;
	
}
