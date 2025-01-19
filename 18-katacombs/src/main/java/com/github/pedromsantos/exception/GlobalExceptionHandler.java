package com.github.pedromsantos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFound(IllegalArgumentException e) {
		return e.getMessage();
	}

	@ExceptionHandler(IllegalStateException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public String handleMethodNotAllowed(IllegalStateException e) {
		return e.getMessage();
	}
}