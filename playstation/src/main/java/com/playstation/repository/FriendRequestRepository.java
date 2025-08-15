package com.playstation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.playstation.entity.Friend;
import com.playstation.entity.FriendRequestId;


public interface FriendRequestRepository extends JpaRepository<Friend, FriendRequestId>{
	
	 @Query("SELECT f FROM Friend f WHERE f.sender.id = :userId")
	 List<Friend> friendRequestsSent(@Param("userId") int userId);

	  @Query("SELECT f FROM Friend f WHERE f.receiver.id = :userId")
	  List<Friend> friendRequestsReceived(@Param("userId") int userId);

	  @Query("SELECT f FROM Friend f WHERE (f.sender.id = :senderId AND f.receiver.id = :receiverId) OR (f.sender.id = :receiverId AND f.receiver.id = :senderId)")
	  Friend findByBothIds(@Param("senderId") int senderId, @Param("receiverId") int receiverId);

	  // Optional: To find any relation (sent or received)
	  @Query("SELECT f FROM Friend f WHERE f.sender.id = :userId OR f.receiver.id = :userId")
	  List<Friend> findAllFriendRequestsOfUser(@Param("userId") int userId);
}
