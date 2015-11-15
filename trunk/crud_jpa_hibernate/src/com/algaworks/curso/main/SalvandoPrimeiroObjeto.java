package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class SalvandoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud_pu");
		EntityManager manager = factory.createEntityManager();

		Cliente cliente = criaCliente();

		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();

		System.out.println("Cliente Salvo com Sucesso!");
	}

	private static Cliente criaCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("Pedro Bial");
		cliente.setIdade(48);
		cliente.setSexo("M");
		cliente.setProfissao("Jornalista");
		return cliente;
	}

}
