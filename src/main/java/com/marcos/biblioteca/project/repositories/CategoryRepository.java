package com.marcos.biblioteca.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.biblioteca.project.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
