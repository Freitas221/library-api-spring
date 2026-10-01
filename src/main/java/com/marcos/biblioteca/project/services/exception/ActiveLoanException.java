package com.marcos.biblioteca.project.services.exception;

public class ActiveLoanException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ActiveLoanException() {
		super("O livro se encontra emprestado");
	}
	
	public ActiveLoanException(String name) {
		super("O usuário: " + name + "- " + "já possui empréstimos ativo.");
	}
}
