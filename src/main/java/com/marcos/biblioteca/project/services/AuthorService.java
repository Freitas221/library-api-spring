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
		Optional<Author> obj = repository.findById(id);
		return obj.get();
	}
	
	public Author insert(Author obj) {
		return repository.save(obj);
	}
	

	public void delete(Long id) {
		try {
			if(!repository.existsById(id)) {
				throw new ResourceNotFoundException(id);
			}
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violation of referential integrity.");
		}
	} //commit - 1
	
	public Author update(Long id, Author obj) {
		try {
			Author author = repository.getReferenceById(id);
			updatedData(author, obj);
			return repository.save(author);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updatedData(Author author, Author obj) {
		author.setNome(obj.getNome());
		author.setNacionalidade(obj.getNacionalidade());
	}//commit - 2
}
