package br.com.simulados.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.so.modelo.Disciplina;
import br.com.so.modelo.Nivel;
import br.com.so.modelo.Opcao;
import br.com.so.modelo.Prova;
import br.com.so.modelo.Questao;

public class TestProvaQuestao {

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
	public void insertQuestaoProva() {

		Disciplina exatas = new Disciplina();
		exatas.setNome("Exatas");

		Disciplina humanas = new Disciplina();
		humanas.setNome("Humanas");

		Questao questao = new Questao();
		questao.setEnunciado("Questao de Portugues");
		questao.setResposta("Letra A");
		questao.setTipo("Multipla escolha");
		questao.setDisciplina(humanas);

		Opcao a = new Opcao();
		a.setNome("A");
		Opcao b = new Opcao();
		b.setNome("B");
		Opcao c = new Opcao();
		c.setNome("C");
		Opcao d = new Opcao();
		d.setNome("D");

		ArrayList<Opcao> opcoes = new ArrayList<>();
		opcoes.add(a);
		opcoes.add(b);
		opcoes.add(c);
		opcoes.add(d);

		Prova prova = new Prova();
		prova.setNivel(Nivel.FUNDAMENTAL);

		questao.setOpcoes(opcoes);

		ArrayList<Questao> questoes = new ArrayList<>();
		questoes.add(questao);
		ArrayList<Prova> provas = new ArrayList<>();
		provas.add(prova);

		prova.setQuestoes(questoes);
		questao.setProva(prova);

		EntityTransaction transaction = this.manager.getTransaction();
		transaction.begin();

		this.manager.persist(exatas);
		this.manager.persist(humanas);

		this.manager.persist(a);
		this.manager.persist(b);
		this.manager.persist(c);
		this.manager.persist(d);

		this.manager.persist(prova);
		this.manager.persist(questao);

		transaction.commit();

	}

}
