package br.com.jkavdev.tests.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.jkavdev.mysql.world.entities.Continent;
import br.com.jkavdev.mysql.world.entities.Country;

public class TesteInsereCity {

//	private final Logger logger = Logger.getLogger(this.getClass());

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("worldPU");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		Country brazil = new Country();
		brazil.setName("Brazil");
		brazil.setPopulation(555554);
		brazil.setCapital(1);
		brazil.setId("55");
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
		
//		Country mexico = new Country();
//		mexico.setName("Mexico");
//		mexico.setPopulation(555554);
//		mexico.setCapital(1);
//		mexico.setId("223");
//		mexico.setCode2("55");
//		mexico.setContinent(Continent.SOUTHAMERICA);
//		mexico.setGNP(52f);
//		mexico.setGNPOId(51f);
//		mexico.setGovernmentForm("Estadual");
//		mexico.setHeadOfState("Governadores");
//		mexico.setIndepYear(1500);
//		mexico.setLifeExpectancy(88f);
//		mexico.setLocalName("Nao sei");
//		mexico.setRegion("Sul");
//		mexico.setSurfaceArea(1555545f);

//		City brasilia = new City();
//		brasilia.setName("Brasilia");
//		brasilia.setPopulation(155542);
//		brasilia.setDestrict("centro-oeste");
//		brasilia.setCountry(brazil);
		
//		City goiais = new City();
//		goiais.setName("Goiais");
//		goiais.setPopulation(155542);
//		goiais.setDestrict("centro-oeste");
//		goiais.setCountry(mexico);
		
//		manager.persist(mexico);
		manager.persist(brazil);
//		manager.persist(brasilia);
//		manager.persist(goiais);

		transaction.commit();
		manager.close();
		factory.close();

	}

}
