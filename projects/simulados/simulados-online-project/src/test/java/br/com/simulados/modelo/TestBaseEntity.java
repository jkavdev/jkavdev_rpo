package br.com.simulados.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBaseEntity {

	private static EntityManagerFactory factory;
	private EntityManager manager;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("simuladosPU");
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
	public void testHasCode() {
		Banca banca = new Banca();
		banca.setId(15L);

		Banca banca1 = new Banca();
		banca1.setId(15L);

		// uma entidade deve apenas ser diferenciada pela chave primaria
		System.out.println("Entidades banca e banca1 iguais pelo ID: " + banca.equals(banca1));

	}

}
