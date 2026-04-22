package com.marcos.biblioteca.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.biblioteca.project.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
