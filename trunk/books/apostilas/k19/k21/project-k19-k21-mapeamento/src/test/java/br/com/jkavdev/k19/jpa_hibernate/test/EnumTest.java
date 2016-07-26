package br.com.jkavdev.k19.jpa_hibernate.test;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Periodo;
import br.com.jkavdev.k19.jpa_hibernate.model.Turma;

public class EnumTest extends AbstractJUnitConfig {

	@Test
	public void insertTurma() {

		Turma matutino = criaTurma(Periodo.MATUTINO);
		Turma noturno = criaTurma(Periodo.NOTURNO);
		Turma vespertino = criaTurma(Periodo.VESPERTINO);

		beginTransaction();

		this.getManager().persist(matutino);
		this.getManager().persist(vespertino);
		this.getManager().persist(noturno);

		commit();

	}

	public void commit() {
		this.getManager().getTransaction().commit();
	}

	public void beginTransaction() {
		this.getManager().getTransaction().begin();
	}

	public Turma criaTurma(Periodo periodo) {
		Turma turma = new Turma();
		turma.setPeriodo(periodo);

		return turma;
	}

}
