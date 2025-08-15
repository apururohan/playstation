package com.playstation.entity;

import java.time.LocalDateTime;

import com.playstation.enums.RequestStatus;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Friend {
	
	@EmbeddedId
	private FriendRequestId friendRequestId;
	
	@ManyToOne
	@MapsId("senderId")
	@JoinColumn(name="sender_id")
	private User sender;
	
	@ManyToOne
	@MapsId("receiverId")
	@JoinColumn(name="receiver_id")
	private User receiver;
	
	@Enumerated(EnumType.STRING)
	private RequestStatus status;
	
	private LocalDateTime requestedAt;

	public Friend() {
		super();
	}

	public Friend(FriendRequestId friendRequestId, User senderId, User receiverId) {
		super();
		this.friendRequestId = friendRequestId;
		this.sender = senderId;
		this.receiver = receiverId;
		this.status = RequestStatus.AWAITING;
		this.requestedAt = LocalDateTime.now();
	}


	public FriendRequestId getFriendRequestId() {
		return friendRequestId;
	}

	public void setFriendRequestId(FriendRequestId friendRequestId) {
		this.friendRequestId = friendRequestId;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public LocalDateTime getRequestedAt() {
		return requestedAt;
	}

	public void setRequestedAt(LocalDateTime requestedAt) {
		this.requestedAt = requestedAt;
	}

	@Override
	public String toString() {
		return "Friend [friendRequestId=" + friendRequestId + ", senderId=" + sender + ", receiverId=" + receiver
				+ ", status=" + status + ", requestedAt=" + requestedAt + "]";
	}
	
}
