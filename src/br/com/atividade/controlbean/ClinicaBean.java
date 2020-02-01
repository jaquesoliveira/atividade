package br.com.atividade.controlbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.atividade.model.BtpClinica;

public class ClinicaBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<BtpClinica> lstClinica;
	
	private boolean ctrlTelaConsultar;
	private boolean ctrlTelaCadastrar;
	private boolean ctrlTelaVisualizar;
	private boolean ctrlTelaAlterar;
	
	
	public ClinicaBean() {		
		lstClinica = new ArrayList<BtpClinica>();
		ctrlTelaConsultar = true;
	}	
	
	public List<BtpClinica> getLstClinica(){
		
		lstClinica.clear();
		
		lstClinica.add(new BtpClinica(1L, "HapClinica Dom Manoel"));
		
		lstClinica.add(new BtpClinica(2L, "Clinica Unimed Rodrigues Jr."));

		lstClinica.add(new BtpClinica(3L, "Clinica Amil"));
		
		lstClinica.add(new BtpClinica(4L, "Poli Clinica"));
		return lstClinica;		
	}
	
	public void cadastrarClinica() {
		resetControlesDeTela();
		ctrlTelaCadastrar = true;
	}

	public boolean isCtrlTelaConsultar() {
		return ctrlTelaConsultar;
	}

	public boolean isCtrlTelaCadastrar() {
		return ctrlTelaCadastrar;
	}
	public boolean isCtrlTelaVisualizar() {
		return ctrlTelaVisualizar;
	}	

	public boolean isCtrlTelaAlterar() {
		return ctrlTelaAlterar;
	}
	
	private void resetControlesDeTela() {
		ctrlTelaConsultar = false;
		ctrlTelaCadastrar = false;
		ctrlTelaVisualizar = false;
		ctrlTelaAlterar = false;
	}
}