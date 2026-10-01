package com.marcos.biblioteca.project.services.exception;

public class DuplicateCpfException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DuplicateCpfException(String cpf) {
		super("Esse CPF já se encontra cadastrado em nossa base de dados");
	}
}
