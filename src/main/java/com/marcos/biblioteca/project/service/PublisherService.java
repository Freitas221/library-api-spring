package com.marcos.biblioteca.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.marcos.biblioteca.project.model.Publisher;
import com.marcos.biblioteca.project.repositories.PublisherRepository;

@Service
public class PublisherService {

	private PublisherRepository repository;
	
	public List<Publisher> findAll() {
		return repository.findAll();
	}
	
	public Publisher findById(Long id) {
		Optional<Publisher> obj = repository.findById(id);
		return obj.get();
	}
}
