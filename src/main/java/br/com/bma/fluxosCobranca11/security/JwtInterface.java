package br.com.bma.fluxosCobranca11.security;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public interface JwtInterface {

	String getSecret();

	Long getExpiration();

	default String generateToken(String login) {
		return Jwts.builder().setSubject(login).setExpiration(new Date(System.currentTimeMillis() + getExpiration()))
				.signWith(SignatureAlgorithm.HS512, getSecret().getBytes()).compact();
	}

	default boolean tokenValido(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if (username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}
		return false;
	}

	default Date getExpirationDate(String token) {
		try {
			Claims claims = getClaims(token);
			Date expirationDate = claims.getExpiration();
			return expirationDate;
		} catch (Exception e) {
			return null;
		}
	}

	default String getUsername(String token) {
		Claims claims = getClaims(token);
		if (claims != null)
			return claims.getSubject();

		return null;
	}

	default Claims getClaims(String token) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(getSecret().getBytes()).parseClaimsJws(token);
			return (claims != null) ? claims.getBody() : null;
		} catch (Exception e) {
			return null;
		}
	}

}
