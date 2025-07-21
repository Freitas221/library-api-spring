package com.marcos.biblioteca.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.marcos.biblioteca.project.repositories.PublisherRepository;

public class PublisherService {
	
	@Autowired
	private PublisherRepository repository;
}
