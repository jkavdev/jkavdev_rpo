package br.com.jkavdev.k19.jpa_hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

public class AbstractJUnitConfig {

	private EntityManagerFactory factory;
	private EntityManager manager;

	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("k21PU");
		manager = factory.createEntityManager();
	}

	@After
	public void clean() {
		manager.close();
		factory.close();
	}

	public void commit() {
		manager.getTransaction().commit();
	}

	public void beginTransaction() {
		manager.getTransaction().begin();
	}
	
	public EntityManagerFactory getFactory() {
		return factory;
	}
	
	public EntityManager getManager() {
		return manager;
	}

}