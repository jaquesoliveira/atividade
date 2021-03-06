package br.com.atividade.util;

import javax.persistence.EntityManager;  
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAResourceBean {
	
	private static EntityManagerFactory emFactory;

	private static EntityManagerFactory getEMF() {
		if (emFactory == null) {
			emFactory = Persistence.createEntityManagerFactory("medpoint");
		}
		return emFactory;
	}

	public static EntityManager getEntityManager() {
		return getEMF().createEntityManager();
	}
}
