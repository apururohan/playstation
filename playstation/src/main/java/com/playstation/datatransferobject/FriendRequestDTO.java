package com.playstation.datatransferobject;

import com.playstation.enums.RequestStatus;

public class FriendRequestDTO {
	
	private int senderUserId;
	private int receiverUserId;
	private RequestStatus status;
	public FriendRequestDTO() {
		super();
	}
	public FriendRequestDTO(int senderUserId, int receiverUserId, RequestStatus status) {
		super();
		this.senderUserId = senderUserId;
		this.receiverUserId = receiverUserId;
		this.status = status;
	}
	public int getSenderUserId() {
		return senderUserId;
	}
	public void setSenderUserId(int senderUserId) {
		this.senderUserId = senderUserId;
	}
	public int getReceiverUserId() {
		return receiverUserId;
	}
	public void setReceiverUserId(int receiverUserId) {
		this.receiverUserId = receiverUserId;
	}
	public RequestStatus getStatus() {
		return status;
	}
	public void setStatus(RequestStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "FriendRequestDTO [senderUserId=" + senderUserId + ", receiverUserId=" + receiverUserId + ", status="
				+ status + "]";
	}
	
	
}
