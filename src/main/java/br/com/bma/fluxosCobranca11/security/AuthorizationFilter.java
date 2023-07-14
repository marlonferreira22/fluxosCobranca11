package br.com.bma.fluxosCobranca11.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import br.com.bma.fluxosCobranca11.model.dto.UsuarioSessao;
import br.com.bma.fluxosCobranca11.utils.Util;

public class AuthorizationFilter extends BasicAuthenticationFilter implements AbstractAuthorizationFilter {
	// Metodos utils para o LDAP da CQG
		private LdapInterface ldapUtil;

		// Metodos utils para o JWT (gera um Token, pega o login pelo token, etc.)
		private JwtInterface jwtUtil;

		// Unico Construtor
		public AuthorizationFilter(AuthenticationManager authenticationManager, JwtInterface jwtUtil,
				LdapInterface ldapUtil, String authType) {
			super(authenticationManager);
			this.jwtUtil = jwtUtil;
			this.ldapUtil = ldapUtil;
		}

		@Override
		protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
				throws IOException, ServletException {

			// Verifica se contém o Auth Bearer no Header do Request
			boolean containsAuthorization = Util.headerContainsBearer(req);

			// Verifica se existe o token e o login no Header da Requisição
			if (containsAuthorization) {
				String token = Util.getTokenFromHeader(req);

				logger.info("Login: " + jwtUtil.getUsername(token) + " -- Token: " + token);

				// Pega a Authentication passando o Token
				UsernamePasswordAuthenticationToken auth = getAutheticationFromJwt(token);

				// Se for diferente de null, coloca no contexto do SecurityContextHolder
				if (auth != null) {
					SecurityContextHolder.getContext().setAuthentication(auth);
				}

			}
			chain.doFilter(req, res);
		}

		// Pega o login do usuário pelo JwtUtil
		// A partir do Login, consulta um serviço do LdapUtil, pra validar os acessos
		// novamentes
		// Cria um UsernamePasswordAuthenticationToken com os dados retornados do Ldap
		@Override
		public UsernamePasswordAuthenticationToken getAutheticationFromJwt(String token) {
			try {
				if (jwtUtil.tokenValido(token)) {
					String username = jwtUtil.getUsername(token);
					UsuarioSessao usuarioSessao = ldapUtil.findById(username);
					return new UsernamePasswordAuthenticationToken(usuarioSessao, null, null);
				}
				return null;
			} catch (Exception e) {
				logger.error(e.getMessage());
				return null;
			}
		}

		public LdapInterface getLdapUtil() {
			return ldapUtil;
		}

		public void setLdapUtil(LdapInterface ldapUtil) {
			this.ldapUtil = ldapUtil;
		}

		public JwtInterface getJwtUtil() {
			return jwtUtil;
		}

		public void setJwtUtil(JwtInterface jwtUtil) {
			this.jwtUtil = jwtUtil;
		}
}
