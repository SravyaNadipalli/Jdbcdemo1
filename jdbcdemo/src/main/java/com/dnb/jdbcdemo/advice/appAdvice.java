package com.dnb.jdbcdemo.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dnb.jdbcdemo.exceptions.IdNotFoundException;
import com.dnb.jdbcdemo.exceptions.InvalidContactNumber;

@ControllerAdvice
public class appAdvice {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> idNotFoundExceptionHandler(IdNotFoundException e)
	{
		Map<String,String> map = new HashMap<>();
		map.put("message",e.getMessage());
		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
		return new ResponseEntity(map,HttpStatus.NOT_FOUND);
		 
		
	}
	
	@ExceptionHandler(InvalidContactNumber.class)
	public ResponseEntity<?> invalidcontactNumberExceptionHandler(InvalidContactNumber e)
	{
		Map<String,String> map = new HashMap<>();
		map.put("message",e.getMessage());
		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
		return new ResponseEntity(map,HttpStatus.NOT_FOUND);
		 
		
	}
	

}
