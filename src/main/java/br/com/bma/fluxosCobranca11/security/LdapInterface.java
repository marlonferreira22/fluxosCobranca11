package br.com.bma.fluxosCobranca11.security;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.bma.fluxosCobranca11.model.dto.UsuarioSessao;

public interface LdapInterface {

	static final String AUTENTICAR_USUARIO = "/autenticarUsuario";
	static final String FIND_BY_ID = "/findById/";
	//static final String APP = "SFC";

	String getLdapUrl();
	
	String getHostSCA();

	default UsuarioSessao authenticate(String user, String credential) {
		try {
			if (user != null && credential != null) {
				RestTemplate restTemplate = new RestTemplate();

				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

				  HttpEntity<MultiValueMap<String, String>> request =
				  retornaRequestComParametros(headers, user, credential);
				 
				  String urlCompleta = getLdapUrl() + AUTENTICAR_USUARIO;
				  ResponseEntity<UsuarioSessao> response =
				  restTemplate.postForEntity(urlCompleta, request, UsuarioSessao.class);
				 
				if (response != null && response.getBody() != null) {
					
					return response.getBody();
				}
					

				return null;
			}
			return null;
		} catch (Exception e) {
			throw e;
		}
	}

	default UsuarioSessao findById(String user) {
		try {
			if (user != null) {
				RestTemplate restTemplate = new RestTemplate();
				String urlCompleta = getLdapUrl() + FIND_BY_ID + user;
				ResponseEntity<UsuarioSessao> response = restTemplate.getForEntity(urlCompleta, UsuarioSessao.class);
				if (response != null && response.getBody() != null)
					return response.getBody();

				return null;
			}
			return null;
		} catch (Exception e) {
			throw e;
		}
	}

	default MultiValueMap<String, String> retornaParametrosLdap(String user, String credential) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("user", user);
		map.add("credential", credential);
		return map;
	}
	
	/*
	 * default MultiValueMap<String, String> retornaParametrosUrlEncoded(String
	 * user) { MultiValueMap<String, String> map = new LinkedMultiValueMap<String,
	 * String>(); map.add("user", user); map.add("app", APP); return map; }
	 */

	default HttpEntity<MultiValueMap<String, String>> retornaRequestComParametros(HttpHeaders headers, String user,
			String credential) {
		MultiValueMap<String, String> map = retornaParametrosLdap(user, credential);
		return new HttpEntity<MultiValueMap<String, String>>(map, headers);
	}
}
