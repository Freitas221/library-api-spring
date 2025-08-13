package com.marcos.biblioteca.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcos.biblioteca.project.model.Author;
import com.marcos.biblioteca.project.model.Publisher;
import com.marcos.biblioteca.project.repositories.AuthorRepository;
import com.marcos.biblioteca.project.repositories.PublisherRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private PublisherRepository publisherRepository; 
	
	@Override
	public void run(String... args) throws Exception {
		
		Author author1 = new Author(null, "Carlos Drummond", "Brasileiro");
		Author author2 = new Author(null, "William Shakespeare", "Inglês");
		Author author3 = new Author(null, "Victor Hugo", "Francês");
		Author author4 = new Author(null, "Clarice Lispector", "Brasileira");
		
		authorRepository.saveAll(Arrays.asList(author1, author2, author3, author4));
		
		
		Publisher publisher1 = new Publisher(null, "Editorial Record");
		Publisher publisher2 = new Publisher(null, "Penguin-Companhia");
		Publisher publisher3 = new Publisher(null, "Martin Claret");
		Publisher publisher4 = new Publisher(null, "Rocco Digital");
		
		publisherRepository.saveAll(Arrays.asList(publisher1, publisher2, publisher3, publisher4));
	}

}
