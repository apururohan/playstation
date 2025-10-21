package com.playstation.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String firstName;
	private String lastName;
	private String playStationId;
	private String emailId;
	private String nickName;
	private Date dateOfJoining;
	private String password;
	@Column(nullable=false,unique=true)
	private String username;
	public User() {
		super();
		this.dateOfJoining = new Date();
	}
	public User(int userId, String firstName, String lastName, String playStationId, String emailId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.playStationId = playStationId;
		this.emailId = emailId;
		this.dateOfJoining = new Date();
	}
	public User(int userId, String firstName, String lastName, String playStationId, String emailId,String nickName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.playStationId = playStationId;
		this.emailId = emailId;
		this.nickName = nickName;
		this.dateOfJoining = new Date();
	}
	public User(int userId, String firstName, String lastName, String playStationId, String emailId, String nickName,
			Date dateOfJoining, String password,String username) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.playStationId = playStationId;
		this.emailId = emailId;
		this.nickName = nickName;
		this.dateOfJoining = dateOfJoining;
		this.password = password;
		this.username = username;
	}
	public User(String password, String username) {
		super();
		this.password = password;
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
	public String getPlayStationId() {
		return playStationId;
	}
	public void setPlayStationId(String playStationId) {
		this.playStationId = playStationId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", playStationId=" + playStationId + ", emailId=" + emailId + ", nickName=" + nickName
				+ ", dateOfJoining=" + dateOfJoining + "]";
	}
	
}
