package br.com.atividade.api;

import java.util.List;

/**
 * @author jaques oliveira - 15/08/2018 17:51
 *
 * @param <T>
 */
public interface DAOPadrao<T> {
	
	/**
	 * Inseri objeto genérico
	 * @param object
	 */
	void inserir(T object);
	
	/**
	 * @param object
	 * @return
	 */
	T alterar(T object);	
	
	/**
	 * @param object
	 */
	void excluir(T object);
	
	/**
	 * @return
	 */
	List<T> listarTodos(T object) throws NoSuchFieldException, IllegalAccessException;
	
	/**
	 * @param clazz
	 * @param sequencial
	 * @return
	 * @throws Exception
	 */
	T recuperar(Class<?> clazz, Long sequencial) throws Exception;
	
}
