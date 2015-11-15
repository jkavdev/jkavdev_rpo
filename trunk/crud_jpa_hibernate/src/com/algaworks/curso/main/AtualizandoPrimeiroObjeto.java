package com.algaworks.curso.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class AtualizandoPrimeiroObjeto {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crud_pu");
		EntityManager manager = factory.createEntityManager();
		
		Long idCliente = 5L;
		Cliente clienteAAlterar = manager.find(Cliente.class, idCliente);
		clienteAAlterar.setNome("Pedro Bial Alves Kolen");
		clienteAAlterar.setIdade(25);
		
		manager.getTransaction().begin();
		manager.merge(clienteAAlterar);
		manager.getTransaction().commit();
		
		System.out.println("Cliente Alterado");
		
		
	}

}
