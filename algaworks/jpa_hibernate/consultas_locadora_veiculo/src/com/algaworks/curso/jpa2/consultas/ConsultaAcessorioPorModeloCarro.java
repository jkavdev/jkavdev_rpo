package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaAcessorioPorModeloCarro {

	public static void main(String[] args) {

		EntityManager manager = JPAUtil.createEntityManager();

		String jpql = "select a.descricao from Carro c JOIN c.acessorios a where c.modelo.descricao = 'Civic'";
		
		List<String> acessorios = manager.createQuery(jpql, String.class).getResultList();
		
		for (String acessorio : acessorios) {
			System.out.println(acessorio);
		}

		manager.close();

	}

}
