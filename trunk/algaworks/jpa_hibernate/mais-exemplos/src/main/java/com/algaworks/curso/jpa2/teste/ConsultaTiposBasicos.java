package com.algaworks.curso.jpa2.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.modelo.ProprietarioC;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaTiposBasicos {

	public static void main(String[] args) {

		EntityManagerFactory factory = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager manager = factory.createEntityManager();

		ProprietarioC proprietarioC = manager.find(ProprietarioC.class, 1L);

		System.out.println("Nome: " + proprietarioC.getNome());

		for (String telefone : proprietarioC.getTelefones()) {
			System.out.println("Telefone: " + telefone);
		}

		manager.close();
		factory.close();

	}

}
