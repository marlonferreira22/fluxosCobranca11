package br.com.bma.fluxosCobranca11.model.dto;

import java.util.List;

public class UsuarioSessao {

	private String cn;
	private String displayName;
	private String givenName;
	private String sAMAccountName;
	private String accountControl;
	private Long userAccountControl;
	private String mail;
	private String sn;
	private String distinguishedName;
	private List<String> memberOf;
	
	public UsuarioSessao() {
		
	}
	
	public String getCn() {
		return cn;
	}
	
	public void setCn(String cn) {
		this.cn = cn;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	public String getsAMAccountName() {
		return sAMAccountName;
	}
	
	public void setsAMAccountName(String sAMAccountName) {
		this.sAMAccountName = sAMAccountName;
	}
	
	public String getAccountControl() {
		return accountControl;
	}
	
	public void setAccountControl(String accountControl) {
		this.accountControl = accountControl;
	}
	
	public Long getUserAccountControl() {
		return userAccountControl;
	}
	
	public void setUserAccountControl(Long userAccountControl) {
		this.userAccountControl = userAccountControl;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getSn() {
		return sn;
	}
	
	public void setSn(String sn) {
		this.sn = sn;
	}
	
	public String getDistinguishedName() {
		return distinguishedName;
	}
	
	public void setDistinguishedName(String distinguishedName) {
		this.distinguishedName = distinguishedName;
	}
	
	public List<String> getMemberOf() {
		return memberOf;
	}
	
	public void setMemberOf(List<String> memberOf) {
		this.memberOf = memberOf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountControl == null) ? 0 : accountControl.hashCode());
		result = prime * result + ((cn == null) ? 0 : cn.hashCode());
		result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((distinguishedName == null) ? 0 : distinguishedName.hashCode());
		result = prime * result + ((givenName == null) ? 0 : givenName.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((memberOf == null) ? 0 : memberOf.hashCode());
		result = prime * result + ((sAMAccountName == null) ? 0 : sAMAccountName.hashCode());
		result = prime * result + ((sn == null) ? 0 : sn.hashCode());
		result = prime * result + ((userAccountControl == null) ? 0 : userAccountControl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioSessao other = (UsuarioSessao) obj;
		if (accountControl == null) {
			if (other.accountControl != null)
				return false;
		} else if (!accountControl.equals(other.accountControl))
			return false;
		if (cn == null) {
			if (other.cn != null)
				return false;
		} else if (!cn.equals(other.cn))
			return false;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (distinguishedName == null) {
			if (other.distinguishedName != null)
				return false;
		} else if (!distinguishedName.equals(other.distinguishedName))
			return false;
		if (givenName == null) {
			if (other.givenName != null)
				return false;
		} else if (!givenName.equals(other.givenName))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (memberOf == null) {
			if (other.memberOf != null)
				return false;
		} else if (!memberOf.equals(other.memberOf))
			return false;
		if (sAMAccountName == null) {
			if (other.sAMAccountName != null)
				return false;
		} else if (!sAMAccountName.equals(other.sAMAccountName))
			return false;
		if (sn == null) {
			if (other.sn != null)
				return false;
		} else if (!sn.equals(other.sn))
			return false;
		if (userAccountControl == null) {
			if (other.userAccountControl != null)
				return false;
		} else if (!userAccountControl.equals(other.userAccountControl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LdapRetornoDTO [cn=" + cn + ", displayName=" + displayName + ", givenName=" + givenName
				+ ", sAMAccountName=" + sAMAccountName + ", accountControl=" + accountControl + ", userAccountControl="
				+ userAccountControl + ", mail=" + mail + ", sn=" + sn + ", distinguishedName=" + distinguishedName
				+ ", memberOf=" + memberOf + "]";
	}
}
