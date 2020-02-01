package br.com.atividade.model;

import java.io.Serializable;

/**
 * @author Jaques Oliveira
 *
 */
public class BtpClinica implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Long idClinica;
	
	private String nomeClinica;

	

	public BtpClinica(final String nomeClinica) {
		super();
		this.nomeClinica = nomeClinica;
	}

	public BtpClinica(final Long idClinica, final String nomeClinica) {
		super();
		this.idClinica = idClinica;
		this.nomeClinica = nomeClinica;
	}
	
	
	public String getNomeClinica() {
		return nomeClinica;
	}

	public void setNomeClinica(String nomeClinica) {
		this.nomeClinica = nomeClinica;
	}
	

	public Long getIdClinica() {
		return idClinica;
	}

	public void setIdClinica(Long idClinica) {
		this.idClinica = idClinica;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idClinica == null) ? 0 : idClinica.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BtpClinica other = (BtpClinica) obj;
		if (idClinica == null) {
			if (other.idClinica != null)
				return false;
		} else if (!idClinica.equals(other.idClinica))
			return false;
		return true;
	}
	
}
