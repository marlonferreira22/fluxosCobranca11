package br.com.bma.fluxosCobranca11.model.dto;

import java.io.Serializable;

public class ConfigFluigDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private String urlFluig;
    private String urlFluigVital;
    private String urlFluigEngetec;
	private Integer companyId;
	private String usuarioFluig;
	private String senhaFluig;
	private String matriculaFluig;
	private String userSecurityId;
	private String senhaPerformance;
	private String springMailHost;
	private String portaSmtp;
	private String springMailUsername;
	private String springMailPassword;
	private String springMailPropertiesMailSmtpAuth;
	private String springMailSmtp;
	private String springMailPropertiesMailSmtpStarttlsEnable;
	private String springMailDebug;
	
	public ConfigFluigDTO(String urlFluig,String urlFluigVital, String urlFluigEngetec, Integer companyId, String usuarioFluig, String senhaFluig,
			String matriculaFluig, String userSecurityId, String senhaPerformance, String springMailHost,
			String portaSmtp, String springMailUsername, String springMailPassword, String springMailPropertiesMailSmtpAuth,
			String springMailSmtp, String springMailPropertiesMailSmtpStarttlsEnable, String springMailDebug) {
		this.urlFluig = urlFluig;
		this.urlFluigVital = urlFluigVital;
		this.urlFluigEngetec = urlFluigEngetec;
		this.companyId = companyId;
		this.usuarioFluig = usuarioFluig;
		this.senhaFluig = senhaFluig;
		this.matriculaFluig = matriculaFluig;
		this.userSecurityId = userSecurityId;
		this.senhaPerformance = senhaPerformance;
		this.springMailHost = springMailHost;
		this.portaSmtp = portaSmtp;
		this.springMailUsername = springMailUsername;
		this.springMailPassword = springMailPassword;
		this.springMailPropertiesMailSmtpAuth = springMailPropertiesMailSmtpAuth;
		this.springMailSmtp = springMailSmtp;
		this.springMailPropertiesMailSmtpStarttlsEnable = springMailPropertiesMailSmtpStarttlsEnable;
		this.springMailDebug = springMailDebug;
	}
	
	public String getUrlFluig() {
		return urlFluig;
	}
	
	public void setUrlFluig(String urlFluig) {
		this.urlFluig = urlFluig;
	}
	
	
	
	public String getUrlFluigVital() {
		return urlFluigVital;
	}

	public void setUrlFluigVital(String urlFluigVital) {
		this.urlFluigVital = urlFluigVital;
	}

	public String getUrlFluigEngetec() {
		return urlFluigEngetec;
	}

	public void setUrlFluigEngetec(String urlFluigEngetec) {
		this.urlFluigEngetec = urlFluigEngetec;
	}

	public Integer getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	public String getUsuarioFluig() {
		return usuarioFluig;
	}
	
	public void setUsuarioFluig(String usuarioFluig) {
		this.usuarioFluig = usuarioFluig;
	}
	
	public String getSenhaFluig() {
		return senhaFluig;
	}
	
	public void setSenhaFluig(String senhaFluig) {
		this.senhaFluig = senhaFluig;
	}
	
	public String getMatriculaFluig() {
		return matriculaFluig;
	}
	
	public void setMatriculaFluig(String matriculaFluig) {
		this.matriculaFluig = matriculaFluig;
	}
	
	public String getUserSecurityId() {
		return userSecurityId;
	}

	public void setUserSecurityId(String userSecurityId) {
		this.userSecurityId = userSecurityId;
	}

	public String getSenhaPerformance() {
		return senhaPerformance;
	}

	public void setSenhaPerformance(String senhaPerformance) {
		this.senhaPerformance = senhaPerformance;
	}

	public String getSpringMailHost() {
		return springMailHost;
	}

	public void setSpringMailHost(String springMailHost) {
		this.springMailHost = springMailHost;
	}

	public String getPortaSmtp() {
		return portaSmtp;
	}

	public void setPortaSmtp(String portaSmtp) {
		this.portaSmtp = portaSmtp;
	}

	public String getSpringMailUsername() {
		return springMailUsername;
	}

	public void setSpringMailUsername(String springMailUsername) {
		this.springMailUsername = springMailUsername;
	}

	public String getSpringMailPassword() {
		return springMailPassword;
	}

	public void setSpringMailPassword(String springMailPassword) {
		this.springMailPassword = springMailPassword;
	}

	public String getSpringMailPropertiesMailSmtpAuth() {
		return springMailPropertiesMailSmtpAuth;
	}

	public void setSpringMailPropertiesMailSmtpAuth(String springMailPropertiesMailSmtpAuth) {
		this.springMailPropertiesMailSmtpAuth = springMailPropertiesMailSmtpAuth;
	}

	public String getSpringMailSmtp() {
		return springMailSmtp;
	}

	public void setSpringMailSmtp(String springMailSmtp) {
		this.springMailSmtp = springMailSmtp;
	}

	public String getSpringMailPropertiesMailSmtpStarttlsEnable() {
		return springMailPropertiesMailSmtpStarttlsEnable;
	}

	public void setSpringMailPropertiesMailSmtpStarttlsEnable(String springMailPropertiesMailSmtpStarttlsEnable) {
		this.springMailPropertiesMailSmtpStarttlsEnable = springMailPropertiesMailSmtpStarttlsEnable;
	}

	public String getSpringMailDebug() {
		return springMailDebug;
	}

	public void setSpringMailDebug(String springMailDebug) {
		this.springMailDebug = springMailDebug;
	}
}
