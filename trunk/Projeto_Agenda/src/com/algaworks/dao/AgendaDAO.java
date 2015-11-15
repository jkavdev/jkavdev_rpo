package com.algaworks.dao;

import javax.persistence.EntityManager;

import com.algaworks.modelo.Agenda;
import com.algaworks.util.JPAUtil;

public class AgendaDAO {

	public void inserirRegistro(Agenda agenda) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(agenda);
		manager.getTransaction().commit();
		System.out.println("Inserido com Sucesso!");
	}
	

}
