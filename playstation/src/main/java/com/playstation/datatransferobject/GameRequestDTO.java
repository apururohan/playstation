package com.playstation.datatransferobject;

public class GameRequestDTO {
	
	private String gameName;
	private int noOfPlayers;
	private boolean onlinePlay;
	private boolean display;
	private int userId;
	public GameRequestDTO() {
		super();
	}
	public GameRequestDTO(String gameName, int noOfPlayers, boolean onlinePlay, boolean display, int userId) {
		super();
		this.gameName = gameName;
		this.noOfPlayers = noOfPlayers;
		this.onlinePlay = onlinePlay;
		this.display = display;
		this.userId = userId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public Integer getNoOfPlayers() {
		return noOfPlayers;
	}
	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}
	public Boolean isOnlinePlay() {
		return onlinePlay;
	}
	public void setOnlinePlay(boolean onlinePlay) {
		this.onlinePlay = onlinePlay;
	}
	public Boolean isDisplay() {
		return display;
	}
	public void setDisplay(boolean display) {
		this.display = display;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "GameRequestDTO [gameName=" + gameName + ", noOfPlayers=" + noOfPlayers + ", onlinePlay=" + onlinePlay
				+ ", display=" + display + ", userId=" + userId + "]";
	}
	
}
