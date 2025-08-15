package com.playstation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.playstation.datatransferobject.FriendRequestDTO;
import com.playstation.entity.Friend;
import com.playstation.service.FriendRequestService;

@Controller
public class FriendRequestController {
	
	@Autowired
	FriendRequestService friendRequestService;
	
	@PostMapping("/api/friendRequest")
	public ResponseEntity<Friend> sendFriendRequest(@RequestBody FriendRequestDTO friendRequestDTO) {
		return friendRequestService.sendFriendRequest(friendRequestDTO);
	}
	
	@PutMapping("/api/friendRequest")
	public ResponseEntity<Friend> updateFriendRequest(@RequestBody FriendRequestDTO friendRequestDTO){
		return friendRequestService.updateFriendRequest(friendRequestDTO);
	}
	
	@GetMapping("/api/friendRequestsRecieved/{userId}")
	public ResponseEntity<List<Friend>> getFriendRequestsReceived(@PathVariable int userId){
		return friendRequestService.getFriendRequestsReceived(userId);
	}
	
	@GetMapping("/api/friendRequestsSent/{userId}")
	public ResponseEntity<List<Friend>> getFriendRequestsSent(@PathVariable int userId){
		return friendRequestService.getFriendRequestsSent(userId);
	}
}
