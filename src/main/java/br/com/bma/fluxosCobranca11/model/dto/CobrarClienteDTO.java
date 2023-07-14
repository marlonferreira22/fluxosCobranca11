package br.com.bma.fluxosCobranca11.model.dto;

import java.util.ArrayList;
import java.util.List;

public class CobrarClienteDTO extends RetornoFormDatasetDTO{

	private static final long serialVersionUID = 1L;
	private String temFiscal;
	private String temCompliance;
	private String temJuridico;
	private String temCliente;
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
	private String fatura;
	private String zoom_fatura;
	private List<ClienteAssuntoFaturaDTO> clienteAssuntoFaturaDTO;
	private String checkTemFiscal;
	private String checkTemJuridico;
	private String checkTemCompliance;
	private String checkTemCliente;
	private String dtlembrete;
	private String descPla;
	private String descPlaFiscal;
	private String descPlaJuridico;
	private String descPlaCompliance;
	private String descPlaCliente;
	
	public CobrarClienteDTO(){
		
	}	
	
	public CobrarClienteDTO(String temFiscal, String temCompliance, String temJuridico, String temCliente,
			String statusSolicitacao, String indiceControle, String indiceBaixaFat, String flagControle,
			String analistaResp, String solVisita, String dataVisita, String dataRegistro, String nomeAnalista,
			String nomeSocio, String cliente, String zoom_cliente, String assunto, String zoom_assunto, String fatura,
			String zoom_fatura, List<ClienteAssuntoFaturaDTO> clienteAssuntoFaturaDTO, String checkTemFiscal,
			String checkTemJuridico, String checkTemCompliance, String checkTemCliente, String dtlembrete,
			String descPla, String descPlaFiscal, String descPlaJuridico, String descPlaCompliance,
			String descPlaCliente) {
		super();
		this.temFiscal = temFiscal;
		this.temCompliance = temCompliance;
		this.temJuridico = temJuridico;
		this.temCliente = temCliente;
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
		this.fatura = fatura;
		this.zoom_fatura = zoom_fatura;
		this.clienteAssuntoFaturaDTO = clienteAssuntoFaturaDTO;
		this.checkTemFiscal = checkTemFiscal;
		this.checkTemJuridico = checkTemJuridico;
		this.checkTemCompliance = checkTemCompliance;
		this.checkTemCliente = checkTemCliente;
		this.dtlembrete = dtlembrete;
		this.descPla = descPla;
		this.descPlaFiscal = descPlaFiscal;
		this.descPlaJuridico = descPlaJuridico;
		this.descPlaCompliance = descPlaCompliance;
		this.descPlaCliente = descPlaCliente;
	}



