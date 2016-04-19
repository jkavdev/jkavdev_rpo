package com.algaworks.curso.jpa2.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.ProprietarioC;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ExemploTiposBasicos {

	public static void main(String[] args) {

		EntityManagerFactory factory = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		ProprietarioC proprietario = new ProprietarioC();
		proprietario.setNome("Jhonatan");
		proprietario.getTelefones().add("99346554");
		proprietario.getTelefones().add("99220468");

		manager.persist(proprietario);

		manager.getTransaction().commit();

		manager.close();
		factory.close();

	}

}
