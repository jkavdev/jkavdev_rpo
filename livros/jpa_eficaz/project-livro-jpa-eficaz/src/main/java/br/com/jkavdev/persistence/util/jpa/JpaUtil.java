package br.com.jkavdev.persistence.util.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final String PERSISTENCE_UNIT = "jpaPostgresPU";
	private static EntityManagerFactory factory;
	// alocara um entityManager a uma thread
	private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<>();

	private JpaUtil() {
	}

	public static EntityManager geEntityManager() {
		// cria fabrica se estiver nula
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}

		// pega o entityManager da thread
		EntityManager entityManager = threadEntityManager.get();

		// se o entityManager estiver nulo ou nao estiver aberto
		// criou um entityManager e atribuo a thread
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = factory.createEntityManager();
			JpaUtil.threadEntityManager.set(entityManager);
		}

		return entityManager;
	}

	public static void close() {
		// pego entityManager da thread
		EntityManager entityManager = threadEntityManager.get();

		// caso esteja com dados
		if (entityManager != null) {
			// pego a transacao
			EntityTransaction transaction = entityManager.getTransaction();

			// commit a transacao em aberto
			if (transaction.isActive()) {
				transaction.commit();
			}

			entityManager.close();

			// desanexo o entityManager da thread
			threadEntityManager.set(null);
		}
	}

}
