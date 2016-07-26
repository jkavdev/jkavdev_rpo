package br.com.jkavdev.k19.jpa_hibernate.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Periodo;
import br.com.jkavdev.k19.jpa_hibernate.model.Turma;

public class EnumTest {

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
	public void insertTurma() {

		Turma matutino = criaTurma(Periodo.MATUTINO);
		Turma noturno = criaTurma(Periodo.NOTURNO);
		Turma vespertino = criaTurma(Periodo.VESPERTINO);

		beginTransaction();

		manager.persist(matutino);
		manager.persist(vespertino);
		manager.persist(noturno);

		commit();

	}

	public void commit() {
		manager.getTransaction().commit();
	}

	public void beginTransaction() {
		manager.getTransaction().begin();
	}

	public Turma criaTurma(Periodo periodo) {
		Turma turma = new Turma();
		turma.setPeriodo(periodo);

		return turma;
	}

}
