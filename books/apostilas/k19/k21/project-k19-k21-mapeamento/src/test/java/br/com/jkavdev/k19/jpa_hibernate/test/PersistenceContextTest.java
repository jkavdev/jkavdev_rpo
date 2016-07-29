package br.com.jkavdev.k19.jpa_hibernate.test;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Pessoa;

public class PersistenceContextTest extends AbstractJUnitConfig {

	@Test
	public void persitenceContextTest() {

		System.out.println("Primeiro: ");
		Pessoa pessoa = this.getManager().find(Pessoa.class, 1L);

		System.out.println("Segundo: ");
		pessoa = this.getManager().find(Pessoa.class, 1L);
	}

	

}
