package com.login.service;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {
	private final String secret = "xw9u0H7+zE4Jp1Rk2Vf6tD8sL3oQy5Uj7Zc9mN4aX6rB1wG8kT2yF5pH3vJ0lO2dR4fU6sX8yZ0cQ2nT5rV7mP9aB1dF3hJxw9u0H7+zE4Jp1Rk2Vf6tD8sL3oQy5Uj7Zc9mN4aX6rB1wG8kT2yF5pH3vJ0lO2dR4fU6sX8yZ0cQ2nT5rV7mP9aB1dF3hJ";
	private final long accessTokenValidity = 1000 * 60 * 15;
	private final long refreshTokenValidity = 1000L * 60 * 60 * 24 * 7;
	
	public String generateAccessToken(String username) {
		return Jwts.builder()
					.setSubject(username)
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis()+accessTokenValidity))
					.signWith(SignatureAlgorithm.HS512,secret)
					.compact();
	}
	
	public String generateRefreshToken(String username) {
		return Jwts.builder()
					.setSubject(username)
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + refreshTokenValidity))
					.signWith(SignatureAlgorithm.HS512,secret)
					.compact();
	}
	
	public String extractUsername(String token) {
	        Claims claims = Jwts.parser()
	                .setSigningKey(secret)
	                .parseClaimsJws(token)
	                .getBody();
	        return claims.getSubject();
	}
}
