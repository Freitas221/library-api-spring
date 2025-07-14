package com.marcos.biblioteca.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marcos.biblioteca.project.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
