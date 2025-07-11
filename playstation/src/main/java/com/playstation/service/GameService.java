package com.playstation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playstation.entity.Game;
import com.playstation.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	GameRepository gameRepository;
	public Game addGame(Game game) {
		return gameRepository.save(game);
	}
}
