package com.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.client.UserClient;
import com.login.datatransferobject.LoginDTO;
import com.login.datatransferobject.TokenDTO;

@Service
public class LoginService {
	
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	@Autowired
	private UserClient userClient;
	@Autowired
	private JWTUtil jwtUtil;
	public ResponseEntity<TokenDTO> login(LoginDTO loginDTO){
		if(isLoginSuccesful(loginDTO.getUsername(),loginDTO.getPassword())) {
			return new ResponseEntity<TokenDTO>(this.generateToken(loginDTO.getUsername()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
		}
	}

	private TokenDTO generateToken(String username) {
		TokenDTO tokenDTO = new TokenDTO();
		tokenDTO.setAccessToken(jwtUtil.generateAccessToken(username));
		tokenDTO.setRefreshToken(jwtUtil.generateRefreshToken(username));
		return tokenDTO;
	}
	
	private boolean isLoginSuccesful(String username, String password) {
		String encryptedPassword  =  userClient.getUserByUsername(username).getPassword();
		return encoder.matches(password, encryptedPassword);
	}

	public ResponseEntity<TokenDTO> refreshToken(TokenDTO tokenDTO) {
		String refreshToken = tokenDTO.getRefreshToken();
		String username = jwtUtil.extractUsername(refreshToken);
		
		TokenDTO newTokenDTO = new TokenDTO();
		newTokenDTO.setAccessToken(jwtUtil.generateAccessToken(username));
		newTokenDTO.setRefreshToken(refreshToken);
		return new ResponseEntity<TokenDTO>(newTokenDTO,HttpStatus.OK);
	}
}
