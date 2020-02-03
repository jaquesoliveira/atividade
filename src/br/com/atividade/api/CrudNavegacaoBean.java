package br.com.atividade.api;

public class CrudNavegacaoBean implements CrudNavegacao{

	private Boolean pesquisar, incluir, editar, visualizar;
	
	public CrudNavegacaoBean() {
		
	}
	
	/**
	 * Controle de navegação entre as telas do crud
	 * 
	 * @author Jaques Oliveira 22/09/2018.
	 * 	
	 * @param destino
	 */	
	public void navegar(EnumNavegacao destino) {
		if(destino.equals(EnumNavegacao.PESQUISAR)) {
			setPesquisar(true);
		}

		if(destino.equals(EnumNavegacao.INSERIR)) {			
			setIncluir(true);	
		}

		if(destino.equals(EnumNavegacao.EDITAR)) {
			setEditar(true);
		}

		if(destino.equals(EnumNavegacao.VISUALIZAR)) {
			setVisualizar(true);
		}
	}	
	
	public void inserir() {
		navegar(EnumNavegacao.INSERIR);
	}
	
	public void pesquisar() {
		navegar(EnumNavegacao.PESQUISAR);
	}	
	
	public Boolean getPesquisar() {
		return pesquisar;
	}

	public void setPesquisar(Boolean pesquisar) {
		this.pesquisar = pesquisar;

		incluir = false;
		editar = false;
		visualizar = false;
	}

	public Boolean getIncluir() {
		return incluir;
	}

	public void setIncluir(Boolean incluir) {
		this.incluir = incluir;

		pesquisar = false;
		editar = false;
		visualizar = false;
	}

	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;

		pesquisar = false;
		incluir = false;
		visualizar = false;
	}

	public Boolean getVisualizar() {
		return visualizar;
	}

	public void setVisualizar(Boolean visualizar) {
		this.visualizar = visualizar;

		pesquisar = false;
		incluir = false;
		editar = false;
	}	
}
