package br.com.jkavdev.k19.jpa_hibernate.test;

import java.util.List;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Pessoa;

public class EstadoTest extends AbstractJUnitConfig {

	// new - managed
	@Test
	public void newToManaged() {
		// estado new
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Jhonatan");

		beginTransaction();

		// tornando o objeto gerenciado
		this.getManager().persist(pessoa);

		commit();
	}

	// banco de dados - managed
	@Test
	public void BancoToManaged() {

		// todo objeto recuperado pelo banco será tornara gerenciado
		Pessoa pessoa = this.getManager().find(Pessoa.class, 1L);

		Pessoa pessoa1 = this.getManager().getReference(Pessoa.class, 1L);

		List<Pessoa> pessoas = this.getManager()
				.createQuery("from Pessoa", Pessoa.class).getResultList();

	}

	// managed - detached
	@Test
	public void managedToDetached() {
		// gerenciado
		Pessoa pessoa = this.getManager().find(Pessoa.class, 1L);

		// desanexando o objeto do contexto
		this.getManager().detach(pessoa);

		// tornando todas os objetos gerenciados em detached
		this.getManager().clear();
	}

	// detached - managed
	@Test
	public void DetachedToManaged() {

		Pessoa pessoa = this.getManager().find(Pessoa.class, 1L);

		this.getManager().detach(pessoa);

		// tornando novamento o objeto no estado managed
		Pessoa PessoaGerenciada = this.getManager().merge(pessoa);

	}

	// managed - to removed
	@Test
	public void managedToRemoved() {

		Pessoa pessoa = this.getManager().find(Pessoa.class, 1L);

		// removendo registro do banco
		this.getManager().remove(pessoa);

	}

	// managed - managed
	@Test
	public void ManagedToManaged() {

		Pessoa pessoa = this.getManager().find(Pessoa.class, 1L);
		
		//atualizando entidade com o banco
		this.getManager().refresh(pessoa);

	}

}
