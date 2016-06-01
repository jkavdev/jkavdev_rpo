package br.com.jkavdev.persistence.test;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.persistence.model.inherite.Bike;
import br.com.jkavdev.persistence.model.inherite.Car;
import br.com.jkavdev.persistence.model.inherite.HumanResources;
import br.com.jkavdev.persistence.model.inherite.JuridicalPerson;
import br.com.jkavdev.persistence.model.inherite.NaturalPerson;
import br.com.jkavdev.persistence.model.inherite.PessoaFisica;
import br.com.jkavdev.persistence.model.inherite.PessoaJuridica;
import br.com.jkavdev.persistence.model.inherite.Truck;
import br.com.jkavdev.persistence.util.jpa.JpaUtil;

public class TestInherite {

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
	public void insertMappedSuperClass() {
		HumanResources resources = new HumanResources();
		resources.setNome("Resources");

		this.manager.getTransaction().begin();
		this.manager.persist(resources);
		this.manager.getTransaction().commit();

	}

	@Test
	public void insertSingleTable() {
		JuridicalPerson juridicalPerson = new JuridicalPerson();
		juridicalPerson.setCnpj("321215645");
		juridicalPerson.setNome("INSS");

		NaturalPerson naturalPerson = new NaturalPerson();
		naturalPerson.setCpf("04488289100");
		naturalPerson.setNome("Jhonatan");

		this.manager.getTransaction().begin();
		this.manager.persist(naturalPerson);
		this.manager.persist(juridicalPerson);
		this.manager.getTransaction().commit();

	}

	@Test
	public void insertJoinedTable() {
		PessoaJuridica juridicalPerson = new PessoaJuridica();
		juridicalPerson.setCnpj("321215645");
		juridicalPerson.setNome("INSS");

		PessoaFisica naturalPerson = new PessoaFisica();
		naturalPerson.setCpf("04488289100");
		naturalPerson.setNome("Jhonatan");

		this.manager.getTransaction().begin();
		this.manager.persist(naturalPerson);
		this.manager.persist(juridicalPerson);
		this.manager.getTransaction().commit();
	}
	
	@Test
	public void insertPerClassTable(){
		Bike bike = new Bike();
		bike.setManufaturer("Hyundai");
		bike.setNoOfPassangers(1);
		bike.setSaddleHeight(180);
		bike.setVehicleType("Bicycle");
		
		Truck truck = new Truck();
		truck.setLoadCapacity(2665);
		truck.setManufaturer("Honda");
		truck.setNoOfContainers(5);
		truck.setVehicleType("Heavy");
		
		Car car = new Car();
		car.setManufaturer("Volks");
		car.setNoOfDoors(4);
		car.setNoOfPassangers(8);
		car.setVehicleType("Transporte");
		
		this.manager.getTransaction().begin();
		this.manager.persist(truck);
		this.manager.persist(car);
		this.manager.persist(bike);
		this.manager.getTransaction().commit();
	}

}
