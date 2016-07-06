package br.com.jkavdev.livraria.test.spring;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.livraria.model.Aluno;
import br.com.jkavdev.livraria.model.Emprestimo;
import br.com.jkavdev.livraria.model.Livro;

public class InsertTestEmprestimo {

	private static final Logger logger = Logger.getLogger(InsertTestEmprestimo.class);
	private EntityManagerFactory factory;
	private EntityManager manager;

	@Before
	public void init() {

		factory = Persistence.createEntityManagerFactory("livrariaPU");
		manager = factory.createEntityManager();

	}

	@Test
	public void insertEmprestimo() {

		beginTransaction();

		List<Livro> livros = this.manager.createQuery("from Livro", Livro.class).getResultList();
		List<Aluno> alunos = this.manager.createQuery("from Aluno", Aluno.class).getResultList();

		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setAtrasado(false);
		emprestimo.setDataDeEntrega(Calendar.getInstance());
		emprestimo.setDataDoEmprestimo(Calendar.getInstance());
		emprestimo.setDataDoEmprestimoVencimento(Calendar.getInstance());
		emprestimo.setMultaPaga(false);
		emprestimo.setPerdido(true);

		for (Aluno aluno : alunos) {
			logger.info(aluno);
			emprestimo.adicionarAluno(aluno);
		}

		for (Livro livro : livros) {
			logger.info(livro);
			emprestimo.adicionarLivro(livro);
		}

		this.manager.persist(emprestimo);

		commit();

	}

	public void commit() {
		manager.getTransaction().commit();
	}

	public void beginTransaction() {
		manager.getTransaction().begin();
	}

}
