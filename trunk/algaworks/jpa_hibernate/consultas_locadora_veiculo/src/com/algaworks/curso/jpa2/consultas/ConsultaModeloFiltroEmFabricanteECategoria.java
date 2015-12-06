package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaModeloFiltroEmFabricanteECategoria {
	
	public static void main(String[] args) {

		EntityManager manager = JPAUtil.createEntityManager();

		List<String> descricaoModelo = manager.createQuery(
				"select mc.descricao from ModeloCarro mc "
						+ "where mc.fabricante = '6' "
						+ "and mc.categoria in ('ESPORTIVO', 'HATCH_GRANDE')",
				String.class).getResultList();

		for (String descricao : descricaoModelo) {
			System.out.println("Descricao : " + descricao);
		}

		manager.close();

	}

}
