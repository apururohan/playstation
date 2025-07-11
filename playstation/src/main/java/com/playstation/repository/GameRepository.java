package com.playstation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playstation.entity.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
