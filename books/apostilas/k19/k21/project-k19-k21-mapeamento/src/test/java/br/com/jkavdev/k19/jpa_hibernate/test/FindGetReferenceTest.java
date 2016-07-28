package br.com.jkavdev.k19.jpa_hibernate.test;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Pessoa;

public class FindGetReferenceTest extends AbstractJUnitConfig {

	@Test
	public void findTest() {

		// com o find o manager traz imediatamente
		// todos os atributos basicos da entidade
		Pessoa pessoa = this.getManager().find(Pessoa.class, 1L);

	}

	@Test
	public void getReferenceTest() {

		// com o getReference o manager posterga a busca de entidade
		// como se voce lazy
		Pessoa pessoa = this.getManager().getReference(Pessoa.class, 1L);
		
		this.getManager().close();

		// agora o manager fara a busca da entidade
		// pois estamos solicitando informacoes da entidade
		String nome = pessoa.getNome();

	}

}
