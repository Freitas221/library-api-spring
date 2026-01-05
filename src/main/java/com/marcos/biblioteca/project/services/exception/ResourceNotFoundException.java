package com.marcos.biblioteca.project.services.exception;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    public ResourceNotFoundException(String resource, Object id) {
        super(resource + " not found. Id: " + id);
    }
	
	public ResourceNotFoundException(String resource, Object id, String context) {
		super(resource + " not found. Id: " + id + " (" + context + ")"); //revision
	}

}
