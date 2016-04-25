package br.com.jkavdev.tests.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.jkavdev.mysql.world.entities.City;
import br.com.jkavdev.mysql.world.entities.Continent;
import br.com.jkavdev.mysql.world.entities.Country;

public class JpaTest {

	private final Logger logger = Logger.getLogger(this.getClass());
	private static EntityManagerFactory factory;
	private EntityManager manager;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("worldPU");
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
	public void conecta() {
		this.manager = factory.createEntityManager();

		logger.warn("Conectado");
	}
	
	@Test
	public void insertCity(){
		City city = new City();
		city.setName("Brasilia");
		city.setPopulation(15425);
		city.setDestrict("Cidade");
		
		Country country = new Country();
		country.setName("Brasil");
		country.setContinent(Continent.SOUTHAMERICA);
		
		city.setCountry(country);
		
		this.manager.getTransaction().begin();
		this.manager.persist(country);
		this.manager.persist(city);
		
		city = new City();
		city.setName("Goias");
		city.setPopulation(15425);
		city.setDestrict("Cidade");
		city.setCountry(country);
		
		this.manager.persist(city);
		this.manager.getTransaction().commit();
		
		
	}

}
