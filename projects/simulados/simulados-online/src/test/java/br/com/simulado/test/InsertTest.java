package br.com.simulado.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.simulado.dao.InstituicaoDao;
import br.com.simulado.modelo.Instituicao;

public class InsertTest {

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
	public void insertInstituicao() {

		Instituicao instituicao = new Instituicao();
		instituicao.setNome("INSS");

		InstituicaoDao dao = new InstituicaoDao();
		dao.salvar(instituicao);

	}

}
