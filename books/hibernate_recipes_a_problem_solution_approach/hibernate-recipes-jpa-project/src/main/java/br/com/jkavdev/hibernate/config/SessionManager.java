package br.com.jkavdev.hibernate.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionManager {

	public static EntityManager geEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("booksPU");
		EntityManager manager = factory.createEntityManager();

		return manager;
	}

}
