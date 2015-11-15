package com.algaworks.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory;

	public static EntityManager getEntityManager() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("agenda_pu");
		}
		return factory.createEntityManager();
	}

}
