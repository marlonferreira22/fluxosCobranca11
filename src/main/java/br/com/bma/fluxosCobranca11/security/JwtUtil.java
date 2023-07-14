package br.com.bma.fluxosCobranca11.security;

import org.springframework.beans.factory.annotation.Value;

public class JwtUtil implements JwtInterface{

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;
	
	@Override
	public String getSecret() {
		return secret;
	}

	@Override
	public Long getExpiration() {
		return expiration;
	}
}
