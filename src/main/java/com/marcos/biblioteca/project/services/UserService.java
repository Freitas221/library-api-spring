package com.marcos.biblioteca.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.biblioteca.project.model.User;
import com.marcos.biblioteca.project.repositories.UserRepository;
import com.marcos.biblioteca.project.services.exception.IllegalStateException;

@Service
public class UserService {
	
	@Autowired
	private	UserRepository userRepository;
	
	public User userRegister(User obj) {
		if(userRepository.existsByCpf(obj.getCpf())) {
			throw new IllegalStateException();
		}
		
		return userRepository.save(obj);
	}
}
