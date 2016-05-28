package br.com.simulados.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.simulados.modelo.Instituicao;
import br.com.simulados.modelo.Prova;

public class SelectTest {

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
	public void selectProva() {		
		String inst = "CESPE";
		List<Prova> provas = manager.createQuery("select p from Prova p where p.instituicao.nome = :instituicao", Prova.class)
				.setParameter("instituicao", inst)
				.getResultList();

		for (Prova prova : provas) {
			System.out.println(prova.getCargo().getNomeCargo() + " - " + prova.getInstituicao().getNome());
		}
	}
	
	@Test
	public void selectInstituicao(){
		List<Instituicao> instituicoes = manager.createQuery("from Instituicao", Instituicao.class).getResultList();
		
		System.out.println("Tamanho: " + instituicoes.size());
		
		for (Instituicao instituicao : instituicoes) {
			System.out.println(instituicao.getNome());
		}
	}

}
