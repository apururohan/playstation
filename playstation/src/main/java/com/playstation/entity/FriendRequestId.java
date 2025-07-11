package com.playstation.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class FriendRequestId {
	
	private int senderId;
	private int receiverId;
	
	public FriendRequestId() {
		super();
	}
	public FriendRequestId(int senderId, int receiverId) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(receiverId, senderId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendRequestId other = (FriendRequestId) obj;
		return (receiverId == other.receiverId && senderId == other.senderId || receiverId == other.senderId && senderId == other.receiverId);
	}
	
	
	
}
