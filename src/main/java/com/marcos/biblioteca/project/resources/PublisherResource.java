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

import com.marcos.biblioteca.project.model.Publisher;
import com.marcos.biblioteca.project.services.PublisherService;

@RestController
@RequestMapping(value = "publishers")
public class PublisherResource {

	@Autowired
	public PublisherService service;
	
	@GetMapping()
	public ResponseEntity<List<Publisher>> findAll() {
		List<Publisher> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Publisher> findById(@PathVariable Long id) {
		Publisher obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Publisher> insert(@RequestBody Publisher publisher) {
		Publisher obj = service.insert(publisher);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Publisher> delete(@PathVariable Long id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Publisher> update(@PathVariable Long id, @RequestBody Publisher entity) {
		entity = service.update(id, entity);
		
		return ResponseEntity.ok().body(entity);
	} 
	
}
