package br.com.jkavdev.book.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.Test;

public class ConnectionTest {

	private static final Logger logger = Logger.getLogger(ConnectionTest.class);

	@Test
	public void connectionDatabaseTestMysql() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaMysqlPU");
		EntityManager entityManager = factory.createEntityManager();

		logger.info("Conectou ao Mysql..............");

		entityManager.close();
		factory.close();
	}
	
	@Test
	public void connectionDatabaseTestPostgres() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaPostgresPU");
		EntityManager entityManager = factory.createEntityManager();

		logger.info("Conectando ao Postgres..............");

		entityManager.close();
		factory.close();
	}

}
