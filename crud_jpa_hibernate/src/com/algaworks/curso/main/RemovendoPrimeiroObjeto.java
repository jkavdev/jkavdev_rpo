package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class RemovendoPrimeiroObjeto {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud_pu");
		EntityManager manager = factory.createEntityManager();

		// nao podemos atualizar um registro deste modo
		// pois o entityManager nao o conhece
		// Cliente cliente = new Cliente();
		// cliente.setId(2L);

		
		//para alterar algum registro
		//precisamos que o manager gerencie essa entidade
		long idCliente = 1L;
		Cliente clienteARemover = manager.find(Cliente.class, idCliente);

		manager.getTransaction().begin();
		manager.remove(clienteARemover);
		manager.getTransaction().commit();
		
		System.out.println("Cliente Removido com Sucesso!");

	}

}
