package br.com.bma.fluxosCobranca11.model.dto;

import java.util.ArrayList;
import java.util.List;

public class ClienteAssuntoFaturaDTO extends RetornoFormDatasetDTO{
	
	private static final long serialVersionUID = 1L;
	
	private String tblCliente;
	private String tblAssunto;
	private String tblFatura;
	private String tblControle;
	
	public ClienteAssuntoFaturaDTO() {
		
	}

	public ClienteAssuntoFaturaDTO(String tblCliente, String tblAssunto, String tblFatura, String tblControle) {
		super();
		this.tblCliente = tblCliente;
		this.tblAssunto = tblAssunto;
		this.tblFatura = tblFatura;
		this.tblControle = tblControle;
	}

	public String getTblCliente() {
		return tblCliente;
	}

	public void setTblCliente(String tblCliente) {
		this.tblCliente = tblCliente;
	}

	public String getTblAssunto() {
		return tblAssunto;
	}

	public void setTblAssunto(String tblAssunto) {
		this.tblAssunto = tblAssunto;
	}

	public String getTblFatura() {
		return tblFatura;
	}

	public void setTblFatura(String tblFatura) {
		this.tblFatura = tblFatura;
	}

	public String getTblControle() {
		return tblControle;
	}

	public void setTblControle(String tblControle) {
		this.tblControle = tblControle;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tblAssunto == null) ? 0 : tblAssunto.hashCode());
		result = prime * result + ((tblCliente == null) ? 0 : tblCliente.hashCode());
		result = prime * result + ((tblControle == null) ? 0 : tblControle.hashCode());
		result = prime * result + ((tblFatura == null) ? 0 : tblFatura.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteAssuntoFaturaDTO other = (ClienteAssuntoFaturaDTO) obj;
		if (tblAssunto == null) {
			if (other.tblAssunto != null)
				return false;
		} else if (!tblAssunto.equals(other.tblAssunto))
			return false;
		if (tblCliente == null) {
			if (other.tblCliente != null)
				return false;
		} else if (!tblCliente.equals(other.tblCliente))
			return false;
		if (tblControle == null) {
			if (other.tblControle != null)
				return false;
		} else if (!tblControle.equals(other.tblControle))
			return false;
		if (tblFatura == null) {
			if (other.tblFatura != null)
				return false;
		} else if (!tblFatura.equals(other.tblFatura))
			return false;
		return true;
	}	

	@Override
	public String toString() {
		return "ClienteAssuntoFaturaDTO [tblCliente=" + tblCliente + ", tblAssunto=" + tblAssunto + ", tblFatura="
				+ tblFatura + ", tblControle=" + tblControle + "]";
	}

	@Override
	public List<String> retornaCamposParaPrimeiraConsulta() {
		return new ArrayList<String>();
	}
}
