package br.com.atividade.api;

import java.util.List;



public class FacCrudBean <T extends GenericEntity<Long>> implements FacCrud<T>{	
	
	private SrvCrud<T> srvCrud;
	
	public void inserir(T object) {	
		srvCrud.inserir(object);
	}

	
	public T alterar(T object) {		
		return null;
	}

	
	public void excluir(T object) {
				
	}

	
	public List<T> listarTodos() {
		
		return null;
	}


	public List<T> listarTodos(T object) throws NoSuchFieldException, IllegalAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	public T recuperar(Class<?> clazz, Long sequencial) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
