package com.marcos.biblioteca.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.biblioteca.project.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
