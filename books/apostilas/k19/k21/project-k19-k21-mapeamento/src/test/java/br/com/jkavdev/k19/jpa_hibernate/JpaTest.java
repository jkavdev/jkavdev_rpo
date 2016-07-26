package br.com.jkavdev.k19.jpa_hibernate;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JpaTest {

	private EntityManagerFactory factory;
	private EntityManager manager;

	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("k21PU");
		manager = factory.createEntityManager();
	}

	@After
	public void clean() {
		manager.close();
		factory.close();
	}

	@Test
	public void insertUsuario() {
		Usuario usuario = criaUsuario("contato@k19.com");

		beginTransaction();

		manager.persist(usuario);

		commit();

	}

	public void commit() {
		manager.getTransaction().commit();
	}

	public void beginTransaction() {
		manager.getTransaction().begin();
	}

	public Usuario criaUsuario(String email) {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setDataDeCadastro(Calendar.getInstance());

		return usuario;
	}

}
