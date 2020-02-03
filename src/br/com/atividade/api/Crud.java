package br.com.atividade.api;

import java.util.List;

import javax.faces.event.ActionEvent;

/**
 * @author jqs-developer
 *
 * @param <T>
 */

public interface Crud <T extends GenericEntity<Long>> {
	
	/**
	 * Salva objeno no banco de dados
	 * @param event
	 */
	void salvar(ActionEvent event);
	
	/**
	 * @param event
	 */
	void excluir(ActionEvent event);
	
	/**
	 * @param event
	 * @return
	 */
	T alterar(ActionEvent event);
	
	/**
	 * @param event
	 * @return
	 */
	List<T> consultar(ActionEvent event);
	
	
}