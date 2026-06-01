package com.marcos.biblioteca.project.services.exception;

public class IllegalStateException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public IllegalStateException() {
		super("Este livro já foi devolvido");
	}
	
	public IllegalStateException(String name) {
		super("O usuário: " + name + "- " + "já possui empréstimos ativo.");
	}
}
