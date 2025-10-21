package com.playstation.datatransferobject;

public class UserDTO {
	private String firstName;
	private String lastName;
	private String username;
	private String emailId;
	private int userId;
	public UserDTO() {
		super();
	}
	public UserDTO(String firstName, String lastName, String username, String emailId, int userId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.emailId = emailId;
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", emailId="
				+ emailId + ", userId=" + userId + "]";
	}
	
}
