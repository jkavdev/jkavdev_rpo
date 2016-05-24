package com.algaworks.cursojavaee.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.cursojavaee.modelo.Simulado;

public class TestHibernate {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("simuladosPU");
		EntityManager manager = factory.createEntityManager();

		Simulado simulado = new Simulado();
		simulado.setNome("Jhonatan Kolen");

		manager.getTransaction().begin();
		manager.persist(simulado);
		manager.getTransaction().commit();

		manager.close();
		factory.close();

	}

}
