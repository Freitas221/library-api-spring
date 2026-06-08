package com.marcos.biblioteca.project.services.exception;

public class BookAlreadyLoanedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookAlreadyLoanedException() {
		super("O livro já foi devolvido") ;
	}
}
