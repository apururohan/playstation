package com.playstation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.playstation.datatransferobject.GameRequestDTO;
import com.playstation.entity.Game;
import com.playstation.entity.User;
import com.playstation.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	GameRepository gameRepository;
	@Autowired
	UserService userService;
	public Game addGame(GameRequestDTO dto) {
		Optional<User> userOptional = userService.getUser(dto.getUserId());
		if(userOptional.isEmpty())
			return null;
		Game game = new Game();
		game.setUser(userOptional.get());
		game.setGameName(dto.getGameName());
		game.setNoOfPlayers(dto.getNoOfPlayers());
		game.setDisplay(dto.isDisplay());
		game.setOnlinePlay(dto.isOnlinePlay());
		return gameRepository.save(game);
	}
	
	public List<Game> getGames() {
		return gameRepository.findAll();
	}
	
	public Game getGame(int gameId) {
		Optional<Game> optionalGame = gameRepository.findById(gameId);
		if(optionalGame.isEmpty())
			return null;
		else
			return optionalGame.get();
	}
	
	public Game updateGame(int gameId,GameRequestDTO gameDTO) {
		Optional<Game> optionalGame = gameRepository.findById(gameId);
		if(optionalGame.isEmpty())
			return null;
		if(gameDTO.getGameName()!=null)	optionalGame.get().setGameName(gameDTO.getGameName());
		if(gameDTO.isDisplay()!=null)	optionalGame.get().setDisplay(gameDTO.isDisplay());
		if(gameDTO.isOnlinePlay()!=null)	optionalGame.get().setOnlinePlay(gameDTO.isOnlinePlay());
		if(gameDTO.getNoOfPlayers()!=null)	optionalGame.get().setNoOfPlayers(gameDTO.getNoOfPlayers());
		return gameRepository.save(optionalGame.get());
	}
	
	public ResponseEntity<Void>	deleteGame(int gameId){
		Optional<Game> optionalGame = gameRepository.findById(gameId);
		if(optionalGame.isEmpty())
			return ResponseEntity.badRequest().build();
		else {
			gameRepository.deleteById(gameId);
			return ResponseEntity.ok().build();
		}
	}
}
