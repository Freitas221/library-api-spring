package com.marcos.biblioteca.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.biblioteca.project.model.Author;
import com.marcos.biblioteca.project.repositories.AuthorRepository;

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
}
