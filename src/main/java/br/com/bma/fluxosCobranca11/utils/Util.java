package br.com.bma.fluxosCobranca11.utils;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class Util implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String AUTH_HEADER_NAME = "Authorization";
	private static final String BEARER_NAME_WITH_SPACE = "Bearer ";
	private static final String LOGIN_HEADER_NAME = "LoginUserLogged";

	public static String getAuthorizationHeader(HttpServletRequest req) {
		return req.getHeader(AUTH_HEADER_NAME);
	}

	public static String getLoginUserLoggedInHeader(HttpServletRequest req) {
		return req.getHeader(LOGIN_HEADER_NAME);
	}

	// Recebe o HttpServletRequest e pega o Header Authorization (se existir)
	public static boolean headerContainsBearer(HttpServletRequest req) {
		String authorizationHeader = getAuthorizationHeader(req);

		// Verifica se esta diferente de null e se comeca com Bearer
		if (authorizationHeader != null && authorizationHeader.startsWith(BEARER_NAME_WITH_SPACE)) {
			return true;
		}

		return false;
	}

	// Recebe o HttpServletRequest e pega o Header Authorization (se existir)
	public static String getTokenFromHeader(HttpServletRequest req) {
		boolean headerContainsBearer = headerContainsBearer(req);

		if (headerContainsBearer) {
			String authorizationHeader = getAuthorizationHeader(req);
			String token = authorizationHeader.substring(BEARER_NAME_WITH_SPACE.length());
			return token;
		}

		return null;
	}

	public static String getLoginFromHeader(HttpServletRequest req) {
		boolean headerContainsLogin = headerContainsUserLoggedIn(req);
		if (headerContainsLogin) 
			return getLoginUserLoggedInHeader(req);
		
		return null;
	}

	public static boolean headerContainsUserLoggedIn(HttpServletRequest req) {
		String userLoggedInHeader = getLoginUserLoggedInHeader(req);
		if (userLoggedInHeader != null)
			return true;

		return false;
	}
}
