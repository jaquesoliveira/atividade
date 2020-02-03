package br.com.atividade.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PAC_PACIENTE")
@SequenceGenerator(name="SEQ_PAC_PACIENTE", sequenceName="SEQ_PAC_PACIENTE", allocationSize=1)
public class BtpPaciente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PAC_PACIENTE")
	@Column(name="PAC_SEQ_PACIENTE")
	private Long pacSeqPaciente;
	
	@Column(name="PAC_NOME_PACIENTE")
	private String pacNomePaciente;
	
	@Column(name="PAC_DATA_NASCIMENTO")
	private Date pacDataNascimento;
	
	
	public BtpPaciente() {
		super();
	}

	public BtpPaciente(Long pacSeqPaciente, String pacNomePaciente, Date pacDataNascimento) {
		super();
		this.pacSeqPaciente = pacSeqPaciente;
		this.pacNomePaciente = pacNomePaciente;
		this.pacDataNascimento = pacDataNascimento;
	}

	public Long getPacSeqPaciente() {
		return pacSeqPaciente;
	}

	public void setPacSeqPaciente(Long pacSeqPaciente) {
		this.pacSeqPaciente = pacSeqPaciente;
	}

	public String getPacNomePaciente() {
		return pacNomePaciente;
	}

	public void setPacNomePaciente(String pacNomePaciente) {
		this.pacNomePaciente = pacNomePaciente;
	}

	public Date getPacDataNascimento() {
		return pacDataNascimento;
	}

	public void setPacDataNascimento(Date pacDataNascimento) {
		this.pacDataNascimento = pacDataNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pacSeqPaciente == null) ? 0 : pacSeqPaciente.hashCode());
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
		BtpPaciente other = (BtpPaciente) obj;
		if (pacSeqPaciente == null) {
			if (other.pacSeqPaciente != null)
				return false;
		} else if (!pacSeqPaciente.equals(other.pacSeqPaciente))
			return false;
		return true;
	}
	
}
