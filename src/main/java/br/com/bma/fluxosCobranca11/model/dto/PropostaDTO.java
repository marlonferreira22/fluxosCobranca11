package br.com.bma.fluxosCobranca11.model.dto;

import java.util.ArrayList;
import java.util.List;

public class PropostaDTO extends RetornoFormDatasetDTO{
	
	private static final long serialVersionUID = 1L;

	//@NotNull
	private String descricaoNegociacao;
	
	//@NotNull	
	private String dataNegociacao;
	
	//@NotNull
	private String nomeNegociacao;
	
	//@NotNull
	private String valorNegociacao;
	
	private String nomeCQGNegociacao;
	
	
	public PropostaDTO(){
		
	}
	
	public PropostaDTO(String descricaoNegociacao, String dataNegociacao, String nomeNegociacao, String valorNegociacao,
			String nomeCQGNegociacao) {
		super();
		this.descricaoNegociacao = descricaoNegociacao;
		this.dataNegociacao = dataNegociacao;
		this.nomeNegociacao = nomeNegociacao;
		this.valorNegociacao = valorNegociacao;
		this.nomeCQGNegociacao = nomeCQGNegociacao;
	}


	public String getDescricaoNegociacao() {
		return descricaoNegociacao;
	}

	public void setDescricaoNegociacao(String descricaoNegociacao) {
		this.descricaoNegociacao = descricaoNegociacao;
	}

	public String getDataNegociacao() {
		return dataNegociacao;
	}

	public void setDataNegociacao(String dataNegociacao) {
		this.dataNegociacao = dataNegociacao;
	}

	public String getNomeNegociacao() {
		return nomeNegociacao;
	}

	public void setNomeNegociacao(String nomeNegociacao) {
		this.nomeNegociacao = nomeNegociacao;
	}

	public String getValorNegociacao() {
		return valorNegociacao;
	}

	public void setValorNegociacao(String valorNegociacao) {
		this.valorNegociacao = valorNegociacao;
	}

	public String getNomeCQGNegociacao() {
		return nomeCQGNegociacao;
	}

	public void setNomeCQGNegociacao(String nomeCQGNegociacao) {
		this.nomeCQGNegociacao = nomeCQGNegociacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataNegociacao == null) ? 0 : dataNegociacao.hashCode());
		result = prime * result + ((descricaoNegociacao == null) ? 0 : descricaoNegociacao.hashCode());
		result = prime * result + ((nomeCQGNegociacao == null) ? 0 : nomeCQGNegociacao.hashCode());
		result = prime * result + ((nomeNegociacao == null) ? 0 : nomeNegociacao.hashCode());
		result = prime * result + ((valorNegociacao == null) ? 0 : valorNegociacao.hashCode());
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
		PropostaDTO other = (PropostaDTO) obj;
		if (dataNegociacao == null) {
			if (other.dataNegociacao != null)
				return false;
		} else if (!dataNegociacao.equals(other.dataNegociacao))
			return false;
		if (descricaoNegociacao == null) {
			if (other.descricaoNegociacao != null)
				return false;
		} else if (!descricaoNegociacao.equals(other.descricaoNegociacao))
			return false;
		if (nomeCQGNegociacao == null) {
			if (other.nomeCQGNegociacao != null)
				return false;
		} else if (!nomeCQGNegociacao.equals(other.nomeCQGNegociacao))
			return false;
		if (nomeNegociacao == null) {
			if (other.nomeNegociacao != null)
				return false;
		} else if (!nomeNegociacao.equals(other.nomeNegociacao))
			return false;
		if (valorNegociacao == null) {
			if (other.valorNegociacao != null)
				return false;
		} else if (!valorNegociacao.equals(other.valorNegociacao))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "PropostaDTO [descricaoNegociacao=" + descricaoNegociacao + ", dataNegociacao=" + dataNegociacao
				+ ", nomeNegociacao=" + nomeNegociacao + ", valorNegociacao=" + valorNegociacao + ", nomeCQGNegociacao="
				+ nomeCQGNegociacao + "]";
	}

	@Override
	public List<String> retornaCamposParaPrimeiraConsulta() {
		return new ArrayList<String>();
	}
}
