package com.marcos.biblioteca.project.resources.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.marcos.biblioteca.project.services.exception.CategoryNotFoundException;
import com.marcos.biblioteca.project.services.exception.DatabaseException;
import com.marcos.biblioteca.project.services.exception.PublisherResourceNotFoundException;
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
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<StandardError> categoryNotFound(CategoryNotFoundException e, HttpServletRequest request) {
		String error = ("Category not found");
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError sr2 = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(sr2);
	}
	
	@ExceptionHandler(PublisherResourceNotFoundException.class)
	public ResponseEntity<StandardError> publisherNotFound(PublisherResourceNotFoundException e, HttpServletRequest request) {
		String error = ("Publisher not found");
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError sr3 = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(sr3);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseException(DatabaseException e, HttpServletRequest request) {
		String error = ("Referential integrity");
		HttpStatus status = HttpStatus.CONFLICT;
		
		StandardError sr4 = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(sr4);
	}
}
