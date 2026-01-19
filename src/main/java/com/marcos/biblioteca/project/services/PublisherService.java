package com.marcos.biblioteca.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.marcos.biblioteca.project.model.Publisher;
import com.marcos.biblioteca.project.repositories.PublisherRepository;
import com.marcos.biblioteca.project.services.exception.DatabaseException;
import com.marcos.biblioteca.project.services.exception.ResourceNotFoundException;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository repository;
	
	public List<Publisher> findAll() {
		return repository.findAll();
	}
	
	public Publisher findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Publisher", id));
	}
	
	public Publisher insert(Publisher obj) {
		return repository.save(obj);
	} 
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);;
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Violation of referential integrity.");
			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Publisher", id, "during the deletion");
		} // Implement this solution in the other classes as well. (Make commits)
	}
}
