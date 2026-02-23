package com.marcos.biblioteca.project.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@NoArgsConstructor //Perform commit
@Entity
@Table(name = "tb_book")
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O titulo não pode ser vazio.")
	@Column(nullable = false)
	private String titulo;
	
	@NotNull
	@Column(nullable = false)
	private LocalDate publication;
	
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Author author;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "book_category", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> category = new HashSet<>();
	
	public Book() {
	}

	public Book(Long id, String titulo, LocalDate publication) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.publication = publication;
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
	public Publisher getPublisher() {
		return publisher;
	}
	
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	public Set<Category> getCategory() {
		return category;
	}
	
	public void setCategory(Set<Category> category) {
	    if (category != null) {
	        this.category.clear();
	        this.category.addAll(category);
	    }
	} // does not replace the reference, just adds elements
	
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
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
