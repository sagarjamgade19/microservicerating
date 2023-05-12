package com.codesdaily.rating.RatingService.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<Map<String,Object>>handleResourceNotFoundException(ResourceNotFound found){
		
		Map<String,Object> map=new HashMap<>();
		map.put("message",found.getMessage());
		map.put("success", false);
		map.put("status", HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
}
