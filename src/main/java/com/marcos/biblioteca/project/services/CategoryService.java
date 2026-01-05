package com.marcos.biblioteca.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.marcos.biblioteca.project.model.Category;
import com.marcos.biblioteca.project.repositories.CategoryRepository;
import com.marcos.biblioteca.project.services.exception.DatabaseException;
import com.marcos.biblioteca.project.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

	public Category insert(Category obj) {
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
	} //commit 1
	
}










