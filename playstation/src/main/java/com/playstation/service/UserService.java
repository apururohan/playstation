package com.playstation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playstation.entity.User;
import com.playstation.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}

	public Optional<User> getUser(int userId) {
		return userRepository.findById(userId);
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}
	
	
}
