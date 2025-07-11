package com.playstation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int gameId;
	private String gameName;
	private int noOfPlayers;
	private boolean onlinePlay;
	private boolean display;
	
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName="userId")
	private User userId;

	public Game() {
		super();
	}

	
	public Game(int gameId, String gameName, int noOfPlayers, boolean onlinePlay, boolean display, User userId) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.noOfPlayers = noOfPlayers;
		this.onlinePlay = onlinePlay;
		this.display = display;
		this.userId = userId;
	}

	
	public Game(int gameId, String gameName, User userId) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.userId = userId;
		this.display = true;
	}


	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public boolean isOnlinePlay() {
		return onlinePlay;
	}

	public void setOnlinePlay(boolean onlinePlay) {
		this.onlinePlay = onlinePlay;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
	
}
