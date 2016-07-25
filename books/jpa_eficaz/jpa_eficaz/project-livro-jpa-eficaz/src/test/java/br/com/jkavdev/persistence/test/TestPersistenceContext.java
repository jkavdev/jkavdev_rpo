package br.com.jkavdev.persistence.test;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.persistence.model.Address;
import br.com.jkavdev.persistence.model.Employee;
import br.com.jkavdev.persistence.util.jpa.JpaUtil;

public class TestPersistenceContext {

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
	public void getInsert() {

		Address address = new Address();
		address.setCity("Planaltina");

		Employee employee = new Employee();
		employee.setNome("Jhonatan");
		employee.setAddress(address);

		this.manager.getTransaction().begin();
		this.manager.persist(employee);
		this.manager.getTransaction().commit();

	}

	@Test
	public void getReference() {

		this.manager.getTransaction().begin();

		//entidade desconhecida pelo Persistence Context
		Address address = new Address();
		address.setId(8L);
		address.setCountry("Brazil");
		address.setRegion("Centro-Oeste");

		//entidade conhecida pelo Persistence Context
		Employee employee = this.manager.find(Employee.class, 7L);

		// Erro, pois estamos passando uma entidade desanexada 
		// do Persistence Context
		employee.setAddress(address);
		
//		this.manager.merge(employee);

		this.manager.getTransaction().commit();

	}

	@Test
	public void detached(){
		this.manager.getTransaction().begin();
		Employee employee = this.manager.getReference(Employee.class, 7L);
		
		System.out.println(employee.getNome());
		this.manager.getTransaction().commit();
		this.manager.close();
		
		//entidade detached
		System.out.println(employee.getAddress().getCountry());
	}
	
}
