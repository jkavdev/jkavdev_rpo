package com.algaworks.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class AtualizandoPrimeiroObjeto {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("pu_cliente");
		EntityManager manager = factory.createEntityManager();

		long codigo = 1L;
		Cliente clienteAAtualizar = manager.find(Cliente.class, codigo);

		manager.getTransaction().begin();
		clienteAAtualizar.setNome("Jose");
		clienteAAtualizar.setIdade(27);
		manager.getTransaction().commit();
		
		System.out.println("Cliente alterado com Sucesso");

	}

}
