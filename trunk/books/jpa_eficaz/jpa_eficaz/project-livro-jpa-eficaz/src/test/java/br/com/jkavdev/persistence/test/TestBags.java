package br.com.jkavdev.persistence.test;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.persistence.model.bags.Car;
import br.com.jkavdev.persistence.model.bags.Dog;
import br.com.jkavdev.persistence.model.bags.User;
import br.com.jkavdev.persistence.util.jpa.JpaUtil;

public class TestBags {

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
	public void insertRegisters() {
		User user = new User();
		user.setName("Jhonatan");
		user.setPassword("123456");

		user.getEmails().add("jhonatankolen@gmail.com");
		user.getEmails().add("jhonatan.viana@foton.la");
		user.getEmails().add("jhonatankolen1@gmail.com");

		user.getFones().add("99220468");
		user.getFones().add("99346554");

		this.manager.getTransaction().begin();
		this.manager.persist(user);
		this.manager.getTransaction().commit();

		User user2 = this.manager.find(User.class, 3L);

		List<String> emails = user2.getEmails();

		for (String email : emails) {
			System.out.println(email);
		}

	}

	@Test
	public void inserUsers() {
		User user = new User();
		user.setName("Jhonatan");
		user.setPassword("123456");

		Dog dog = new Dog();
		dog.setPetName("Negona");
		dog.setRace("Hot-Dog");

		Car car = new Car();
		car.setColor("White");
		car.setModel("Ferrari");

		user.getDogs().add(dog);
		user.getCars().add(car);

		this.manager.getTransaction().begin();
		this.manager.persist(user);

		User user2 = this.manager.find(User.class, 4L);

		List<Dog> dogs = user.getDogs();
		for (Dog dog2 : dogs) {
			System.out.println(dog2.getPetName());
			dog2.setPetName("Shester");
		}

		List<String> emails = user2.getEmails();

		for (String email : emails) {
			System.out.println(email);
		}

		this.manager.getTransaction().commit();

	}

}
