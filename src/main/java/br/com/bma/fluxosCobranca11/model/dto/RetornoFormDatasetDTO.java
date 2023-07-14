package br.com.bma.fluxosCobranca11.model.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.bma.fluxosCobranca11.utils.StringUtils;

public abstract class RetornoFormDatasetDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String METADATA_ID = "metadata#id";
	public static final String METADATA_PARENT_ID = "metadata#parent_id";
	public static final String METADATA_VERSION = "metadata#version";
	public static final String METADATA_CARD_INDEX_ID = "metadata#card_index_id";
	public static final String METADATA_CARD_INDEX_VERSION = "metadata#card_index_version";
	public static final String METADATA_ACTIVE = "metadata#active";
	public static final String METADATA_NUM_SOLICITACAO = "numSolicitacao";

	public static final List<String> CAMPOS_METADATA = Arrays.asList(METADATA_ID, METADATA_PARENT_ID, METADATA_VERSION,
			METADATA_CARD_INDEX_ID, METADATA_CARD_INDEX_VERSION, METADATA_ACTIVE, METADATA_NUM_SOLICITACAO);

	private Integer metadataId;
	private Integer parentId;
	private Integer version;
	private Integer cardIndexId;
	private Integer cardIndexVersionId;
	private boolean active;
	private Integer numSolicitacao;
	
	private String idAnexoString;

	public abstract List<String> retornaCamposParaPrimeiraConsulta();
	
	@SuppressWarnings("unchecked")
	public List<String> preencherUrl(String urls) {
		if (StringUtils.isNotBlank(urls)) {
			String[] urlArray = urls.split(";");
			return Arrays.asList(urlArray);
		}
		return Collections.EMPTY_LIST;
	}

	public Integer getMetadataId() {
		return metadataId;
	}

	public void setMetadataId(Integer metadataId) {
		this.metadataId = metadataId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getCardIndexId() {
		return cardIndexId;
	}

	public void setCardIndexId(Integer cardIndexId) {
		this.cardIndexId = cardIndexId;
	}

	public Integer getCardIndexVersionId() {
		return cardIndexVersionId;
	}

	public void setCardIndexVersionId(Integer cardIndexVersionId) {
		this.cardIndexVersionId = cardIndexVersionId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getNumSolicitacao() {
		return numSolicitacao;
	}

	public void setNumSolicitacao(Integer numSolicitacao) {
		this.numSolicitacao = numSolicitacao;
	}

	public String getIdAnexoString() {
		return idAnexoString;
	}

	public void setIdAnexoString(String idAnexoString) {
		this.idAnexoString = idAnexoString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((cardIndexId == null) ? 0 : cardIndexId.hashCode());
		result = prime * result + ((cardIndexVersionId == null) ? 0 : cardIndexVersionId.hashCode());
		result = prime * result + ((metadataId == null) ? 0 : metadataId.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		result = prime * result + ((numSolicitacao == null) ? 0 : numSolicitacao.hashCode());
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
		RetornoFormDatasetDTO other = (RetornoFormDatasetDTO) obj;
		if (active != other.active)
			return false;
		if (cardIndexId == null) {
			if (other.cardIndexId != null)
				return false;
		} else if (!cardIndexId.equals(other.cardIndexId))
			return false;
		if (cardIndexVersionId == null) {
			if (other.cardIndexVersionId != null)
				return false;
		} else if (!cardIndexVersionId.equals(other.cardIndexVersionId))
			return false;
		if (metadataId == null) {
			if (other.metadataId != null)
				return false;
		} else if (!metadataId.equals(other.metadataId))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		if (numSolicitacao == null) {
			if (other.numSolicitacao != null)
				return false;
		} else if (!numSolicitacao.equals(other.numSolicitacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RetornoFormDatasetDTO [metadataId=" + metadataId + ", parentId=" + parentId + ", version=" + version
				+ ", cardIndexId=" + cardIndexId + ", cardIndexVersionId=" + cardIndexVersionId + ", active=" + active
				+ ", numSolicitacao=" + numSolicitacao + ", idAnexoString=" + idAnexoString + "]";
	}

	
}
