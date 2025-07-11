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
	private User senderId;
	
	@ManyToOne
	@MapsId("receiverId")
	@JoinColumn(name="receiver_id")
	private User receiverId;
	
	@Enumerated(EnumType.STRING)
	private RequestStatus status;
	
	private LocalDateTime requestedAt;

	public Friend() {
		super();
	}

	public Friend(FriendRequestId friendRequestId, User senderId, User receiverId) {
		super();
		this.friendRequestId = friendRequestId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.status = RequestStatus.AWAITING;
		this.requestedAt = LocalDateTime.now();
	}


	public FriendRequestId getFriendRequestId() {
		return friendRequestId;
	}

	public void setFriendRequestId(FriendRequestId friendRequestId) {
		this.friendRequestId = friendRequestId;
	}

	public User getSenderId() {
		return senderId;
	}

	public void setSenderId(User senderId) {
		this.senderId = senderId;
	}

	public User getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(User receiverId) {
		this.receiverId = receiverId;
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
		return "Friend [friendRequestId=" + friendRequestId + ", senderId=" + senderId + ", receiverId=" + receiverId
				+ ", status=" + status + ", requestedAt=" + requestedAt + "]";
	}
	
}
