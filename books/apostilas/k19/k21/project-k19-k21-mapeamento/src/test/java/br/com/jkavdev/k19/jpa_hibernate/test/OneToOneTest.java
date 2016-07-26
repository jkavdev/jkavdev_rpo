package br.com.jkavdev.k19.jpa_hibernate.test;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Estado;
import br.com.jkavdev.k19.jpa_hibernate.model.Governador;

public class OneToOneTest extends AbstractJUnitConfig {

	@Test
	public void insertEstado() {

		Estado estado = new Estado();
		estado.setNome("Goiais");

		Governador governador = new Governador();
		governador.setNome("Marconi Perilo");

		estado.setGovernador(governador);

		beginTransaction();

		this.getManager().persist(governador);
		this.getManager().persist(estado);

		commit();

	}

	public void commit() {
		this.getManager().getTransaction().commit();
	}

	public void beginTransaction() {
		this.getManager().getTransaction().begin();
	}

}
