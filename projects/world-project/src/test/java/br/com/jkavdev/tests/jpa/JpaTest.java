package br.com.jkavdev.tests.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.hibernate.id.SequenceGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

		logger.info("Conectado");
	}
	
	@Test
	public void insertCountry(){
		Country brazil = new Country();
		brazil.setName("Brazil");
		brazil.setPopulation(555554);
		brazil.setCapital(1);
		brazil.setCode("555");
		brazil.setCode2("55");
		brazil.setContinent(Continent.SOUTHAMERICA);
		brazil.setGNP(52f);
		brazil.setGNPOId(51f);
		brazil.setGovernmentForm("Estadual");
		brazil.setHeadOfState("Governadores");
		brazil.setIndepYear(1500);
		brazil.setLifeExpectancy(88f);
		brazil.setLocalName("Nao sei");
		brazil.setRegion("Sul");
		brazil.setSurfaceArea(1555545f);
		
		this.manager.merge(brazil);
	}

}
