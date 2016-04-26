package br.com.jkavdev.tests.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.jkavdev.mysql.world.entities.City;
import br.com.jkavdev.mysql.world.entities.Country;

public class TesteInsereCity {

//	private final Logger logger = Logger.getLogger(this.getClass());

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("worldPU");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		Country country = new Country();
		country.setName("Brazil");
		country.setPopulation(555554);

		City city = new City();
		city.setName("Brasilia");
		city.setPopulation(155542);
		city.setCountryCode(country);

		manager.persist(country);
		manager.persist(city);
		
		System.out.println(country);
		System.out.println(city);

		transaction.commit();
		manager.close();
		factory.close();

	}

}
