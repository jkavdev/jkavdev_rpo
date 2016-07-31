package br.com.jkavdev.algaworks.jpahibernate.test.jpa.crud;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpahibernate.model.Cliente;
import br.com.jkavdev.algaworks.jpahibernate.test.jpa.JpaConfig;

public class CrudComJpa extends JpaConfig {

	@Test
	public void salvandoCliente() {

		Cliente cliente = criaCliente("Jhonatan Kolen", 26, "Programador", "M");

		beginTransaction();

		this.getManager().persist(cliente);

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
