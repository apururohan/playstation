package com.playstation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.playstation.datatransferobject.UserDTO;
import com.playstation.entity.User;
import com.playstation.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/api/user")
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/api/user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable int userId){
		Optional<User> user = userService.getUser(userId);
		if(user.isEmpty()) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(user.get(),HttpStatus.OK);
		}
	}
	
	@PostMapping("/api/addUser")
	public ResponseEntity<UserDTO> addUser(@RequestBody User user) throws JsonProcessingException{
		return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);
	}
	
	@PutMapping("/api/user/{userId}")
	public ResponseEntity<UserDTO> editUser(@PathVariable int userId, @RequestBody User user) throws JsonProcessingException{
		Optional<User>	originalUser = userService.getUser(userId);
		if(originalUser.isEmpty()) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND); 
		}
		else {
			if(user.getFirstName()!=null)		originalUser.get().setFirstName(user.getFirstName());
			if(user.getLastName()!=null)		originalUser.get().setLastName(user.getLastName());
			if(user.getDateOfJoining()!=null)	originalUser.get().setDateOfJoining(user.getDateOfJoining());
			if(user.getEmailId()!=null)			originalUser.get().setEmailId(user.getEmailId());
			if(user.getNickName()!=null)		originalUser.get().setNickName(user.getNickName());
			if(user.getPlayStationId()!=null)	originalUser.get().setPlayStationId(user.getPlayStationId());
			return new ResponseEntity<>(userService.addUser(originalUser.get()),HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/api/user/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable int userId){
		Optional<User>	originalUser = userService.getUser(userId);
		if(originalUser.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			userService.deleteUser(userId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@GetMapping("/api/username/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username){
		Optional<User> user = userService.getUserByUsername(username);
		if(user.isEmpty()) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<User>(user.get(),HttpStatus.OK);
		}
	}
}
