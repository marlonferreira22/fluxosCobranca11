package br.com.bma.fluxosCobranca11.model.form;

public class EmitirFaturaForm {
	
	private static final long serialVersionUID = 1L;

	private String idAssunto;
	private String descricao;
	
	public EmitirFaturaForm() {
		
	}
	
	public EmitirFaturaForm(String idAssunto, String descricao) {
		super();
		this.idAssunto = idAssunto;
		this.descricao = descricao;
	}

	public String getIdAssunto() {
		return idAssunto;
	}

	public void setIdAssunto(String idAssunto) {
		this.idAssunto = idAssunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idAssunto == null) ? 0 : idAssunto.hashCode());
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
		EmitirFaturaForm other = (EmitirFaturaForm) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idAssunto == null) {
			if (other.idAssunto != null)
				return false;
		} else if (!idAssunto.equals(other.idAssunto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmitirFaturaForm [idAssunto=" + idAssunto + ", descricao=" + descricao + "]";
	}
	
	
}
