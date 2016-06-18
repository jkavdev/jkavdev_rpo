package br.com.jkavdev.cocodonto.model.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.jkavdev.cocodonto.model.util.jpa.JpaUtil;

public class GeraTabelas {

	private final Logger logger = Logger.getLogger(this.getClass());
	private static EntityManagerFactory factory;
	private EntityManager manager;

	// ocorrera antes da classe de teste ser instanciada
	// sera executado apenas uma vez,
	// independentemente da quantidade de testes rodados
	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("cocodontoPU");
	}

	// sera executado toda vez que um test for
	// executado
	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}

	// sera executado sempre depois de qualquer metodo
	// ideal para fechamento de conexoes,
	// If you allocate external resources in a Before method you need to release
	// them after the test runs
	@After
	public void tearDown() {
		this.manager.close();
	}

	@Test
	public void geraTabelas() {

		logger.info("Gerando tabelas....");

		JpaUtil.close();

	}

}
