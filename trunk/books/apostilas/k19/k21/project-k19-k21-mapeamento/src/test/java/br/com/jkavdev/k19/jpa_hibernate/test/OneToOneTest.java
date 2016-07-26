package br.com.jkavdev.k19.jpa_hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Estado;
import br.com.jkavdev.k19.jpa_hibernate.model.Governador;

public class OneToOneTest {

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
	
	@Test
	public void insertEstado(){
		
		Estado estado = new Estado();
		Governador governador = new Governador();
		
		estado.setGovernador(governador);
		
		beginTransaction();
		
		manager.persist(governador);
		manager.persist(estado);
		
		commit();
		
	}

	public void commit() {
		manager.getTransaction().commit();
	}

	public void beginTransaction() {
		manager.getTransaction().begin();
	}

}
