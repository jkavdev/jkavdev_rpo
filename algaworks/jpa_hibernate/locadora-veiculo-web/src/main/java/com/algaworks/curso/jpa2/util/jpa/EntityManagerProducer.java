package com.algaworks.curso.jpa2.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//sera criado apenas um objeto pro aplicacao
@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory;

	// quando for criado, a fabrica sera inicializada
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
	}

	// informa que sera produzido um manager,
	// toda vez que entitymanager for injetado com inject
	@Produces
	// informa que o escopo sera de requisicao
	// quando iniciar uma requisicao sera criado um manager
	@RequestScoped
	public EntityManager create() {
		return factory.createEntityManager();
	}

	//fecha o manager quando a requisicao terminar
	public void close(@Disposes EntityManager manager) {
		manager.close();
	}

}
