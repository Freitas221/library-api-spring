package com.marcos.biblioteca.project.services;

import java.util.List;

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
	
	
	public List<Loan> findAll() {
		return loanRepository.findAll();
	}
	
	public Loan createLoan(Loan obj) {
		
		Book book = bookRepository.findById(obj.getBook().getId())
				.orElseThrow(()-> new ResourceNotFoundException("Book", obj.getBook().getId(), "During insertion"));
		
		User user = userRepository.findById(obj.getUser().getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", obj.getUser().getId(), "During Insertion"));
		
		if(loanRepository.existsByBookAndStatus(book, LoanStatus.ACTIVE)) {
			throw new IllegalArgumentException();
		}
		
		Loan loan = new Loan(user, book);
		
		return loanRepository.save(loan);
	}
	
	public void delete(Long obj) {
		
		Loan loan = loanRepository.findById(obj)
				.orElseThrow(() -> new ResourceNotFoundException("Loan not found", obj));
		
		loanRepository.delete(loan);
	}

}
