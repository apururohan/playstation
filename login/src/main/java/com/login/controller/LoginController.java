package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.datatransferobject.LoginDTO;
import com.login.datatransferobject.TokenDTO;
import com.login.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO){
		return loginService.login(loginDTO);
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<TokenDTO> refreshtoken(@RequestBody TokenDTO tokenDTO){
		return loginService.refreshToken(tokenDTO);
	}
}
