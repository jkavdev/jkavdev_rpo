package br.com.jkavdev.livraria.test.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.livraria.model.Curso;
import br.com.jkavdev.livraria.model.Livro;

public class InsertTestCurso {

	private EntityManagerFactory factory;
	private EntityManager manager;

	@Before
	public void init() {

		factory = Persistence.createEntityManagerFactory("livrariaPU");
		manager = factory.createEntityManager();

	}

	@Test
	public void insertCursoSemLivros() {

		beginTransaction();

		Curso arquitetura = criaCurso("Arquitetura", "Arquitetura de Interior");
		Curso engenhariaMecanica = criaCurso("Engenharia Mecanica", "Engenharia Mecanica de Carros");

		this.manager.persist(engenhariaMecanica);
		this.manager.persist(arquitetura);

		commit();

	}

	@Test
	public void insertCursoComLivro() {

		beginTransaction();

		Curso analise = criaCurso("Analise de Desenvolvimento", "Desenvolvimento de Sistemas");
		Curso direita = criaCurso("Direito", "Direito Penal");

		List<Livro> livros = manager.createQuery("from Livro", Livro.class) .getResultList();

		for (Livro livro : livros) {
			if (livro.getId() == 1) {
				analise.adicionaLivroIndicado(livro);
			} else if (livro.getId() == 2) {
				direita.adicionaLivroIndicado(livro);
			}
		}

		this.manager.persist(analise);
		this.manager.persist(direita);

		commit();

	}

	public Curso criaCurso(String nomeCurso, String descricao) {
		return new Curso(nomeCurso, descricao);
	}

	public void commit() {
		manager.getTransaction().commit();
	}

	public void beginTransaction() {
		manager.getTransaction().begin();
	}

}
