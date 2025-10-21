package com.login.datatransferobject;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;



public class TokenDTO {
	
	private String time;
	private String accessToken;
	private String refreshToken;
	
	public TokenDTO() {
		super();
	}
	public TokenDTO(String accessToken, String refreshToken) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.time = this.getCurrentTime();
	}
	private String getCurrentTime() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);
		return formattedDateTime;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	@Override
	public String toString() {
		return "TokenDTO [time=" + time + ", accessToken=" + accessToken + ", refreshToken=" + refreshToken + "]";
	}
	
}
