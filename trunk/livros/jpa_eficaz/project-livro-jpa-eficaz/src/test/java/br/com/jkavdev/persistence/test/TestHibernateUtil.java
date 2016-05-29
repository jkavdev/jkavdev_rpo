package br.com.jkavdev.persistence.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.jkavdev.persistence.model.Estacionamento;

public class TestHibernateUtil {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaPostgresPU");
	private EntityManager manager = factory.createEntityManager();

//	@Before
//	public void setUp() {
//		this.manager = JpaUtil.geEntityManager();
//	}
//
//	@After
//	public void tearDown() {
//		JpaUtil.close();
//	}

	@Test
	public void testInsertEntityManager() {
		
		Estacionamento estacionamento = new Estacionamento();
		
		this.manager.getTransaction().begin();
		this.manager.persist(estacionamento);
		this.manager.getTransaction().commit();
	}

}
