package br.com.jkavdev.persistence.test;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.persistence.util.jpa.JpaUtil;

public class TestHibernateUtil {

	// private EntityManagerFactory factory =
	// Persistence.createEntityManagerFactory("jpaPostgresPU");
	private EntityManager manager;

	@Before
	public void setUp() {
		this.manager = JpaUtil.geEntityManager();
	}

	@After
	public void tearDown() {
		JpaUtil.close();
	}

	@Test
	public void testInsertEntityManager() {

		// Estacionamento estacionamento = new Estacionamento();

		this.manager.getTransaction().begin();
		// this.manager.persist(estacionamento);
		this.manager.getTransaction().commit();
	}

	@Test
	public void testInsertEntityManagerTry() {

		// Estacionamento estacionamento = new Estacionamento();
		try {
			this.manager.getTransaction().begin();
			// this.manager.persist(estacionamento);
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			if (this.manager.isOpen()) {
				this.manager.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (this.manager.isOpen()) {
				this.manager.close();
			}
		}
	}

	@Test
	public void testEntityDetais() {
		this.manager.getTransaction().begin();
		this.manager.getTransaction().commit();
	}

}
