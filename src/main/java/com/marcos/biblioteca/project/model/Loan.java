package com.marcos.biblioteca.project.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.marcos.biblioteca.project.enums.LoanStatus;
import com.marcos.biblioteca.project.services.exception.BookAlreadyLoanedException;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_loan")  
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private User user;
	
	@Enumerated(EnumType.STRING)
	private LoanStatus status;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Book book;
	
	private LocalDate loanDate;
	
	private LocalDate dueDate;
	
	private Long delayedDays;
	
	private LocalDate returnDate;
	
	public Loan() {
	}
	
	public Loan(User user, Book book) {
		this.user = user;
		this.book = book;
		this.loanDate = LocalDate.now();
		this.dueDate = loanDate.plusDays(7);
		setLoanStatus(LoanStatus.ACTIVE);
	}
	
	@PrePersist
	public void PrePersist() {
		if(this.loanDate == null) {
			this.loanDate = LocalDate.now();
		}
		
		this.returnDate = LocalDate.now();
		
		if(returnDate.isAfter(dueDate)) {
			this.delayedDays = ChronoUnit.DAYS.between(loanDate, dueDate);
		}else {
			this.delayedDays = 0L;
		}
		
		this.status = LoanStatus.RETURNED;
	}
	
	public void markAsReturned() {
		if(this.status == LoanStatus.RETURNED) {
			throw new BookAlreadyLoanedException();
		}
		
		this.status = LoanStatus.RETURNED;
		this.returnDate = LocalDate.now();
	}
	
	public void delayedReturn() {
		if(this.status == LoanStatus.RETURNED) {	
		}
	}

	public Long getId() {
		return id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public LoanStatus getLoanStatus() {
		return status;
	}
	
	public void setLoanStatus(LoanStatus status) {
		if(status == null) {
			throw new IllegalArgumentException("Status não pode ser nulo");
		}
		this.status = status;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}
	
	public LocalDate getReturnDate() {
		return returnDate;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	public Long getDelayedDays() {
		return delayedDays;
	}
}
