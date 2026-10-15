package com.marcos.biblioteca.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.biblioteca.project.model.User;
import com.marcos.biblioteca.project.repositories.UserRepository;
import com.marcos.biblioteca.project.services.exception.DuplicateCpfException;
import com.marcos.biblioteca.project.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private	UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User userRegister(User obj) {
		if(userRepository.existsByCpf(obj.getCpf())) {
			throw new DuplicateCpfException(obj.getCpf());
		}
		
		return userRepository.save(obj);
	}
	
	public User findById(Long id) {
		User obj = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", id));
		
		return obj;
	}
	
	public User findUpdate(Long obj, User user) {
		try {
			User entity = userRepository.getReferenceById(obj);
			updateData(entity, user);
			
			return userRepository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("User", user);
		}
	}
	
	public void updateData(User entity, User user) {
		entity.setCpf(user.getCpf());
		entity.setIdade(user.getIdade());
		entity.setName(user.getName());
		entity.setPhone(user.getPhone());
	}
}
