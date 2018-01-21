package com.coderkysu.springboot.hsqlexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderkysu.springboot.hsqlexample.model.User;
import com.coderkysu.springboot.hsqlexample.repository.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) {
		userRepository.save(user);
	}
}
