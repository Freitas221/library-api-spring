package com.marcos.biblioteca.project.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcos.biblioteca.project.enums.LoanStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_loan")  
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonIgnore
	private User user;
	
	@Enumerated(EnumType.STRING)
	private LoanStatus status;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Book book;
	
	private LocalDate loanDate;
	
	public Loan() {
	}
	
	public Loan(User user, Book book) {
		this.user = user;
		this.book = book;
		this.loanDate = LocalDate.now();
		setLoanStatus(LoanStatus.ACTIVE);
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
		return  book;
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
}
