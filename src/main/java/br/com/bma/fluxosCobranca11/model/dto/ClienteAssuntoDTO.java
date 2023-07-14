package br.com.bma.fluxosCobranca11.model.dto;

import java.util.ArrayList;
import java.util.List;

public class ClienteAssuntoDTO extends RetornoFormDatasetDTO{
	
	private static final long serialVersionUID = 1L;
	
	private String tblCliente;
	private String tblAssunto;
	private String acaoSelecionada;
		
	public ClienteAssuntoDTO() {
		
	}
	
	public ClienteAssuntoDTO(String tblCliente, String tblAssunto, String acaoSelecionada) {
		super();
		this.tblCliente = tblCliente;
		this.tblAssunto = tblAssunto;
		this.acaoSelecionada = acaoSelecionada;
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

	public String getAcaoSelecionada() {
		return acaoSelecionada;
	}

	public void setAcaoSelecionada(String acaoSelecionada) {
		this.acaoSelecionada = acaoSelecionada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((acaoSelecionada == null) ? 0 : acaoSelecionada.hashCode());
		result = prime * result + ((tblAssunto == null) ? 0 : tblAssunto.hashCode());
		result = prime * result + ((tblCliente == null) ? 0 : tblCliente.hashCode());
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
		ClienteAssuntoDTO other = (ClienteAssuntoDTO) obj;
		if (acaoSelecionada == null) {
			if (other.acaoSelecionada != null)
				return false;
		} else if (!acaoSelecionada.equals(other.acaoSelecionada))
			return false;
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
		return true;
	}
	
	
	@Override
	public String toString() {
		return "ClienteAssuntoDTO [tblCliente=" + tblCliente + ", tblAssunto=" + tblAssunto + ", acaoSelecionada="
				+ acaoSelecionada + "]";
	}

	@Override
	public List<String> retornaCamposParaPrimeiraConsulta() {
		return new ArrayList<String>();
	}
}
