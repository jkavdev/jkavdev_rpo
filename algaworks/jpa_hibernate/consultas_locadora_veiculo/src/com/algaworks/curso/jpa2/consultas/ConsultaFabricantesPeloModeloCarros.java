package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaFabricantesPeloModeloCarros {
	
	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.createEntityManager();
		
		//selecionando o nome dos fabricantes dos modelos cadastrados
		List<String> nomeDosFabricantes = manager.createQuery("select mc.fabricante.nome from ModeloCarro mc", String.class).getResultList();
		
		for (String nomeFabricante : nomeDosFabricantes) {
			System.out.println("Nome : " + nomeFabricante);
		}
		
		manager.close();
		
	}

}
