package com.marcos.biblioteca.project.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcos.biblioteca.project.enums.LoanStatus;

<<<<<<< HEAD
=======
import jakarta.persistence.Column;
>>>>>>> a1411aa58555a5168f32d69d576abe41bb4b9bfe
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
<<<<<<< HEAD
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_loan")  //Time to implement the service.
=======

@Entity
@Table(name = "tb_loan")
>>>>>>> a1411aa58555a5168f32d69d576abe41bb4b9bfe
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonIgnore
	private Users users;
	
	@NotBlank(message = "O campo status não pode ser nulo")
<<<<<<< HEAD
=======
	
>>>>>>> a1411aa58555a5168f32d69d576abe41bb4b9bfe
	private Integer status;
	
	@ManyToOne
	@JoinColumn(nullable = false)
<<<<<<< HEAD
	private Book book;
	
	@NotNull
	private LocalDate loanDate;
		
=======
	@Column(nullable = false)
	private Book book;
	
	
	private LocalDate loanDate;
	
	private LocalDate returnDate;
	
>>>>>>> a1411aa58555a5168f32d69d576abe41bb4b9bfe
	public Loan() {
	}
	
	
<<<<<<< HEAD
	public Loan(Users users, Book book) {
=======
	public Loan(Users users, Book book, LoanStatus status) {
		
>>>>>>> a1411aa58555a5168f32d69d576abe41bb4b9bfe
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

<<<<<<< HEAD
	public LocalDate getLoanDate() {
		return loanDate;
	}
=======

	public LocalDate getLoanDate() {
		return loanDate;
	}


	public LocalDate getReturnDate() {
		return returnDate;
	}
>>>>>>> a1411aa58555a5168f32d69d576abe41bb4b9bfe
	
}
