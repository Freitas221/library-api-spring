package com.marcos.biblioteca.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.marcos.biblioteca.project.model.Author;
import com.marcos.biblioteca.project.repositories.AuthorRepository;
import com.marcos.biblioteca.project.services.exception.DatabaseException;
import com.marcos.biblioteca.project.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository repository;
	
	public List<Author> findAll(){
		return repository.findAll();
	}
	
	public Author findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", id));
	}
	
	public Author insert(Author obj) {
		return repository.save(obj);
	}
	

	public void delete(Long id) {
		try {
			if(!repository.existsById(id)) {
				throw new ResourceNotFoundException("Author", id, "during the deletion");
			}
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violation of referential integrity.");
		}
	}
	
	public Author update(Long id, Author obj) {
		try {
			Author author = repository.getReferenceById(id);
			updatedAuthor(author, obj);
			
			return repository.save(author);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Author", id);
		}
	}	
	
	public void updatedAuthor(Author author, Author obj) {
		author.setNome(obj.getNome());
		author.setNacionalidade(obj.getNacionalidade());
	}
}
