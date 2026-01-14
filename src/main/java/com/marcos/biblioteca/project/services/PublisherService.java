package com.marcos.biblioteca.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.biblioteca.project.model.Publisher;
import com.marcos.biblioteca.project.repositories.PublisherRepository;
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
}
