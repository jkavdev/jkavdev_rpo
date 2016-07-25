package br.com.jkavdev.persistence.test;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.persistence.model.embedded.Address;
import br.com.jkavdev.persistence.model.embedded.PapelUsuario;
import br.com.jkavdev.persistence.model.embedded.PerfilUsuario;
import br.com.jkavdev.persistence.model.embedded.Person;
import br.com.jkavdev.persistence.model.embedded.StatusCompra;
import br.com.jkavdev.persistence.model.embedded.User;
import br.com.jkavdev.persistence.util.jpa.JpaUtil;

public class TestEmbedded {

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
	public void insertEmbedded() {
		Person person = new Person();
		person.setIdade(22);
		person.setNome("Jhonatan");

		Address homeAddress = new Address();
		homeAddress.setDistrict("Planaltina");
		homeAddress.setNumber(21);
		homeAddress.setStreet("Qr 12 cas 15");

		Address workAddress = new Address();
		workAddress.setDistrict("Goais");
		workAddress.setNumber(35);
		workAddress.setStreet("Qr 45 caas 11");

		person.setHomeAddress(homeAddress);
		person.setWorkAddress(workAddress);

		this.manager.getTransaction().begin();
		this.manager.persist(person);
		this.manager.getTransaction().commit();
	}
	
	@Test
	public void insertEnum(){
		User user = new User();
		user.setName("Jhonatan");
		user.setPapelUsuario(PapelUsuario.MANAGER);
		user.setStatusCompra(StatusCompra.APPROVED);
		
		user.getPerfis().add(PerfilUsuario.MANAGER);
		user.getPerfis().add(PerfilUsuario.NORMAL);
		
		user.getEmails().add("jhonatankolen@gmail.com");
		user.getEmails().add("jhonatan.viana@foton.la");
		
		this.manager.getTransaction().begin();
		this.manager.persist(user);
		this.manager.getTransaction().commit();
	}

}
