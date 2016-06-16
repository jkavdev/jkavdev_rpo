package br.com.jkavdev.hibernate.database.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.Test;

public class ManageDatabaseTest {

	private final Logger logger = Logger.getLogger(this.getClass());
	EntityManagerFactory factory;
	EntityManager manager;

	@Test
	public void createTables() {
		logger.info("Creating Tables....");
		this.factory = Persistence.createEntityManagerFactory("hibernatePU");
		this.manager = this.factory.createEntityManager();

		manager.close();
		factory.close();
	}

	@Test
	public void dropTables() {
		logger.info("Droping Tables....");

	}

}
