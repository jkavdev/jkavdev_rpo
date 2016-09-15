package br.com.jkavdev.book.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

public class JpaUtil {

	private static final Logger logger = Logger.getLogger(JpaUtil.class);
	private static final String PERSISTENCE_UNIT = "jpaPostgresPU";
	private static EntityManagerFactory factory;
	
	// alocara um entityManager a uma thread
	private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<>();

	private JpaUtil() {
	}

	public static EntityManager geEntityManager() {
		// cria fabrica se estiver nula
		if (factory == null) {
			logger.info("Criando Factory....................");
			
			/* Com esse comando, a JPA
			procurará pelo arquivo persistence.xml, e fará a leitura das entidades mapeadas,
			validação de conexão com o banco de dados e, caso configurado, a JPA
			também poderá validar se o schema do banco de dados está correto, criar tabelas,
			criar sequences etc. */
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}

		// pega o entityManager da thread
		EntityManager entityManager = threadEntityManager.get();

		// se o entityManager estiver nulo ou nao estiver aberto
		// criou um entityManager e atribuo a thread
		if (entityManager == null || !entityManager.isOpen()) {
			logger.info("Criando EntityManager....................");
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

			logger.info("Fechando EntityManager....................");
			
			entityManager.close();

			// desanexo o entityManager da thread
			threadEntityManager.set(null);
		}
	}

}
