package com.algaworks.curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.algaworks.curso.modelo.Cliente;

public class TesteDoCicloDeVida {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_cliente");
		EntityManager manager = factory.createEntityManager();

		// criacao de objeto, seu estado e de novo
		Cliente cliente = new Cliente();
		cliente.setNome("Jhonatan");
		cliente.setIdade(21);
		cliente.setProfissao("Piloto");
		cliente.setSexo("Masculino");

		// para gerenciar este objeto
		// podemos usar o persist ou o merge
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();

		// desatachando este objeto do manager
//		manager.detach(cliente);

		// persistimos este objeto desatachado sera, lancada uma excecao
//		try {
//			manager.getTransaction().begin();
//			manager.persist(cliente);
//			manager.getTransaction().commit();
//		} catch (PersistenceException e) {
//			System.out.println("Erro ao persistir a entidade. " + e.getMessage());
//			manager.getTransaction().rollback();
//		}
		
		//para fazermos o objeto voltar a ser gerenciado pelo manager
		//podemos usar o merge ou o find para uma busca no banco
//		Cliente cliente2 = manager.find(Cliente.class, 1L);
//		manager.getTransaction().begin();
//		cliente2.setIdade(35);
//		manager.getTransaction().commit();
		
		//entrando no estado remove
		manager.getTransaction().begin();
		manager.remove(cliente);
		manager.getTransaction().commit();
		
		//recuperando uma entidade removida
		Cliente cliente2 = manager.merge(cliente);
		System.out.println(cliente == cliente2);
		manager.getTransaction().begin();
		cliente.setIdade(36);
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		cliente2.setIdade(36);
		manager.getTransaction().commit();
	}

}
