package com.marcos.biblioteca.project.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcos.biblioteca.project.model.Loan;
import com.marcos.biblioteca.project.services.LoanService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/loans")
public class LoanResource {

	@Autowired
	private LoanService service; 
	
	@GetMapping
	public ResponseEntity<List<Loan>> findAll() {
		List<Loan> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Loan> createLoan(@Valid @RequestBody Loan obj) {
		obj = service.createLoan(obj);
		
		URI uri  = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{/id}")
				.buildAndExpand(obj.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}/return")
	public ResponseEntity<Void> updateLoan(@PathVariable Long id) {
		service.loanReturned(id);
		return ResponseEntity.noContent().build();
	}
}
