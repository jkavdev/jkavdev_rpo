package com.algaworks.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class RemovendoPrimeiroObjeto {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_cliente");
		EntityManager manager = factory.createEntityManager();
		
		//nao posso remover uma instancia em que nao e gerenciada pelo manager
		Cliente clienteARemover = new Cliente();
		clienteARemover.setCodigo(3L);
		
		//podemos fazer que o objeto seja gereciado pelo manager atraves
		//do metodo find
		clienteARemover = manager.find(Cliente.class, 3L);
		
		manager.getTransaction().begin();
		manager.remove(clienteARemover);
		manager.getTransaction().commit();
		
		System.out.println("Cliente Removido com Sucesso");
		
	}

}
