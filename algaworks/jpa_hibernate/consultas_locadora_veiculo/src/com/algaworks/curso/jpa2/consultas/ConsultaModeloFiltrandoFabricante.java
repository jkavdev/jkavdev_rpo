package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaModeloFiltrandoFabricante {
	
	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.createEntityManager();
		
		//selecionando a descricao dos modelos de acordo com um fabricantes
		List<String> modelos = 
				manager.createQuery("select mc.descricao from ModeloCarro mc where mc.fabricante.nome = 'Fiat'"
						, String.class).getResultList();
		
		for (String descricaoModelo : modelos) {
			System.out.println("Descricao : " + descricaoModelo);
		}
		
		manager.close();
		
	}

}
