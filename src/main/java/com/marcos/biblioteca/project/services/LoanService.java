package com.marcos.biblioteca.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.biblioteca.project.enums.LoanStatus;
import com.marcos.biblioteca.project.model.Book;
import com.marcos.biblioteca.project.model.Loan;
import com.marcos.biblioteca.project.model.User;
import com.marcos.biblioteca.project.repositories.BookRepository;
import com.marcos.biblioteca.project.repositories.LoanRepository;
import com.marcos.biblioteca.project.repositories.UserRepository;
import com.marcos.biblioteca.project.services.exception.ResourceNotFoundException;

@Service
public class LoanService {

	@Autowired
	public LoanRepository loanRepository;
	
	@Autowired
	public BookRepository bookRepository;
	
	@Autowired 
	public UserRepository userRepository;
	
	public Loan createLoan(Loan obj) {
		
		Book book = bookRepository.findById(obj.getBook().getId())
				.orElseThrow(()-> new ResourceNotFoundException("Book", obj.getBook().getId(), "During insertion"));
		
		User user = userRepository.findById(obj.getUser().getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", obj.getUser().getId(), "During Insertion"));
		
		if(loanRepository.existsByBookAndStatus(book, LoanStatus.ACTIVE)) {
			throw new IllegalArgumentException();
		}
		
		obj.setBook(book);
		obj.setUser(user);
		
		return loanRepository.save(obj);
	}

}
