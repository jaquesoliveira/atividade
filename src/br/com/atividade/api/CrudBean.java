package br.com.atividade.api;

import java.util.List;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 * @author jqs-developer
 *
 * @param <T>
 */
@SuppressWarnings("hiding")
public class CrudBean<Entity extends GenericEntity<Long>> extends CrudNavegacaoBean implements Crud<Entity>, ActionListener{

	private Entity entidade;
	private Entity entidadeSelecionada;

	private String nomeCanonico;

	SrvCrud<Entity> srvCrud = new SrvCrudBean<Entity>();

	/**
	 * Construtor
	 */
	public CrudBean() {
		initi();
	}
	
	private void initi() {
		navegar(EnumNavegacao.PESQUISAR);
	}

	public void salvar(ActionEvent event) {		
		try {
			if(srvCrud != null) {
				srvCrud.inserir(entidade);
				navegar(EnumNavegacao.VISUALIZAR);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			prepararEntidade();
		}
	}

	/**
	 * Prepara entinadade para salvar novamente
	 * 
	 * @author Jaques Oliveira
	 * 
	 * @param entidade
	 */
	@SuppressWarnings("unchecked")
	private void prepararEntidade() {
		try {
			this.entidade = (Entity) Class.forName(nomeCanonico).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	
	private void prepararEntidadeSelecionada() {
		try {
			this.entidadeSelecionada = (Entity) Class.forName(nomeCanonico).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	

	public void getNomeClass() {

	}

	
	public void excluir(ActionEvent event) {
		srvCrud.excluir(entidadeSelecionada);
	}

	
	public Entity alterar(ActionEvent event) {
				
		Entity ent = srvCrud.alterar(entidadeSelecionada); 
		
		prepararEntidade();
		prepararEntidadeSelecionada();
		
		return ent; 
	}
	
	public void prepararaLteracao(){
		try {
			entidade = srvCrud.recuperar(entidadeSelecionada.getClass(), entidadeSelecionada.getNumSequencial());
		} catch (Exception e) {
			e.printStackTrace();
			prepararEntidade();
		}
		navegar(EnumNavegacao.EDITAR);
	}

	
	public List<Entity> consultar(ActionEvent event) {
		
		if(srvCrud != null) {
			try {
				return srvCrud.listarTodos(entidade);
			} catch (NoSuchFieldException e) {				
				e.printStackTrace();
			} catch (IllegalAccessException e) {				
				e.printStackTrace();
			}
			//navegar(EnumNavegacao.VISUALIZAR)
		}
		return null;
	}	

	public void setEntidade(Entity entidade) {
		this.entidade = entidade;
		nomeCanonico = entidade.getClass().getCanonicalName();
	}

	public Entity getEntidade() {
		return this.entidade;
	}

	public void processAction(ActionEvent arg0) throws AbortProcessingException {
		//
	}

	public Entity getEntidadeSelecionada() {
		return entidadeSelecionada;
	}

	public void setEntidadeSelecionada(Entity entidadeSelecionada) {
		this.entidadeSelecionada = entidadeSelecionada;
	}
	
	
}
