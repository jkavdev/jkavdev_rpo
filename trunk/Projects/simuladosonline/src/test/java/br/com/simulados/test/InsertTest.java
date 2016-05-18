package br.com.simulados.test;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.so.modelo.Area;
import br.com.so.modelo.Banca;
import br.com.so.modelo.Cargo;
import br.com.so.modelo.Instituicao;
import br.com.so.modelo.Nivel;
import br.com.so.modelo.Prova;

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
	public void insereInstituicao() {
		Instituicao instituicao = new Instituicao();
		instituicao.setNome("CESPE");

		manager.getTransaction().begin();
		manager.persist(instituicao);
		manager.getTransaction().commit();
	}

	@Test
	public void insereBanca() {
		Banca banca = new Banca();
		banca.setNome("CESPE");

		manager.getTransaction().begin();
		manager.persist(banca);
		manager.getTransaction().commit();
	}

	@Test
	public void insereArea() {
		Area area = new Area();
		area.setNome("Perito Administrativo");

		manager.getTransaction().begin();
		manager.persist(area);
		manager.getTransaction().commit();
	}

	@Test
	public void insereCargo() {
		Cargo cargo = new Cargo();
		cargo.setNomeCargo("Perito");

		manager.getTransaction().begin();
		manager.persist(cargo);
		manager.getTransaction().commit();
	}

	@Test
	public void insereProva() {
		Banca banca = manager.find(Banca.class, 1L);
		Area area = manager.find(Area.class, 1L);
		Cargo cargo = manager.find(Cargo.class, 1L);
		Instituicao instituicao = manager.find(Instituicao.class, 1L);

		Prova prova = new Prova();
		prova.setData(Calendar.getInstance());
		prova.setNivel(Nivel.MEDIO);
		// prova.setArea(area);
		prova.setBanca(banca);
		prova.setCargo(cargo);
		prova.setInstituicao(instituicao);

		manager.getTransaction().begin();
		manager.persist(prova);
		manager.getTransaction().commit();
	}

}
