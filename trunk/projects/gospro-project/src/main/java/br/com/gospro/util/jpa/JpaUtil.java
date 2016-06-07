package br.com.gospro.util.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final String PERSISTENCE_UNIT = "jpaMysqlPU";
	private static EntityManagerFactory factory;
	private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<>();

	public static EntityManager geEntityManager() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}

		EntityManager entityManager = threadEntityManager.get();

		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = factory.createEntityManager();
			JpaUtil.threadEntityManager.set(entityManager);
		}

		return entityManager;
	}

	public static void close() {
		EntityManager entityManager = threadEntityManager.get();

		if (entityManager != null) {
			EntityTransaction transaction = entityManager.getTransaction();

			if (transaction.isActive()) {
				transaction.commit();
			}

			entityManager.close();
			threadEntityManager.set(null);
		}
	}

}
