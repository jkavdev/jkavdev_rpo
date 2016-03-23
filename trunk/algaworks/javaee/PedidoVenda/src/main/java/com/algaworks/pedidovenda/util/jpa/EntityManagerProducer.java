package com.algaworks.pedidovenda.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//sera criado apenas uma instancia desta classe por aplicacao

@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory;

	//criado o factory na hora da instanciacao desta classe
	public EntityManagerProducer() {
		factory = Persistence.createEntityManagerFactory("pedidoPU");
		System.out.println("PRODUTOR ENTITYMANAGER");
	}

	//produtor do entityManager
	@Produces
	//seu escopo eh de requisicao
	@RequestScoped
	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

	//depois de acabo seu escopo, entitymanager sera fechado
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}
