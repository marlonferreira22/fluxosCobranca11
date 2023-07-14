package br.com.bma.fluxosCobranca11.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.com.bma.fluxosCobranca11.model.dto.ConfigFluigDTO;
import br.com.bma.fluxosCobranca11.security.FluxosCobrancaAuthorizationFilter;
import br.com.bma.fluxosCobranca11.security.JwtUtil;
import br.com.bma.fluxosCobranca11.utils.ConfigRandomPassword;
import br.com.bma.fluxosCobranca11.utils.RandomPassword;
import br.com.bma.fluxosCobranca11.ws.FluigServiceFactory;
import br.com.bma.fluxosCobranca11.ws.WorkflowEngineService;

@SuppressWarnings("deprecation")
/*@Component
@PropertySource("classpath:application.properties")*/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static final String WEBDESK = "/webdesk";
	
	@Value("${server.servlet.context-path}")
	private String contextPath;

	@Value("${url.fluig:}")
	private String urlFluig;
	
	@Value("${companyid.fluig:}")
	private Integer companyId;

	@Value("${usuario.fluig:}")
	private String usuarioFluig;

	@Value("${senha.fluig:}")
	private String senhaFluig;

	@Value("${matricula.fluig:}")
	private String matriculaFluig;
	
	@Value("${user.security.id:}")
	private String userSecurityId;
	
	@Value("${senha.performance:}")
	private String senhaPerformance;
	
	@Value("${spring.mail.host:}")
	private String springMailHost;
	
	@Value("${spring.mail.properties.mail.smtp.socketFactory.port:}")
	private String portaSmtp;
	
	@Value("${spring.mail.username:}")
	private String springMailUsername;
	
	@Value("${spring.mail.password:}")
	private String springMailPassword;
	
	@Value("${spring.mail.properties.mail.smtp.auth:}")
	private String springMailPropertiesMailSmtpAuth;
	
	@Value("${spring.mail.smtp:}")
	private String springMailSmtp;
	
	@Value("${spring.mail.properties.mail.smtp.starttls.enable:}")
	private String springMailPropertiesMailSmtpStarttlsEnable;
	
	@Value("${spring.mail.debug:}")
	private String springMailDebug;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	/*@Autowired
	private JwtUtil jwtUtil;*/
	
	 @Bean
	 public UserDetailsService userDetailsService() {
	     return super.userDetailsService();
	 }
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/*").permitAll();
		http.csrf().disable();
		/*ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authRequests = http
				.authorizeRequests();
		
		authRequests = fazerRegrasEndpointCobrarCliente(authRequests);
		authRequests = fazerRegrasEndpointEmitirFatura(authRequests);
		authRequests = fazerRegrasEndpointRealizarDistribuicao(authRequests);
		
		authRequests.anyRequest().authenticated();
		
		// Adiciona o filtro de Authorization
		// Para proteger os endpoints que precisam de permissão
		//http.addFilter(new FluxosCobrancaAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/
	}
	
	private ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry fazerRegrasEndpointCobrarCliente(
			ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests) {
		return authorizeRequests.antMatchers("/cobrarcliente").permitAll()
				.antMatchers("/cobrarcliente/*").permitAll()
				.antMatchers("/cobrarcliente/{id}").permitAll()
				.antMatchers("/cobrarcliente/{id}/").permitAll();
	}
	
	private ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry fazerRegrasEndpointEmitirFatura(
			ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests) {
		return authorizeRequests.antMatchers("/emitirfatura").permitAll()
				.antMatchers("/emitirfatura/*").permitAll()
				.antMatchers("/emitirfatura/{id}").permitAll()
				.antMatchers("/emitirfatura/{id}/").permitAll();
	}
	
	private ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry fazerRegrasEndpointRealizarDistribuicao(
			ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests) {
		return authorizeRequests.antMatchers("/realizardistribuicao").permitAll()
				.antMatchers("/realizardistribuicao/*").permitAll()
				.antMatchers("/realizardistribuicao/{id}").permitAll()
				.antMatchers("/realizardistribuicao/{id}/").permitAll();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	RandomPassword criarRandomPassword() {
		ConfigRandomPassword configuracao = criarConfiguracaoRandomPassword();
		return new RandomPassword(configuracao);
	}

	private ConfigRandomPassword criarConfiguracaoRandomPassword() {
		ConfigRandomPassword configRamdom = new ConfigRandomPassword();
		configRamdom.setMaiusculas(true);
		configRamdom.setMinusculas(true);
		configRamdom.setNumeros(true);
		configRamdom.setCaracteresEspeciais(true);
		return configRamdom;
	}


	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	private void validarUrlFluig() {
		if (urlFluig == null)
			throw new RuntimeException("URL Fluig está nula");
	}
	
	@Bean
	public String getUrlFluig() {
		return urlFluig;
	}
	
	@Bean
	public String getUsuarioFluig(){
		return usuarioFluig;
	}
	
	@Bean
	public String getSenhaFluig(){
		return senhaFluig;
	}
	
	@Bean
	public Integer getCompanyId(){
		return companyId;
	}
	
	@Bean
	public String getMatriculaFluig(){
		return matriculaFluig;
	}
	
	@Bean
	WorkflowEngineService criarWorkflowEngineService() {
		return FluigServiceFactory.criarWorkflowEngineService(retornaUrlWebdesk());
	}
	
	private String retornaUrlWebdesk() {
		validarUrlFluig();
		return urlFluig + WEBDESK;
	}
	
	public String getContextPath() {
		return contextPath;
	}
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
}
