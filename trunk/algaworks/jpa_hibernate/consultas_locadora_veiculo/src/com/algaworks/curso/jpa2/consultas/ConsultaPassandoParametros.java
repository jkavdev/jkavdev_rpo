package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaPassandoParametros {

	public static void main(String[] args) {

		EntityManager manager = JPAUtil.createEntityManager();
		
		String modelo = "Honda";

		String jpqlPosicao = "select mc.descricao from ModeloCarro mc "
				+ "where mc.fabricante.nome = ?1";
		
		List<String> modelosPosicao = manager.createQuery(jpqlPosicao, String.class)
				.setParameter(1, modelo)
				.getResultList();
		
		String jpqlParametro = "select mc.descricao from ModeloCarro mc "
				+ "where mc.fabricante.nome = :modelo";

		List<String> modelosParametro = manager.createQuery(jpqlParametro, String.class)
				.setParameter("modelo", modelo)
				.getResultList();

		for (String modeloa : modelosParametro) {
			System.out.println(modeloa);
		}

		manager.close();

	}

}
