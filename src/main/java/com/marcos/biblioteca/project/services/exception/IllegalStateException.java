package com.marcos.biblioteca.project.services.exception;

public class IllegalStateException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public IllegalStateException() {
		super("O livro se encontra emprestado");
	}
	
	public IllegalStateException(String name) {
		super("O usuário: " + name + "- " + "já possui empréstimos ativo.");
	}
}
