package com.playstation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.playstation.entity.Game;
import com.playstation.service.GameService;

@Controller
public class GameController {
	
	@Autowired
	GameService gameService;
	
	@PostMapping("/api/game")
	public Game addGame(@RequestBody Game game) {
		return gameService.addGame(game);
	}
	
	
}
