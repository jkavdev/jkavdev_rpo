package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaModeloFiltroEmFabricanteECategoria {

	public static void main(String[] args) {

		EntityManager manager = JPAUtil.createEntityManager();

		String consulta = "select mc.descricao from ModeloCarro mc where mc.fabricante.nome = 'Honda'";
		List<String> modelos = manager.createQuery(consulta, String.class).getResultList();

		for (String descricao : modelos) {
			System.out.println(descricao);
		}

		manager.close();

	}

}
