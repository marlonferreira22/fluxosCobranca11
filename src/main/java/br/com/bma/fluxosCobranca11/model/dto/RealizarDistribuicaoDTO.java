package br.com.bma.fluxosCobranca11.model.dto;

import java.util.ArrayList;
import java.util.List;

public class RealizarDistribuicaoDTO extends RetornoFormDatasetDTO{

	private static final long serialVersionUID = 1L;
	
	private String temTransferir;
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
	private String zoom_cliente;
	private String zoom_assunto;
	private List<ClienteAssuntoDTO> clienteAssunto;
	private String descPlano;
	private String dtlembrete;
	private String descPlanoDist;
	private String descPlanoTransf;
	
	public RealizarDistribuicaoDTO(){
		
	}
	
	public RealizarDistribuicaoDTO(String temTransferir, String statusSolicitacao, String indiceControle,
			String indiceBaixaFat, String flagControle, String analistaResp, String solVisita, String dataVisita,
			String dataRegistro, String nomeAnalista, String nomeSocio, String zoom_cliente, String zoom_assunto,
			List<ClienteAssuntoDTO> clienteAssunto, String descPlano, String dtlembrete, String descPlanoDist,
			String descPlanoTransf) {
		super();
		this.temTransferir = temTransferir;
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
		this.zoom_cliente = zoom_cliente;
		this.zoom_assunto = zoom_assunto;
		this.clienteAssunto = clienteAssunto;
		this.descPlano = descPlano;
		this.dtlembrete = dtlembrete;
		this.descPlanoDist = descPlanoDist;
		this.descPlanoTransf = descPlanoTransf;
	}

	public String getTemTransferir() {
		return temTransferir;
	}

	public void setTemTransferir(String temTransferir) {
		this.temTransferir = temTransferir;
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

	public String getZoom_cliente() {
		return zoom_cliente;
	}

	public void setZoom_cliente(String zoom_cliente) {
		this.zoom_cliente = zoom_cliente;
	}

	public String getZoom_assunto() {
		return zoom_assunto;
	}

	public void setZoom_assunto(String zoom_assunto) {
		this.zoom_assunto = zoom_assunto;
	}

	public List<ClienteAssuntoDTO> getClienteAssunto() {
		return clienteAssunto;
	}

	public void setClienteAssunto(List<ClienteAssuntoDTO> clienteAssunto) {
		this.clienteAssunto = clienteAssunto;
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

	public String getDescPlanoDist() {
		return descPlanoDist;
	}

	public void setDescPlanoDist(String descPlanoDist) {
		this.descPlanoDist = descPlanoDist;
	}

	public String getDescPlanoTransf() {
		return descPlanoTransf;
	}

	public void setDescPlanoTransf(String descPlanoTransf) {
		this.descPlanoTransf = descPlanoTransf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((analistaResp == null) ? 0 : analistaResp.hashCode());
		result = prime * result + ((clienteAssunto == null) ? 0 : clienteAssunto.hashCode());
		result = prime * result + ((dataRegistro == null) ? 0 : dataRegistro.hashCode());
		result = prime * result + ((dataVisita == null) ? 0 : dataVisita.hashCode());
		result = prime * result + ((descPlano == null) ? 0 : descPlano.hashCode());
		result = prime * result + ((descPlanoDist == null) ? 0 : descPlanoDist.hashCode());
		result = prime * result + ((descPlanoTransf == null) ? 0 : descPlanoTransf.hashCode());
		result = prime * result + ((dtlembrete == null) ? 0 : dtlembrete.hashCode());
		result = prime * result + ((flagControle == null) ? 0 : flagControle.hashCode());
		result = prime * result + ((indiceBaixaFat == null) ? 0 : indiceBaixaFat.hashCode());
		result = prime * result + ((indiceControle == null) ? 0 : indiceControle.hashCode());
		result = prime * result + ((nomeAnalista == null) ? 0 : nomeAnalista.hashCode());
		result = prime * result + ((nomeSocio == null) ? 0 : nomeSocio.hashCode());
		result = prime * result + ((solVisita == null) ? 0 : solVisita.hashCode());
		result = prime * result + ((statusSolicitacao == null) ? 0 : statusSolicitacao.hashCode());
		result = prime * result + ((temTransferir == null) ? 0 : temTransferir.hashCode());
		result = prime * result + ((zoom_assunto == null) ? 0 : zoom_assunto.hashCode());
		result = prime * result + ((zoom_cliente == null) ? 0 : zoom_cliente.hashCode());
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
		RealizarDistribuicaoDTO other = (RealizarDistribuicaoDTO) obj;
		if (analistaResp == null) {
			if (other.analistaResp != null)
				return false;
		} else if (!analistaResp.equals(other.analistaResp))
			return false;
		if (clienteAssunto == null) {
			if (other.clienteAssunto != null)
				return false;
		} else if (!clienteAssunto.equals(other.clienteAssunto))
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
		if (descPlanoDist == null) {
			if (other.descPlanoDist != null)
				return false;
		} else if (!descPlanoDist.equals(other.descPlanoDist))
			return false;
		if (descPlanoTransf == null) {
			if (other.descPlanoTransf != null)
				return false;
		} else if (!descPlanoTransf.equals(other.descPlanoTransf))
			return false;
		if (dtlembrete == null) {
			if (other.dtlembrete != null)
				return false;
		} else if (!dtlembrete.equals(other.dtlembrete))
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
		if (temTransferir == null) {
			if (other.temTransferir != null)
				return false;
		} else if (!temTransferir.equals(other.temTransferir))
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
		return true;
	}

	@Override
	public String toString() {
		return "RealizarDistribuicaoDTO [temTransferir=" + temTransferir + ", statusSolicitacao=" + statusSolicitacao
				+ ", indiceControle=" + indiceControle + ", indiceBaixaFat=" + indiceBaixaFat + ", flagControle="
				+ flagControle + ", analistaResp=" + analistaResp + ", solVisita=" + solVisita + ", dataVisita="
				+ dataVisita + ", dataRegistro=" + dataRegistro + ", nomeAnalista=" + nomeAnalista + ", nomeSocio="
				+ nomeSocio + ", zoom_cliente=" + zoom_cliente + ", zoom_assunto=" + zoom_assunto + ", clienteAssunto="
				+ clienteAssunto + ", descPlano=" + descPlano + ", dtlembrete=" + dtlembrete + ", descPlanoDist="
				+ descPlanoDist + ", descPlanoTransf=" + descPlanoTransf + "]";
	}

	public void adicionarClienteAssunto(ClienteAssuntoDTO clienteAssuntoDTO) {
		if(clienteAssunto == null)
			clienteAssunto = new ArrayList<ClienteAssuntoDTO>();
		
		if(clienteAssuntoDTO != null)
			clienteAssunto.add(clienteAssuntoDTO);
		
	}
	
	@Override
	public List<String> retornaCamposParaPrimeiraConsulta() {
		return new ArrayList<String>();
	}
}
