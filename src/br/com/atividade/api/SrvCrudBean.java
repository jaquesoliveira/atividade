package br.com.atividade.api;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.atividade.util.JPAResourceBean;

/**
 * @author jqs-developer
 *
 * @param <T>
 */
public class SrvCrudBean <T extends GenericEntity<Long>> implements SrvCrud<T>{	
	
	private EntityManager entityManager = JPAResourceBean.getEntityManager();
	
	private DAOPadraoGenericoBean<T> getDao(){
		//DAOPadraoGenericoBean<T> dao = new DAOPadraoGenericoBean<T>(entityManager)
		return new DAOPadraoGenericoBean<T>(entityManager);
	}
	
	public SrvCrudBean() {
		//
	}
	
	public void inserir(T object) {		
		getDao().inserir(object);
	}
	
	public T alterar(T object) {
		return getDao().alterar(object);
	}
	
	public void excluir(T object) {
		getDao().excluir(object);
	}

	public List<T> listarTodos(T object) throws NoSuchFieldException, IllegalAccessException{
		return getDao().listarTodos(object);
	}
	
	public T recuperar(Class<?> clazz, Long sequencial) throws Exception {
		return getDao().recuperar(clazz, sequencial);	
	}
}