	public String getTemFiscal() {
		return temFiscal;
	}
	public void setTemFiscal(String temFiscal) {
		this.temFiscal = temFiscal;
	}
	public String getTemCompliance() {
		return temCompliance;
	}
	public void setTemCompliance(String temCompliance) {
		this.temCompliance = temCompliance;
	}
	public String getTemJuridico() {
		return temJuridico;
	}
	public void setTemJuridico(String temJuridico) {
		this.temJuridico = temJuridico;
	}
	public String getTemCliente() {
		return temCliente;
	}
	public void setTemCliente(String temCliente) {
		this.temCliente = temCliente;
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
	public String getFatura() {
		return fatura;
	}
	public void setFatura(String fatura) {
		this.fatura = fatura;
	}
	public String getZoom_fatura() {
		return zoom_fatura;
	}
	public void setZoom_fatura(String zoom_fatura) {
		this.zoom_fatura = zoom_fatura;
	}
	public List<ClienteAssuntoFaturaDTO> getClienteAssuntoFaturaDTO() {
		return clienteAssuntoFaturaDTO;
	}
	public void setClienteAssuntoFaturaDTO(List<ClienteAssuntoFaturaDTO> clienteAssuntoFaturaDTO) {
		this.clienteAssuntoFaturaDTO = clienteAssuntoFaturaDTO;
	}
	public String getCheckTemFiscal() {
		return checkTemFiscal;
	}
	public void setCheckTemFiscal(String checkTemFiscal) {
		this.checkTemFiscal = checkTemFiscal;
	}
	public String getCheckTemJuridico() {
		return checkTemJuridico;
	}
	public void setCheckTemJuridico(String checkTemJuridico) {
		this.checkTemJuridico = checkTemJuridico;
	}
	public String getCheckTemCompliance() {
		return checkTemCompliance;
	}
	public void setCheckTemCompliance(String checkTemCompliance) {
		this.checkTemCompliance = checkTemCompliance;
	}
	public String getCheckTemCliente() {
		return checkTemCliente;
	}
	public void setCheckTemCliente(String checkTemCliente) {
		this.checkTemCliente = checkTemCliente;
	}

	public String getDtlembrete() {
		return dtlembrete;
	}
	public void setDtlembrete(String dtlembrete) {
		this.dtlembrete = dtlembrete;
	}
	public String getDescPla() {
		return descPla;
	}
	public void setDescPla(String descPla) {
		this.descPla = descPla;
	}
	public String getDescPlaFiscal() {
		return descPlaFiscal;
	}
	public void setDescPlaFiscal(String descPlaFiscal) {
		this.descPlaFiscal = descPlaFiscal;
	}
	public String getDescPlaJuridico() {
		return descPlaJuridico;
	}
	public void setDescPlaJuridico(String descPlaJuridico) {
		this.descPlaJuridico = descPlaJuridico;
	}
	public String getDescPlaCompliance() {
		return descPlaCompliance;
	}
	public void setDescPlaCompliance(String descPlaCompliance) {
		this.descPlaCompliance = descPlaCompliance;
	}
	public String getDescPlaCliente() {
		return descPlaCliente;
	}
	public void setDescPlaCliente(String descPlaCliente) {
		this.descPlaCliente = descPlaCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((analistaResp == null) ? 0 : analistaResp.hashCode());
		result = prime * result + ((assunto == null) ? 0 : assunto.hashCode());
		result = prime * result + ((checkTemCliente == null) ? 0 : checkTemCliente.hashCode());
		result = prime * result + ((checkTemCompliance == null) ? 0 : checkTemCompliance.hashCode());
		result = prime * result + ((checkTemFiscal == null) ? 0 : checkTemFiscal.hashCode());
		result = prime * result + ((checkTemJuridico == null) ? 0 : checkTemJuridico.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((clienteAssuntoFaturaDTO == null) ? 0 : clienteAssuntoFaturaDTO.hashCode());
		result = prime * result + ((dataRegistro == null) ? 0 : dataRegistro.hashCode());
		result = prime * result + ((dataVisita == null) ? 0 : dataVisita.hashCode());
		result = prime * result + ((descPla == null) ? 0 : descPla.hashCode());
		result = prime * result + ((descPlaCliente == null) ? 0 : descPlaCliente.hashCode());
		result = prime * result + ((descPlaCompliance == null) ? 0 : descPlaCompliance.hashCode());
		result = prime * result + ((descPlaFiscal == null) ? 0 : descPlaFiscal.hashCode());
		result = prime * result + ((descPlaJuridico == null) ? 0 : descPlaJuridico.hashCode());
		result = prime * result + ((dtlembrete == null) ? 0 : dtlembrete.hashCode());
		result = prime * result + ((fatura == null) ? 0 : fatura.hashCode());
		result = prime * result + ((flagControle == null) ? 0 : flagControle.hashCode());
		result = prime * result + ((indiceBaixaFat == null) ? 0 : indiceBaixaFat.hashCode());
		result = prime * result + ((indiceControle == null) ? 0 : indiceControle.hashCode());
		result = prime * result + ((nomeAnalista == null) ? 0 : nomeAnalista.hashCode());
		result = prime * result + ((nomeSocio == null) ? 0 : nomeSocio.hashCode());
		result = prime * result + ((solVisita == null) ? 0 : solVisita.hashCode());
		result = prime * result + ((statusSolicitacao == null) ? 0 : statusSolicitacao.hashCode());
		result = prime * result + ((temCliente == null) ? 0 : temCliente.hashCode());
		result = prime * result + ((temCompliance == null) ? 0 : temCompliance.hashCode());
		result = prime * result + ((temFiscal == null) ? 0 : temFiscal.hashCode());
		result = prime * result + ((temJuridico == null) ? 0 : temJuridico.hashCode());
		result = prime * result + ((zoom_assunto == null) ? 0 : zoom_assunto.hashCode());
		result = prime * result + ((zoom_cliente == null) ? 0 : zoom_cliente.hashCode());
		result = prime * result + ((zoom_fatura == null) ? 0 : zoom_fatura.hashCode());
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
		CobrarClienteDTO other = (CobrarClienteDTO) obj;
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
		if (checkTemCliente == null) {
			if (other.checkTemCliente != null)
				return false;
		} else if (!checkTemCliente.equals(other.checkTemCliente))
			return false;
		if (checkTemCompliance == null) {
			if (other.checkTemCompliance != null)
				return false;
		} else if (!checkTemCompliance.equals(other.checkTemCompliance))
			return false;
		if (checkTemFiscal == null) {
			if (other.checkTemFiscal != null)
				return false;
		} else if (!checkTemFiscal.equals(other.checkTemFiscal))
			return false;
		if (checkTemJuridico == null) {
			if (other.checkTemJuridico != null)
				return false;
		} else if (!checkTemJuridico.equals(other.checkTemJuridico))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (clienteAssuntoFaturaDTO == null) {
			if (other.clienteAssuntoFaturaDTO != null)
				return false;
		} else if (!clienteAssuntoFaturaDTO.equals(other.clienteAssuntoFaturaDTO))
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
		if (descPla == null) {
			if (other.descPla != null)
				return false;
		} else if (!descPla.equals(other.descPla))
			return false;
		if (descPlaCliente == null) {
			if (other.descPlaCliente != null)
				return false;
		} else if (!descPlaCliente.equals(other.descPlaCliente))
			return false;
		if (descPlaCompliance == null) {
			if (other.descPlaCompliance != null)
				return false;
		} else if (!descPlaCompliance.equals(other.descPlaCompliance))
			return false;
		if (descPlaFiscal == null) {
			if (other.descPlaFiscal != null)
				return false;
		} else if (!descPlaFiscal.equals(other.descPlaFiscal))
			return false;
		if (descPlaJuridico == null) {
			if (other.descPlaJuridico != null)
				return false;
		} else if (!descPlaJuridico.equals(other.descPlaJuridico))
			return false;
		if (dtlembrete == null) {
			if (other.dtlembrete != null)
				return false;
		} else if (!dtlembrete.equals(other.dtlembrete))
			return false;
		if (fatura == null) {
			if (other.fatura != null)
				return false;
		} else if (!fatura.equals(other.fatura))
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
		if (temCliente == null) {
			if (other.temCliente != null)
				return false;
		} else if (!temCliente.equals(other.temCliente))
			return false;
		if (temCompliance == null) {
			if (other.temCompliance != null)
				return false;
		} else if (!temCompliance.equals(other.temCompliance))
			return false;
		if (temFiscal == null) {
			if (other.temFiscal != null)
				return false;
		} else if (!temFiscal.equals(other.temFiscal))
			return false;
		if (temJuridico == null) {
			if (other.temJuridico != null)
				return false;
		} else if (!temJuridico.equals(other.temJuridico))
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
		if (zoom_fatura == null) {
			if (other.zoom_fatura != null)
				return false;
		} else if (!zoom_fatura.equals(other.zoom_fatura))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CobrarClienteDTO [temFiscal=" + temFiscal + ", temCompliance=" + temCompliance + ", temJuridico="
				+ temJuridico + ", temCliente=" + temCliente + ", statusSolicitacao=" + statusSolicitacao
				+ ", indiceControle=" + indiceControle + ", indiceBaixaFat=" + indiceBaixaFat + ", flagControle="
				+ flagControle + ", analistaResp=" + analistaResp + ", solVisita=" + solVisita + ", dataVisita="
				+ dataVisita + ", dataRegistro=" + dataRegistro + ", nomeAnalista=" + nomeAnalista + ", nomeSocio="
				+ nomeSocio + ", cliente=" + cliente + ", zoom_cliente=" + zoom_cliente + ", assunto=" + assunto
				+ ", zoom_assunto=" + zoom_assunto + ", fatura=" + fatura + ", zoom_fatura=" + zoom_fatura
				+ ", clienteAssuntoFaturaDTO=" + clienteAssuntoFaturaDTO + ", checkTemFiscal=" + checkTemFiscal
				+ ", checkTemJuridico=" + checkTemJuridico + ", checkTemCompliance=" + checkTemCompliance
				+ ", checkTemCliente=" + checkTemCliente + ", dtlembrete=" + dtlembrete + ", descPla=" + descPla
				+ ", descPlaFiscal=" + descPlaFiscal + ", descPlaJuridico=" + descPlaJuridico + ", descPlaCompliance="
				+ descPlaCompliance + ", descPlaCliente=" + descPlaCliente + "]";
	}

	@Override
	public List<String> retornaCamposParaPrimeiraConsulta() {
		return new ArrayList<String>();
	}

	public void adicionarAssuntoFatura(ClienteAssuntoFaturaDTO clienteAssuntoFatura) {
		if(clienteAssuntoFaturaDTO == null)
			clienteAssuntoFaturaDTO = new ArrayList<ClienteAssuntoFaturaDTO>();
		
		if(clienteAssuntoFatura != null)
			clienteAssuntoFaturaDTO.add(clienteAssuntoFatura);
		
	}
}
