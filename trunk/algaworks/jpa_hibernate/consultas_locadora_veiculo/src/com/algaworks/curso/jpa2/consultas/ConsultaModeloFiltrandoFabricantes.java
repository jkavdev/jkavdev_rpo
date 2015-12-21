package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaModeloFiltrandoFabricantes {

	public static void main(String[] args) {

		EntityManager manager = JPAUtil.createEntityManager();

		//consulta os modelos dos carros pelo nome do fabricante
		List<String> modelos = manager.createQuery("select mc.descricao from ModeloCarro mc where mc.fabricante.nome = 'Honda'", String.class).getResultList();
		
		for (String nome : modelos) {
			System.out.println("Nome " + nome);
		}
		
		manager.close();

	}

}
