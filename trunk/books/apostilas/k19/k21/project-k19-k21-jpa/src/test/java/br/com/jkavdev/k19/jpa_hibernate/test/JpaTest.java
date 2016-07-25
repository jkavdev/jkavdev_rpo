package br.com.jkavdev.k19.jpa_hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

public class JpaTest {
	
	private EntityManagerFactory factory;
	private EntityManager manager;
	
	@Before
	public void init(){
		factory = Persistence.createEntityManagerFactory("k21PU");
		manager = factory.createEntityManager();
	}
	
	@Test
	public void geraTabelas(){
		
		manager.close();
		factory.close();
	}

}
