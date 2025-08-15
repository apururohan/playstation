package com.playstation.service;

import java.util.Optional;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.playstation.datatransferobject.FriendRequestDTO;
import com.playstation.entity.Friend;
import com.playstation.entity.FriendRequestId;
import com.playstation.entity.User;
import com.playstation.enums.RequestStatus;
import com.playstation.repository.FriendRequestRepository;

@Service
public class FriendRequestService {

	@Autowired
	UserService userService;
	@Autowired
	FriendRequestRepository	friendRequestRepository;
	public ResponseEntity<Friend> sendFriendRequest(FriendRequestDTO friendRequestDTO) {
		Optional<User> sender = userService.getUser(friendRequestDTO.getSenderUserId());
		Optional<User> receiver = userService.getUser(friendRequestDTO.getReceiverUserId());
		if(sender.isEmpty() || receiver.isEmpty())
			return ResponseEntity.badRequest().build();
		FriendRequestId friendRequestId = new FriendRequestId(friendRequestDTO.getSenderUserId(),friendRequestDTO.getReceiverUserId());
		Friend friend = new Friend();
		friend.setSender(sender.get());
		friend.setReceiver(receiver.get());
		friend.setStatus(friendRequestDTO.getStatus());
		friend.setFriendRequestId(friendRequestId);
		friend.setRequestedAt(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		return new ResponseEntity<>(friendRequestRepository.save(friend),HttpStatus.OK);
	}
	public ResponseEntity<Friend> updateFriendRequest(FriendRequestDTO friendRequestDTO) {
		Optional<User>	sender = userService.getUser(friendRequestDTO.getSenderUserId());
		Optional<User>	receiver = userService.getUser(friendRequestDTO.getReceiverUserId());
		if(sender.isEmpty() || receiver.isEmpty())
			return ResponseEntity.badRequest().build();
		Friend friend = getFriendRequest(friendRequestDTO.getSenderUserId(),friendRequestDTO.getReceiverUserId());
		friend.setStatus(friendRequestDTO.getStatus());
		friend = friendRequestRepository.save(friend);
		return new ResponseEntity<>(friend,HttpStatus.OK);
	}
	public ResponseEntity<List<Friend>> getFriendRequestsSent(int userId){
		Optional<User>	user = userService.getUser(userId);
		if(user.isEmpty())
			return ResponseEntity.badRequest().build();
		return new ResponseEntity<>(friendRequestRepository.friendRequestsSent(userId),HttpStatus.OK);
	}
	public ResponseEntity<List<Friend>> getFriendRequestsReceived(int userId){
		Optional<User>	user = userService.getUser(userId);
		if(user.isEmpty())
			return ResponseEntity.badRequest().build();
		return new ResponseEntity<>(friendRequestRepository.friendRequestsReceived(userId),HttpStatus.OK);
	}
	public Friend getFriendRequest(int senderId,int receiverId){
		return friendRequestRepository.findByBothIds(senderId,receiverId);
	}
}
