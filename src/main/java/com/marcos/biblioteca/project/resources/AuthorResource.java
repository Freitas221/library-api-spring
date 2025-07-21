package com.marcos.biblioteca.project.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.biblioteca.project.model.Author;
import com.marcos.biblioteca.project.service.AuthorService;

@RestController
@RequestMapping(value = "/authors")
public class AuthorResource {
	
	public AuthorService service;
	
	@GetMapping
	public ResponseEntity<List<Author>> findAll() {
		List<Author> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping({"/id"})
	public ResponseEntity<Author> findById(@PathVariable Long id) {
		Author obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
