package br.com.jkavdev.book.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.Test;

public class ConnectionTest {

	private static final Logger logger = Logger.getLogger(ConnectionTest.class);

	@Test
	public void connectionDatabaseTest() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager entityManager = factory.createEntityManager();

		logger.info("Conectou..............");

		entityManager.close();
		factory.close();
	}

}
