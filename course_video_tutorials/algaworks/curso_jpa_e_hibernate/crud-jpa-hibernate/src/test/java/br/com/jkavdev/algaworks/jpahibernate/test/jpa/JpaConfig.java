package br.com.jkavdev.algaworks.jpahibernate.test.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public class JpaConfig {

	private static EntityManagerFactory factory;
	private EntityManager manager;

	// será executado apenas uma vez antes da classe
	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("jpaPU");
	}

	// será sempre executado antes de um @Test
	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}

	// será sempre executado depois de um @Test
	@After
	public void tearDown() {
		this.manager.close();
	}

	public void beginTransaction() {
		this.getManager().getTransaction().begin();
	}

	public void commit() {
		this.getManager().getTransaction().commit();
	}

	public EntityManagerFactory getFactory() {
		return factory;
	}

	public EntityManager getManager() {
		return manager;
	}

}
