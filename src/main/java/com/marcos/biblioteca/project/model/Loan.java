package com.marcos.biblioteca.project.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcos.biblioteca.project.enums.LoanStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
	
	@NotBlank(message = "O campo status não pode ser nulo")
	private Integer status;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Book book;
	
	@NotNull
	private LocalDate loanDate;
	
	
	public Loan() {
	}
	
	
	public Loan(Users users, Book book, LoanStatus status) {
		this.users = users;
		this.book = book;
		this.loanDate = LocalDate.now();
		setLoanStatus(LoanStatus.valueOf(1));
	}
	
	public Users getUsers() {
		return users;
	}
	
	public Book getBook() {
		return  book;
	}
	
	public LoanStatus getLoanStatus() {
		return LoanStatus.valueOf(status);
	}
	
	public void setLoanStatus(LoanStatus status) {
		if(status != null) {
			this.status = status.getCode();
		}
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}
}
