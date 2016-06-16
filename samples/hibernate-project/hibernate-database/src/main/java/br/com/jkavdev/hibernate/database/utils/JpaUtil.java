package br.com.jkavdev.hibernate.database.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final String PERSISTENCE_UNIT = "hibernatePU";
	private static EntityManagerFactory factory;
	private static final ThreadLocal<EntityManager> threadEntityManager;

	static {
		threadEntityManager = new ThreadLocal<>();

		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}
	}

	public static EntityManager geEntityManager() {
		EntityManager entityManager = threadEntityManager.get();

		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = factory.createEntityManager();
			threadEntityManager.set(entityManager);
		}

		return entityManager;
	}

}
