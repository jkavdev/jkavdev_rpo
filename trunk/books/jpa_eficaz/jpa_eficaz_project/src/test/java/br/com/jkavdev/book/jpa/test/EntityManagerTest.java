package br.com.jkavdev.book.jpa.test;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.jkavdev.book.jpa.util.JpaUtil;

public class EntityManagerTest {

	private static final Logger logger = Logger.getLogger(EntityManagerTest.class);
	private EntityManager entityManager = JpaUtil.geEntityManager();

	@Test
	public void trasactionLocal() {

		try {
			entityManager.getTransaction().begin();

			logger.info("Realizando algo, com a transacao aberta...........................");

			entityManager.getTransaction().commit();

			// caso ocorra algum erro a transacao será fechada
		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
			
			//finalmente fechando o entityManager
		} finally {
			JpaUtil.close();
		}

	}

}
