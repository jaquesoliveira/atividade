package br.com.atividade.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.atividade.api.GenericEntity;

/**
 * @author Jaques Oliveira
 *
 */
@Entity
@Table(name="CLI_CLINICA")
@SequenceGenerator(name = "SEQ_CLI_CLINICA", sequenceName = "SEQ_CLI_CLINICA", allocationSize = 1)
public class BtpClinica implements GenericEntity<Long>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CLI_CLINICA")
	@Column(name="CLI_SEQ_CLINICA")
	private Long idClinica;
	
	@Column(name="CLI_NOME_CLINICA")
	private String nomeClinica;	
	
	public BtpClinica() {
		super();
	}

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
	
	
	public Long getNumSequencial() {		
		return idClinica;
	}

	public void setNumSequencial(Long numSequencial) {
		this.idClinica = numSequencial;		
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
