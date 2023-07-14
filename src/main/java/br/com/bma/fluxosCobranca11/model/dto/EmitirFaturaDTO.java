package br.com.bma.fluxosCobranca11.model.dto;

import java.util.ArrayList;
import java.util.List;

public class EmitirFaturaDTO extends RetornoFormDatasetDTO{
	
	private static final long serialVersionUID = 8046714625743214104L;
	
	private String vetorFaturas;
	private String statusSolicitacao;
	private String indiceControle;
	private String indiceBaixaFat;
	private String flagControle;
	private String analistaResp;
	private String solVisita;
	private String dataVisita;
	private String dataRegistro;
	private String nomeAnalista;
	private String nomeSocio;
	private String cliente;
	private String zoom_cliente;
	private String assunto;
	private String zoom_assunto;
	private String planoAcao;
	private String zoom_plano;
	private MensagemDTO mensagemDTO; 
	private String descPlano;
	private String dtlembrete;
	private List<FaturasEmitidasDTO> faturasEmitidas;
	// Propostas
	private List<PropostaDTO> propostas;
	
	public EmitirFaturaDTO() {
		
	}
	
	public EmitirFaturaDTO(String vetorFaturas, String statusSolicitacao, String indiceControle, String indiceBaixaFat,
			String flagControle, String analistaResp, String solVisita, String dataVisita, String dataRegistro,
			String nomeAnalista, String nomeSocio, String cliente, String zoom_cliente, String assunto,
			String zoom_assunto, String planoAcao, String zoom_plano, MensagemDTO mensagemDTO, String descPlano,
			String dtlembrete, List<FaturasEmitidasDTO> faturasEmitidas) {
		super();
		this.vetorFaturas = vetorFaturas;
		this.statusSolicitacao = statusSolicitacao;
		this.indiceControle = indiceControle;
		this.indiceBaixaFat = indiceBaixaFat;
		this.flagControle = flagControle;
		this.analistaResp = analistaResp;
		this.solVisita = solVisita;
		this.dataVisita = dataVisita;
		this.dataRegistro = dataRegistro;
		this.nomeAnalista = nomeAnalista;
		this.nomeSocio = nomeSocio;
		this.cliente = cliente;
		this.zoom_cliente = zoom_cliente;
		this.assunto = assunto;
		this.zoom_assunto = zoom_assunto;
		this.planoAcao = planoAcao;
		this.zoom_plano = zoom_plano;
		this.mensagemDTO = mensagemDTO;
		this.descPlano = descPlano;
		this.dtlembrete = dtlembrete;
		this.faturasEmitidas = faturasEmitidas;
	}
	public String getVetorFaturas() {
		return vetorFaturas;
	}
	public void setVetorFaturas(String vetorFaturas) {
		this.vetorFaturas = vetorFaturas;
	}
	public String getStatusSolicitacao() {
		return statusSolicitacao;
	}
	public void setStatusSolicitacao(String statusSolicitacao) {
		this.statusSolicitacao = statusSolicitacao;
	}
	public String getIndiceControle() {
		return indiceControle;
	}
	public void setIndiceControle(String indiceControle) {
		this.indiceControle = indiceControle;
	}
	public String getIndiceBaixaFat() {
		return indiceBaixaFat;
	}
	public void setIndiceBaixaFat(String indiceBaixaFat) {
		this.indiceBaixaFat = indiceBaixaFat;
	}
	public String getFlagControle() {
		return flagControle;
	}
	public void setFlagControle(String flagControle) {
		this.flagControle = flagControle;
	}
	public String getAnalistaResp() {
		return analistaResp;
	}
	public void setAnalistaResp(String analistaResp) {
		this.analistaResp = analistaResp;
	}
	public String getSolVisita() {
		return solVisita;
	}
	public void setSolVisita(String solVisita) {
		this.solVisita = solVisita;
	}
	public String getDataVisita() {
		return dataVisita;
	}
	public void setDataVisita(String dataVisita) {
		this.dataVisita = dataVisita;
	}
	public String getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public String getNomeAnalista() {
		return nomeAnalista;
	}
	public void setNomeAnalista(String nomeAnalista) {
		this.nomeAnalista = nomeAnalista;
	}
	public String getNomeSocio() {
		return nomeSocio;
	}
	public void setNomeSocio(String nomeSocio) {
		this.nomeSocio = nomeSocio;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getZoom_cliente() {
		return zoom_cliente;
	}
	public void setZoom_cliente(String zoom_cliente) {
		this.zoom_cliente = zoom_cliente;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getZoom_assunto() {
		return zoom_assunto;
	}
	public void setZoom_assunto(String zoom_assunto) {
		this.zoom_assunto = zoom_assunto;
	}
	public String getPlanoAcao() {
		return planoAcao;
	}
	public void setPlanoAcao(String planoAcao) {
		this.planoAcao = planoAcao;
	}
	public String getZoom_plano() {
		return zoom_plano;
	}
	public void setZoom_plano(String zoom_plano) {
		this.zoom_plano = zoom_plano;
	}
	public MensagemDTO getMensagemDTO() {
		return mensagemDTO;
	}
	public void setMensagemDTO(MensagemDTO mensagemDTO) {
		this.mensagemDTO = mensagemDTO;
	}
	public String getDescPlano() {
		return descPlano;
	}
	public void setDescPlano(String descPlano) {
		this.descPlano = descPlano;
	}
	public String getDtlembrete() {
		return dtlembrete;
	}
	public void setDtlembrete(String dtlembrete) {
		this.dtlembrete = dtlembrete;
	}
	public List<FaturasEmitidasDTO> getFaturasEmitidas() {
		return faturasEmitidas;
	}
	public void setFaturasEmitidas(List<FaturasEmitidasDTO> faturasEmitidas) {
		this.faturasEmitidas = faturasEmitidas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((analistaResp == null) ? 0 : analistaResp.hashCode());
		result = prime * result + ((assunto == null) ? 0 : assunto.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataRegistro == null) ? 0 : dataRegistro.hashCode());
		result = prime * result + ((dataVisita == null) ? 0 : dataVisita.hashCode());
		result = prime * result + ((descPlano == null) ? 0 : descPlano.hashCode());
		result = prime * result + ((dtlembrete == null) ? 0 : dtlembrete.hashCode());
		result = prime * result + ((faturasEmitidas == null) ? 0 : faturasEmitidas.hashCode());
		result = prime * result + ((flagControle == null) ? 0 : flagControle.hashCode());
		result = prime * result + ((indiceBaixaFat == null) ? 0 : indiceBaixaFat.hashCode());
		result = prime * result + ((indiceControle == null) ? 0 : indiceControle.hashCode());
		result = prime * result + ((mensagemDTO == null) ? 0 : mensagemDTO.hashCode());
		result = prime * result + ((nomeAnalista == null) ? 0 : nomeAnalista.hashCode());
		result = prime * result + ((nomeSocio == null) ? 0 : nomeSocio.hashCode());
		result = prime * result + ((planoAcao == null) ? 0 : planoAcao.hashCode());
		result = prime * result + ((solVisita == null) ? 0 : solVisita.hashCode());
		result = prime * result + ((statusSolicitacao == null) ? 0 : statusSolicitacao.hashCode());
		result = prime * result + ((vetorFaturas == null) ? 0 : vetorFaturas.hashCode());
		result = prime * result + ((zoom_assunto == null) ? 0 : zoom_assunto.hashCode());
		result = prime * result + ((zoom_cliente == null) ? 0 : zoom_cliente.hashCode());
		result = prime * result + ((zoom_plano == null) ? 0 : zoom_plano.hashCode());
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
		EmitirFaturaDTO other = (EmitirFaturaDTO) obj;
		if (analistaResp == null) {
			if (other.analistaResp != null)
				return false;
		} else if (!analistaResp.equals(other.analistaResp))
			return false;
		if (assunto == null) {
			if (other.assunto != null)
				return false;
		} else if (!assunto.equals(other.assunto))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataRegistro == null) {
			if (other.dataRegistro != null)
				return false;
		} else if (!dataRegistro.equals(other.dataRegistro))
			return false;
		if (dataVisita == null) {
			if (other.dataVisita != null)
				return false;
		} else if (!dataVisita.equals(other.dataVisita))
			return false;
		if (descPlano == null) {
			if (other.descPlano != null)
				return false;
		} else if (!descPlano.equals(other.descPlano))
			return false;
		if (dtlembrete == null) {
			if (other.dtlembrete != null)
				return false;
		} else if (!dtlembrete.equals(other.dtlembrete))
			return false;
		if (faturasEmitidas == null) {
			if (other.faturasEmitidas != null)
				return false;
		} else if (!faturasEmitidas.equals(other.faturasEmitidas))
			return false;
		if (flagControle == null) {
			if (other.flagControle != null)
				return false;
		} else if (!flagControle.equals(other.flagControle))
			return false;
		if (indiceBaixaFat == null) {
			if (other.indiceBaixaFat != null)
				return false;
		} else if (!indiceBaixaFat.equals(other.indiceBaixaFat))
			return false;
		if (indiceControle == null) {
			if (other.indiceControle != null)
				return false;
		} else if (!indiceControle.equals(other.indiceControle))
			return false;
		if (mensagemDTO == null) {
			if (other.mensagemDTO != null)
				return false;
		} else if (!mensagemDTO.equals(other.mensagemDTO))
			return false;
		if (nomeAnalista == null) {
			if (other.nomeAnalista != null)
				return false;
		} else if (!nomeAnalista.equals(other.nomeAnalista))
			return false;
		if (nomeSocio == null) {
			if (other.nomeSocio != null)
				return false;
		} else if (!nomeSocio.equals(other.nomeSocio))
			return false;
		if (planoAcao == null) {
			if (other.planoAcao != null)
				return false;
		} else if (!planoAcao.equals(other.planoAcao))
			return false;
		if (solVisita == null) {
			if (other.solVisita != null)
				return false;
		} else if (!solVisita.equals(other.solVisita))
			return false;
		if (statusSolicitacao == null) {
			if (other.statusSolicitacao != null)
				return false;
		} else if (!statusSolicitacao.equals(other.statusSolicitacao))
			return false;
		if (vetorFaturas == null) {
			if (other.vetorFaturas != null)
				return false;
		} else if (!vetorFaturas.equals(other.vetorFaturas))
			return false;
		if (zoom_assunto == null) {
			if (other.zoom_assunto != null)
				return false;
		} else if (!zoom_assunto.equals(other.zoom_assunto))
			return false;
		if (zoom_cliente == null) {
			if (other.zoom_cliente != null)
				return false;
		} else if (!zoom_cliente.equals(other.zoom_cliente))
			return false;
		if (zoom_plano == null) {
			if (other.zoom_plano != null)
				return false;
		} else if (!zoom_plano.equals(other.zoom_plano))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "EmitirFaturaDTO [vetorFaturas=" + vetorFaturas + ", statusSolicitacao=" + statusSolicitacao
				+ ", indiceControle=" + indiceControle + ", indiceBaixaFat=" + indiceBaixaFat + ", flagControle="
				+ flagControle + ", analistaResp=" + analistaResp + ", solVisita=" + solVisita + ", dataVisita="
				+ dataVisita + ", dataRegistro=" + dataRegistro + ", nomeAnalista=" + nomeAnalista + ", nomeSocio="
				+ nomeSocio + ", cliente=" + cliente + ", zoom_cliente=" + zoom_cliente + ", assunto=" + assunto
				+ ", zoom_assunto=" + zoom_assunto + ", planoAcao=" + planoAcao + ", zoom_plano=" + zoom_plano
				+ ", mensagemDTO=" + mensagemDTO + ", descPlano=" + descPlano + ", dtlembrete=" + dtlembrete
				+ ", faturasEmitidas=" + faturasEmitidas + "]";
	}


	public void adicionarProposta(PropostaDTO proposta) {
		if (propostas == null)
			propostas = new ArrayList<PropostaDTO>();

		if (proposta != null)
			propostas.add(proposta);		
	}
	
	public void adicionarFaturasEmitidas(FaturasEmitidasDTO faturasEmitidasDTO){
		if(faturasEmitidas == null)
			faturasEmitidas = new ArrayList<FaturasEmitidasDTO>();
		
		if(faturasEmitidasDTO != null)
			faturasEmitidas.add(faturasEmitidasDTO);
	}
	
	@Override
	public List<String> retornaCamposParaPrimeiraConsulta() {
		return new ArrayList<String>();
	}
	

}
