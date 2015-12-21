package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaFabricantesPeloModeloCarro {

	public static void main(String[] args) {

		EntityManager manager = JPAUtil.createEntityManager();

		//consulta o fabrincante pelo modelo do carros
		List<String> nomesFabricantes = manager.createQuery("select mc.fabricante.nome from ModeloCarro mc", String.class).getResultList();
		
		for (String nome : nomesFabricantes) {
			System.out.println("Nome " + nome);
		}
		
		manager.close();

	}

}
