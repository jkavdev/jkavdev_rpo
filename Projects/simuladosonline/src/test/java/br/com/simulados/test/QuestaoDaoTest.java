package br.com.simulados.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.so.modelo.Nivel;
import br.com.so.modelo.Prova;
import br.com.so.modelo.Questao;

public class QuestaoDaoTest {
	
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
	public void insertQuestao(){
		
		Questao questao = new Questao();
		questao.setEnunciado("Test");
		questao.setResposta("F");
		questao.setTipo("Certo errado");
		
		Prova prova = new Prova();
		prova.setNivel(Nivel.MEDIO);
		
		questao.setProva(prova);
		
		this.manager.getTransaction().begin();
		
		this.manager.persist(prova);
		this.manager.persist(questao);
		
		this.manager.getTransaction().commit();
		
		System.out.println("Feito");
		
	}

}
