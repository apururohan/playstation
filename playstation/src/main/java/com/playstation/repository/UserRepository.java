package com.playstation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playstation.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
}
