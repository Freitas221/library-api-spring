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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_loan")  //Time to implement the service.
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonIgnore
	private Users users;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo status não pode ser nulo")
	private LoanStatus status;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Book book;
	
	@NotNull
	private LocalDate loanDate;
	
	public Loan() {
	}
	
	public Loan(Users users, Book book) {
		this.users = users;
		this.book = book;
		this.loanDate = LocalDate.now();
		setLoanStatus(LoanStatus.ACTIVE);
	}
	
	public Users getUsers() {
		return users;
	}
	
	public Book getBook() {
		return  book;
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
