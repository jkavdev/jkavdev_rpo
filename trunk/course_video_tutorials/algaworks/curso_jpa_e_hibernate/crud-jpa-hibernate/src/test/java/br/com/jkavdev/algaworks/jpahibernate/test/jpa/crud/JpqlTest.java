package br.com.jkavdev.algaworks.jpahibernate.test.jpa.crud;

import java.util.List;

import org.junit.Test;

import br.com.jkavdev.algaworks.jpahibernate.model.Cliente;
import br.com.jkavdev.algaworks.jpahibernate.test.jpa.JpaConfig;

public class JpqlTest extends JpaConfig {

	@Test
	public void consultaComJpql() {

		//consulta realizada em cima do objeto
		String jpql = "from Cliente";

		//passamos a consulta a ser realizada
		//passamos o tipo a ser retornado da consulta
		List<Cliente> clientes = this.getManager().createQuery(jpql, Cliente.class)
				.getResultList();

		for (Cliente cliente : clientes) {
			System.out.println("Cliente: " + cliente.getNome());
			System.out.println("=================================");
		}

	}

}
