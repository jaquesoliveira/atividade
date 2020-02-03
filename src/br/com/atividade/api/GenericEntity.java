package br.com.atividade.api;

import java.io.Serializable;

/**
 * @author Jaques Oliveira
 *
 * @param <ID>
 */
public interface GenericEntity<ID> extends Serializable {
    
    /**
     * @return
     */
    public ID getNumSequencial();    
    
    /**
     * @param id
     */
    public void setNumSequencial(ID numSequencial);
    
}