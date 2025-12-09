package com.marcos.biblioteca.project.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcos.biblioteca.project.model.Author;
import com.marcos.biblioteca.project.services.AuthorService;

@RestController
@RequestMapping(value = "/authors")
public class AuthorResource {
	
	@Autowired
	private AuthorService service;
	
	@GetMapping
	public ResponseEntity<List<Author>> findAll() {
		List<Author> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Author> findById(@PathVariable Long id) {
		Author obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Author> insert(@RequestBody Author author) {
		Author obj = service.insert(author);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Author> delete(@PathVariable Long id) {
		service.delete(id);	
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody Author author) {
		Author obj = service.update(id, author);
		
		return ResponseEntity.ok().body(obj);
	}
}
