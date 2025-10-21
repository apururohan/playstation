package com.playstation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.playstation.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playstation.datatransferobject.UserDTO;
import com.playstation.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	private static final String TOPIC = "user-register";
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public String hashPassword(String rawPassword) {
		return encoder.encode(rawPassword);
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}

	public Optional<User> getUser(int userId) {
		return userRepository.findById(userId);
	}

	public UserDTO addUser(User user) throws JsonProcessingException {
		user.setPassword(this.hashPassword(user.getPassword()));
//		User newUser = userRepository.save(user);
		User newUser = user;
		UserDTO eventObject = new UserDTO(newUser.getFirstName(),newUser.getLastName(),newUser.getUsername(),newUser.getEmailId(),newUser.getUserId());
//		ObjectMapper mapper = new ObjectMapper();
//		String userJson = mapper.writeValueAsString(eventObject);
		kafkaTemplate.send(TOPIC,eventObject);
		return eventObject;
	}

	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}
	
	public Optional<User> getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}
	
}
