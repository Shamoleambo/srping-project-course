package com.tiagolearnspring.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagolearnspring.course.entities.User;
import com.tiagolearnspring.course.repositories.UserRepository;

@Service
public class UsersServices {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		return repository.findById(id).get();
	}
	
	public User insert (User obj) {
		return repository.save(obj);
	}
}
