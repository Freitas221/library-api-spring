package com.marcos.biblioteca.project.services.exception;

public class PublisherResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public PublisherResourceNotFoundException() {
		super("Publisher not found, object cannot be persisted");
	}

}
