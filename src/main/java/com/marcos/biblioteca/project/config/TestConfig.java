package com.marcos.biblioteca.project.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcos.biblioteca.project.model.Author;
import com.marcos.biblioteca.project.model.Book;
import com.marcos.biblioteca.project.model.Category;
import com.marcos.biblioteca.project.model.Publisher;
import com.marcos.biblioteca.project.repositories.AuthorRepository;
import com.marcos.biblioteca.project.repositories.BookRepository;
import com.marcos.biblioteca.project.repositories.CategoryRepository;
import com.marcos.biblioteca.project.repositories.PublisherRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private PublisherRepository publisherRepository; 
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Author author1 = new Author(null, "Carlos Drummond", "Brasileiro");
		Author author2 = new Author(null, "William Shakespeare", "Inglês");
		Author author3 = new Author(null, "Victor Hugo", "Francês");
		Author author4 = new Author(null, "Clarice Lispector", "Brasileira");
		
		authorRepository.saveAll(Arrays.asList(author1, author2, author3, author4));
		
		Category category1 = new Category(null, "Poesia");
		Category category2 = new Category(null, "Romance");
		Category category3 = new Category(null, "Ficção");
		
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		
		Book book1 = new Book(null, "A Rosa do povo",LocalDate.of(1945, 10, 25));
		Book book2 = new Book(null, "Romeu e Julieta",LocalDate.of(1997, 5, 10));
		Book book3 = new Book(null, "O Homem que ri",LocalDate.of(1869, 4, 25));
		Book book4 = new Book(null, "Laços de família",LocalDate.of(1960, 6, 7));
		
		bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4));
				
		Publisher publisher1 = new Publisher(null, "Editorial Record");
		Publisher publisher2 = new Publisher(null, "Penguin-Companhia");
		Publisher publisher3 = new Publisher(null, "Martin Claret");
		Publisher publisher4 = new Publisher(null, "Rocco Digital");
		
		publisherRepository.saveAll(Arrays.asList(publisher1, publisher2, publisher3, publisher4));
		
		book1.getCategory().add(category1);
		book2.getCategory().add(category2);
		book3.getCategory().add(category2);
		book4.getCategory().add(category3);
		
		book1.setPublisher(publisher1);
		book2.setPublisher(publisher2);
		book3.setPublisher(publisher3);
		book4.setPublisher(publisher4);	
		
		book1.setAuthor(author1);
		book2.setAuthor(author2);
		book3.setAuthor(author3);
		book4.setAuthor(author4);
		
		bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4));

	}

}
