package br.com.jkavdev.hibernate.database.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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

	public static EntityManager getEntityManager() {
		EntityManager entityManager = threadEntityManager.get();

		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = factory.createEntityManager();
			threadEntityManager.set(entityManager);
		}

		return entityManager;
	}

	public static void closeEntityManager() {
		EntityManager entityManager = threadEntityManager.get();
		threadEntityManager.set(null);

		if (entityManager != null && entityManager.isOpen()) {
			EntityTransaction transaction = entityManager.getTransaction();

			if (transaction.isActive()) {
				transaction.commit();
			}

			entityManager.flush();
			entityManager.close();

		}
	}

}
