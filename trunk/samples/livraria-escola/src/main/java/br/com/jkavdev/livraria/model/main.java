package br.com.jkavdev.livraria.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class main {

	public static void main(String[] args) {

		EntityManagerFactory factory;
		EntityManager manager;

		factory = Persistence.createEntityManagerFactory("livrariaPU");
		manager = factory.createEntityManager();
		
		manager.close();
		factory.close();

	}
}
