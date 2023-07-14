package br.com.bma.fluxosCobranca11.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class FluxosCobrancaAuthorizationFilter extends AuthorizationFilter {

	private UserDetailsService userDetailsService;

	public FluxosCobrancaAuthorizationFilter(AuthenticationManager authenticationManager, JwtInterface jwtUtil,
			UserDetailsService userDetailsService) {
		super(authenticationManager, jwtUtil, null, null);
		this.userDetailsService = userDetailsService;
	}

	@Override
	public UsernamePasswordAuthenticationToken getAutheticationFromJwt(String token) {
		JwtInterface jwtUtil = getJwtUtil();
		if (jwtUtil.tokenValido(token)) {
			String username = jwtUtil.getUsername(token);
			UserDetails user = userDetailsService.loadUserByUsername(username);
			return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		}
		return null;
	}
}
