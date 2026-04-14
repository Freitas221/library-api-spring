package com.marcos.biblioteca.project.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome não pode ser nulo")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message = "O cpf não pode ser nulo")
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@NotBlank(message = "O número não pode ser nulo")
	@Column(nullable = false, unique = true)
	private String phone;
	
	@NotNull(message = "A idade não deve ser nula")
	private Integer age;
	
	@OneToMany(mappedBy = "users")
	private List<Loan> loans = new ArrayList<>();
	
	public Users() {
	}
	
	public Users(String name, String cpf, String phone, Integer idade) {
		
		this.name = name;
		this.cpf = cpf;
		this.phone = phone;
		this.age = idade;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getIdade() {
		return age;
	}

	public void setIdade(Integer idade) {
		this.age = idade;
	}
	
	
}
