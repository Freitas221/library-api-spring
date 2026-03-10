package com.marcos.biblioteca.project.model;

public class Users {
	
	//Perform commit
	private String name;
	private String cpf;
	private String number;
	private String phone;
	private Integer idade;
	
	public Users() {
	}
	
	public Users(String name, String cpf, String number, String phone, Integer idade) {
		
		this.name = name;
		this.cpf = cpf;
		this.number = number;
		this.phone = phone;
		this.idade = idade;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	
}
