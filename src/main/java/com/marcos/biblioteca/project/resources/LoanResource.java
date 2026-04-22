package com.marcos.biblioteca.project.resources;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

	
	private LoanService service; 
	
	@PostMapping
	public ResponseEntity<Loan> createLoan(@Valid @RequestBody Loan obj) {
		service.createLoan(obj);
		
		URI uri  = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{/id}")
				.buildAndExpand(obj.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
}
