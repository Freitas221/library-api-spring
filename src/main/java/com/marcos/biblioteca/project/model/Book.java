package com.marcos.biblioteca.project.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_book")
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private LocalDate publication;
	private Author autor;
	private Publisher editora;
	private Category categorias;
	
	public Book() {
	}

	public Book(Long id, String titulo, LocalDate publication, Author autor, Publisher editora, Category categorias) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.publication = publication;
		this.autor = autor;
		this.editora = editora;
		this.categorias = categorias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getPublication() {
		return publication;
	}

	public void setPublication(LocalDate publication) {
		this.publication = publication;
	}

	public Author getAutor() {
		return autor;
	}

	public void setAutor(Author autor) {
		this.autor = autor;
	}

	public Publisher getEditora() {
		return editora;
	}

	public void setEditora(Publisher editora) {
		this.editora = editora;
	}

	public Category getCategorias() {
		return categorias;
	}

	public void setCategorias(Category categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
