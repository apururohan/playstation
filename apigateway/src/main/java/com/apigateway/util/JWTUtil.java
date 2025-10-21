package com.apigateway.util;

import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {
	private final String secret = "xw9u0H7+zE4Jp1Rk2Vf6tD8sL3oQy5Uj7Zc9mN4aX6rB1wG8kT2yF5pH3vJ0lO2dR4fU6sX8yZ0cQ2nT5rV7mP9aB1dF3hJxw9u0H7+zE4Jp1Rk2Vf6tD8sL3oQy5Uj7Zc9mN4aX6rB1wG8kT2yF5pH3vJ0lO2dR4fU6sX8yZ0cQ2nT5rV7mP9aB1dF3hJ";
	
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder()
				.setSigningKey(secret)
				.build()
				.parseClaimsJws(token);
			return true;
		}
		catch(Exception e) {
			System.out.println("Invalid JWT : "+e.getMessage());
			return false;
		}
	}
	
	public String extractUsername(String token) {
		return Jwts.parserBuilder()
					.setSigningKey(secret)
					.build()
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
	}
	
}
