package com.marcos.biblioteca.project.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.biblioteca.project.model.Publisher;
import com.marcos.biblioteca.project.service.PublisherService;

@RestController
@RequestMapping(value = "publishers")
public class PublisherResource {

	public PublisherService service;
	
	public ResponseEntity<List<Publisher>> findAll() {
		List<Publisher> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
