package com.playstation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.playstation.datatransferobject.GameRequestDTO;
import com.playstation.entity.Game;
import com.playstation.service.GameService;

@Controller
public class GameController {
	
	@Autowired
	GameService gameService;
	
	@PostMapping("/api/game")
	public ResponseEntity<Game> addGame(@RequestBody GameRequestDTO dto) {
		Game game = gameService.addGame(dto);
		if(game==null) {
			return ResponseEntity.badRequest().build();
		}
		else {
			return new ResponseEntity<>(game,HttpStatus.OK);
		}
	}
	
	@GetMapping("/api/game")
	public ResponseEntity<List<Game>> getGames(){
		return new ResponseEntity<>(gameService.getGames(),HttpStatus.OK);
	}
	
	@GetMapping("api/game/{gameId}")
	public ResponseEntity<Game>	getGame(@PathVariable int gameId){
		Game game = gameService.getGame(gameId);
		if(game==null) {
			return ResponseEntity.badRequest().build();
		}
		else {
			return new ResponseEntity<>(game,HttpStatus.OK);
		}
	}
	
	@PutMapping("api/game/{gameId}")
	public ResponseEntity<Game>	updateGame(@PathVariable int gameId,@RequestBody GameRequestDTO gameDTO){
		Game game = gameService.updateGame(gameId,gameDTO);
		if(game==null) {
			return ResponseEntity.badRequest().build();
		}
		else {
			return new ResponseEntity<>(game,HttpStatus.OK);
		}
	}
	
	@DeleteMapping("api/game/{gameId}")
	public ResponseEntity<Void>	deleteGame(@PathVariable int gameId){
		return gameService.deleteGame(gameId);
	}
}
