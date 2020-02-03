package br.com.atividade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LTO_LEITO")
@SequenceGenerator(name = "SEQ_LTO_LEITO", sequenceName = "SEQ_LTO_LEITO", allocationSize = 1)
public class BtpLeito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_LTO_LEITO")
	@Column(name="LTO_SEQ_LEITO")
	private Long id;

	@Column(name="LTO_DSC_LEITO")
	private String descricao;
	
	@OneToOne(targetEntity=BtpClinica.class)
	@JoinColumn(name="CLI_CLINICA", referencedColumnName="idClinica")
	private BtpClinica btpClinica;
	
	public BtpLeito() {
		
	}
	
	public BtpLeito(String descricao) {
		super();	
		this.descricao = descricao;
	}
	
	public BtpLeito(String descricao, Integer ordem) {
		super();
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BtpClinica getBtpClinica() {
		return btpClinica;
	}

	public void setBtpClinica(BtpClinica btpClinica) {
		this.btpClinica = btpClinica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BtpLeito other = (BtpLeito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}
