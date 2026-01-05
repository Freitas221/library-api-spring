package com.marcos.biblioteca.project.services;

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
import com.marcos.biblioteca.project.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PublisherRepository publisherRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book findById(Long id) {
		Optional<Book> obj = bookRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Book", id));
	}

	@Transactional
	public Book insert(Book obj) {

		Author author = authorRepository.findById(obj.getAuthor().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Author", obj.getAuthor().getId(), "during an insertion"));

		Long publisherId = obj.getPublisher().getId();
		Publisher publisher = publisherRepository.findById(publisherId)
				.orElseThrow(() -> new ResourceNotFoundException("Publisher", publisherId, "during an insertion"));

		obj.setAuthor(author);
		obj.setPublisher(publisher);

		Set<Category> categoriesPersistidas = obj.getCategory().stream().map(cat -> categoryRepository
				.findById(cat.getId()).orElseThrow(() -> new ResourceNotFoundException("Category", cat.getId(), "during an insertion")))
				.collect(Collectors.toSet());

		obj.setCategory(categoriesPersistidas);

		return bookRepository.save(obj);
	}
	
	@Transactional
	public void delete(Long id) {
	    if (!bookRepository.existsById(id)) {
	        throw new ResourceNotFoundException("Book", id, "during the deletion");
	    }
	    
	    bookRepository.deleteById(id);
	}
	
	@Transactional
	public Book update(Long id, Book obj) {
		try {
			Book entity = bookRepository.getReferenceById(id);
			updateData(entity, obj);
			
			return bookRepository.save(entity);	
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Book ", id);
		}
	}
	
	public void updateData(Book entity, Book obj) {
		entity.setTitulo(obj.getTitulo());
		entity.setPublication(obj.getPublication());
	}
}
















