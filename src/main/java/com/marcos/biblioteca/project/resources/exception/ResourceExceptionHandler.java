package com.marcos.biblioteca.project.resources.exception;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.marcos.biblioteca.project.services.exception.DatabaseException;
import com.marcos.biblioteca.project.services.exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = ("Resource not found");
		HttpStatus status =  HttpStatus.NOT_FOUND;
		StandardError sr = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(sr);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseException(DatabaseException e, HttpServletRequest request) {
		String error = ("Referential integrity");
		HttpStatus status = HttpStatus.CONFLICT;
		
		StandardError sr = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(sr);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String error = ("Error validating fields");
		
	    String message = e.getBindingResult()
	            .getFieldErrors()
	            .stream()
	            .map(err -> err.getField() + ": " + err.getDefaultMessage())
	            .collect(Collectors.joining(", ")); //Take all the fields, join them, and separate them with commas.
	    
	    StandardError sr = new StandardError(Instant.now(), status.value(), error, message, request.getRequestURI());
		
	    return ResponseEntity.status(status).body(sr);
	}
}
