package com.marcos.biblioteca.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.biblioteca.project.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

}
