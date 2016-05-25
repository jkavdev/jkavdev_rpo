package br.com.jkavdev.primefaces.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.jkavdev.primefaces.model.Aluno;

public class LogTest {

	private Log log = LogFactory.getLog(LogTest.class);
	private static EntityManagerFactory factory;
	private EntityManager manager;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("algaworksPU");
	}

	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}

	@After
	public void tearDown() {
		this.manager.close();
	}

	@Test
	public void testLog() {
		log.info("Testing Info Message.");
		if (log.isDebugEnabled()) {
			log.debug("Testing Debug Message.");
		}
	}

	@Test
	public void testHibernateLog() {
		Aluno aluno = new Aluno();
		aluno.setNome("Jhonatan");

		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();
	}

}
