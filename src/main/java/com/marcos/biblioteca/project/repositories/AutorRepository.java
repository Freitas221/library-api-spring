package com.marcos.biblioteca.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marcos.biblioteca.project.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
