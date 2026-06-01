package com.marcos.biblioteca.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.biblioteca.project.enums.LoanStatus;
import com.marcos.biblioteca.project.model.Book;
import com.marcos.biblioteca.project.model.Loan;
import com.marcos.biblioteca.project.model.User;

public interface LoanRepository extends JpaRepository<Loan, Long> {

	boolean existsByBookAndStatus(Book book, LoanStatus loanStatus);
	
	boolean existsByUserAndStatus(User user, LoanStatus loanStatus);
}
