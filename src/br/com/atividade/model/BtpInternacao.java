package br.com.atividade.model;

import java.util.Date;

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
@Table(name="INT_INTERNACAO")
@SequenceGenerator(name = "SEQ_INT_INTERNACAO", sequenceName = "SEQ_INT_INTERNACAO", allocationSize = 1)
public class BtpInternacao {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_INT_INTERNACAO")
	@Column(name="INT_SEQ_INTERNACAO")
	private Long intSeqInternacao;
	
	
	@Column(name="INT_DATA_INTERNACAO")
	private Date intDataInternacao;
	
	@OneToOne(targetEntity=BtpPaciente.class)
	@JoinColumn(name="PAC_PACIENTE", referencedColumnName="pacSeqPaciente")	
	private BtpPaciente btpPaciente;
	
	@OneToOne(targetEntity=BtpLeito.class)
	@JoinColumn(name="LTO_LEITO", referencedColumnName="id")
	private BtpLeito btpLeito;
		

	public BtpInternacao() {
		super();
	}

	public BtpInternacao(Long intSeqInternacao, Date inDataInternacao, BtpPaciente btpPaciente, BtpLeito btpLeito) {
		super();
		this.intSeqInternacao = intSeqInternacao;
		this.intDataInternacao = inDataInternacao;
		this.btpPaciente = btpPaciente;
		this.btpLeito = btpLeito;
	}

	public Long getIntSeqInternacao() {
		return intSeqInternacao;
	}

	public void setIntSeqInternacao(Long intSeqInternacao) {
		this.intSeqInternacao = intSeqInternacao;
	}

	public Date getIntDataInternacao() {
		return intDataInternacao;
	}

	public void setIntDataInternacao(Date intDataInternacao) {
		this.intDataInternacao = intDataInternacao;
	}

	public BtpPaciente getBtpPaciente() {
		return btpPaciente;
	}

	public void setBtpPaciente(BtpPaciente btpPaciente) {
		this.btpPaciente = btpPaciente;
	}

	public BtpLeito getBtpLeito() {
		return btpLeito;
	}

	public void setBtpLeito(BtpLeito btpLeito) {
		this.btpLeito = btpLeito;
	}
	
	
	

}
