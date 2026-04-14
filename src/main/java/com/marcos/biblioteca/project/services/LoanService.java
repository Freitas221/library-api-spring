package com.marcos.biblioteca.project.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.marcos.biblioteca.project.repositories.BookRepository;
import com.marcos.biblioteca.project.repositories.LoanRepository;

public class LoanService {

	@Autowired
	public LoanRepository loanRepository;
	
	@Autowired
	public BookRepository bookRepository;
	
	
	

}
