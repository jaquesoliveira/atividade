package br.com.atividade.api;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;

/**
 * @author jqs-developer
 *
 * @param <T>
 */
// @Stateless
public class DAOPadraoGenericoBean<T> implements DAOPadrao<T> {

	private EntityManager entityManager;

	public void inserir(T object) {
		
		entityManager.setFlushMode(FlushModeType.COMMIT);

		try {
			entityManager.getTransaction().begin();
			
			if(!entityManager.contains(object)) {				
				entityManager.persist(object);	
				entityManager.flush();
			}
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public T alterar(T object) {
		try {
			return entityManager.merge(object);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return null;
	}

	public void excluir(T object) {
		
		
		entityManager.setFlushMode(FlushModeType.COMMIT);

		try {
			entityManager.getTransaction().begin();
			
			if(!entityManager.contains(object)) {				
				entityManager.remove(object);	
				entityManager.flush();
			}
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}		
	}	
	
	public List<T> listarTodos(T entidade) throws NoSuchFieldException, IllegalAccessException {

		if (entidade == null) {
			return null;
		}

		Field[] campos = entidade.getClass().getDeclaredFields();
		Map<String, Object> parameters = new HashMap<String, Object>();

		// recebe nome canônico da classe
		final String tableName = entidade.getClass().getCanonicalName();

		// monta a query básica inicial
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT btp FROM " + tableName + " btp");

		boolean where = false;
		StringBuilder order = new StringBuilder();
		boolean ordenado = false;

		for (Field field : campos) {

			if (!field.getName().equals("serialVersionUID")) {

				if (getObjectFieldValue(entidade, field.getName()) != null) {
					if (!where) {
						sql.append(" WHERE ");
						where = true;
					}
					else {
						sql.append(" AND ");
					}

					if (getObjectFieldValue(entidade, field.getName()).getClass().equals(Long.class)) {
						sql.append("btp." + field.getName() + " =:" + field.getName());						
					}
					else {
						sql.append("btp." + field.getName() + " LIKE :" + field.getName());
					}
					parameters.put(field.getName().toString(), getObjectFieldValue(entidade, field.getName()));
					
					if(!ordenado ) {
						order.append(" ORDER BY " + field.getName() + " DESC ");
						ordenado = true;
					}
				}
			}
		}
		
		sql.append(order);
		
		System.out.println(sql);

		// seta parâmetros não nulos
		Query query = entityManager.createQuery(sql.toString());
		for (Map.Entry<String, Object> pair : parameters.entrySet()) {

			if (pair.getValue().getClass().equals(Long.class)) {
				query.setParameter(pair.getKey(), pair.getValue());
			}
			else {
				//System.out.println(pair.getValue().toString().toLowerCase())
				query.setParameter(pair.getKey(), "%" + pair.getValue() + "%");
			}
		}
		return query.getResultList();
	}

	/**
	 * recebe o valor dos campos do objeto
	 * 
	 * @param obj
	 * @param fieldName
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	private Object getObjectFieldValue(Object obj, String fieldName)
			throws NoSuchFieldException, IllegalAccessException {

		Class<? extends Object> c = obj.getClass();
		Field field = c.getDeclaredField(fieldName);
		field.setAccessible(true);		

		return field.get(obj);
	}
	
	public T recuperar(Class<?> clazz, Long sequencial) throws Exception {

		if (sequencial == null) {
			throw new Exception("Impossível recuperar o objeto! Sequencial nulo!!!");
		}

		return (T) entityManager.find(clazz, sequencial);
	}

	public DAOPadraoGenericoBean() {

	}

	public DAOPadraoGenericoBean(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}