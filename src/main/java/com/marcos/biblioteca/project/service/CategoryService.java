package com.marcos.biblioteca.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.freitas.course.repositories.CategoryRepository;

public class CategoryService {

	@Autowired
	private CategoryRepository repository;
}
