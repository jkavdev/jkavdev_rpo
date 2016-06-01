package br.com.jkavdev.persistence.model;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.persistence.util.jpa.JpaUtil;

public class TestMapping {
	
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
	public void insertOneTone(){
		Employee employee = new Employee();
		employee.setNome("Jhonatan");
		
		Address address = new Address();
		address.setCity("Planaltina");
		address.setStreet("Qr 12 casa 15");
		address.setState("Goiais");
		address.setZipCode("73754012");
		
		employee.setAddress(address);
		
		this.manager.getTransaction().begin();
		this.manager.persist(address);
		this.manager.persist(employee);
		this.manager.getTransaction().commit();
	}

}
