package com.marcos.biblioteca.project.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.biblioteca.project.model.Author;
import com.marcos.biblioteca.project.model.Book;
import com.marcos.biblioteca.project.model.Category;
import com.marcos.biblioteca.project.model.Publisher;
import com.marcos.biblioteca.project.repositories.AuthorRepository;
import com.marcos.biblioteca.project.repositories.BookRepository;
import com.marcos.biblioteca.project.repositories.CategoryRepository;
import com.marcos.biblioteca.project.repositories.PublisherRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookrepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	public List<Book> findAll(){
		return bookrepository.findAll();
	}
	
	public Book findById(Long id) {
		Optional<Book> obj = bookrepository.findById(id);
		return obj.get();
	}
	
	public Book insert(Book obj) {

	
	    Author author = authorRepository.findById(obj.getAuthor().getId())
	            .orElseThrow(() -> new RuntimeException("Author not found"));
	    
	    Publisher publisher = publisherRepository.findById(obj.getPublisher().getId())
	            .orElseThrow(() -> new RuntimeException("Publisher not found"));

	    obj.setAuthor(author);
	    obj.setPublisher(publisher);

	   //Save the Book first, without categories
	    Book savedBook = bookrepository.save(obj);

	    if (obj.getCategory() != null) {
	        Set<Category> persistentCategories = obj.getCategory().stream()
	                .map(cat -> categoryRepository.findById(cat.getId())
	                        .orElseThrow(() -> new RuntimeException("Category not found")))
	                .collect(Collectors.toSet());

	        savedBook.getCategory().addAll(persistentCategories);
	    }

	    return bookrepository.save(savedBook);
	}
}
