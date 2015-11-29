package com.algaworks.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class SalvandoPrimeiroObjeto {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("pu_cliente");
		EntityManager manager = factory.createEntityManager();

		Cliente cliente = new Cliente();
		cliente.setNome("Pedro");
		cliente.setIdade(40);
		cliente.setSexo("M");
		cliente.setProfissao("Jornalista");

		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();

		System.out.println("Cliente Salvo com Sucesso");

	}

}
