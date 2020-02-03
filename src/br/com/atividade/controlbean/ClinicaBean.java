package br.com.atividade.controlbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import br.com.atividade.api.CrudBean;
import br.com.atividade.model.BtpClinica;

public class ClinicaBean extends CrudBean<BtpClinica> implements Serializable{	

	private static final long serialVersionUID = 1L;
	
	private List<BtpClinica> lstClinica;
	private BtpClinica btpClinica;
	
	
	public ClinicaBean() {
		super();
		btpClinica = new BtpClinica();
		//lstClinica = new ArrayList<BtpClinica>()		
	}

	@PostConstruct
	private void init() {
		setEntidade(btpClinica);
		lstClinica = consultar(null);
	}
	
	public List<BtpClinica> getLstClinica(){
		return lstClinica;		
	}

	public BtpClinica getBtpClinica() {
		return btpClinica;
	}

	public void setBtpClinica(BtpClinica btpClinica) {
		this.btpClinica = btpClinica;
	}
	
	@Override
	public void salvar(ActionEvent event) {
		
		super.salvar(event);
		
		btpClinica = new BtpClinica();
	}
	
	@Override
	public List<BtpClinica> consultar(ActionEvent event) {
		
		lstClinica = super.consultar(event);
		return lstClinica;
		
	}	
	
}