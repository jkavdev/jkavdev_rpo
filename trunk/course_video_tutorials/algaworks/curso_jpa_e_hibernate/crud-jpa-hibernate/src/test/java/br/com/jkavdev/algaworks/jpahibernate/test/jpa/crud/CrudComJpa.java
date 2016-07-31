package br.com.jkavdev.algaworks.jpahibernate.test.jpa.crud;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpahibernate.model.Cliente;
import br.com.jkavdev.algaworks.jpahibernate.test.jpa.JpaConfig;

public class CrudComJpa extends JpaConfig {

	@Test
	public void salvandoCliente() {

		Cliente cliente = criaCliente("Jhonatan Kolen", 26, "Programador", "M");

		// qualquer alteração refletida no banco de dados
		// é necessário abrir uma transacação
		beginTransaction();

		this.getManager().persist(cliente);

		// realizando commit para serem refletidas as alterações no banco
		commit();
	}

	@Test
	public void consultaCliente() {

		// realizando a consulta no banco
		// informando qual será o tipo retornado
		// e a chave primária identificando o registro a ser retornado
		Cliente clienteEncontrado = this.getManager().find(Cliente.class, 15L);

		// verificando o resultado
		// caso informado um id nao existente, retornará null
		if (clienteEncontrado != null) {
			System.out.println("Cliente: " + clienteEncontrado.getNome());
		} else {
			System.out.println("Cliente não encontrado");
		}

	}

	@Test
	public void removendoCliente() {

		// para que alguma alteração no banco seja refletida
		// todas as entidades que serão alteradas precisam estarem gerenciadas
		Cliente clienteEncontrado = this.getManager().find(Cliente.class, 2L);

		beginTransaction();

		// verificando caso nao encontrado
		if (clienteEncontrado != null) {
			this.getManager().remove(clienteEncontrado);

			System.out.println("Cliente removido: " + clienteEncontrado.getNome());
		} else {
			System.out.println("Cliente não encontrado");
		}

		commit();
	}

	@Test
	public void atualizadoCliente() {

		Cliente clienteEncontrado = this.getManager().find(Cliente.class, 2L);

		beginTransaction();

		// verificando caso nao encontrado
		if (clienteEncontrado != null) {

			// alterando as propriedades do cliente encontrado
			clienteEncontrado.setNome("Yago Santos");
			clienteEncontrado.setIdade(35);

			System.out.println("Cliente alterado: " + clienteEncontrado.getNome());
		} else {
			System.out.println("Cliente não encontrado");
		}

		// o hibernate na hora do commit sincronizará todas as entidades
		// no seu contexto com o banco de dados
		commit();

	}

	public Cliente criaCliente(String nome, Integer idade, String profissao, String sexo) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setIdade(idade);
		cliente.setProfissao(profissao);
		cliente.setSexo(sexo);

		return cliente;
	}

}
