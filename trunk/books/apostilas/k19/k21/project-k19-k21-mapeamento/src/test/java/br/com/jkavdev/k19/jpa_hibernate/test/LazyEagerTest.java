package br.com.jkavdev.k19.jpa_hibernate.test;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.heranca.Pessoa;

public class LazyEagerTest extends AbstractJUnitConfig {

	@Test
	public void findPessoa() {

		// retorna entidade populada imediatamente
		Pessoa pessoa = this.getManager().find(Pessoa.class, 1L);

	}

	@Test
	public void getReferencePessoa() {

		// posterga a consulta apenas quando solicitado
		// os dados da entidade
		Pessoa pessoa = this.getManager().getReference(Pessoa.class, 1L);

		// agora sim faz a consulta
		System.out.println(pessoa.getNome());
	}

	@Test
	public void getReferencePessoaLazy() {

		// posterga a consulta apenas quando solicitado
		// os dados da entidade
		Pessoa pessoa = this.getManager().getReference(Pessoa.class, 1L);

		// fechando manager
		this.getManager().close();

		// tenta fazer a consulta mas o manager esta
		// fechado, ocasionando o erro
		System.out.println(pessoa.getNome());
	}

}
