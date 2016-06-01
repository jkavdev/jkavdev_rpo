package br.com.jkavdev.persistence.test;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.persistence.model.Address;
import br.com.jkavdev.persistence.model.Employee;
import br.com.jkavdev.persistence.model.manytomany.Role;
import br.com.jkavdev.persistence.model.manytomany.RoleType;
import br.com.jkavdev.persistence.model.manytomany.User;
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
	public void insertOneTone() {
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

	@Test
	public void insertManyToMany() {
		User user = new User();
		user.setPassword("73754012");
		user.setUsername("jhonatan.nice");

		Role admin = new Role();
		admin.setType(RoleType.ADMIN);

		Role manager = new Role();
		manager.setType(RoleType.MANAGER);

		Role ruser = new Role();
		ruser.setType(RoleType.USER);

		user.addRole(ruser);
		user.addRole(manager);

		this.manager.getTransaction().begin();
		this.manager.persist(ruser);
		this.manager.persist(admin);
		this.manager.persist(manager);
		this.manager.persist(user);
		this.manager.getTransaction().commit();
	}

}
