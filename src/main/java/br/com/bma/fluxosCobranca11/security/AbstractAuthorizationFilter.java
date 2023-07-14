package br.com.bma.fluxosCobranca11.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AbstractAuthorizationFilter {

	UsernamePasswordAuthenticationToken getAutheticationFromJwt(String token);
}
