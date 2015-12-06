package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaAcessorioPorModeloCarro {

	public static void main(String[] args) {

		EntityManager manager = JPAUtil.createEntityManager();

		//buscando a descricao dos acessorios dos carros cadastrados
		String consulta = "select a.descricao " 
				+ "from Carro c join c.acessorios a "
				+ "where c.modelo.descricao = 'fusion'";

		List<String> acessorios = manager.createQuery(consulta, String.class)
				.getResultList();

		for (String acessorio : acessorios) {
			System.out.println("Acessorio " + acessorio);
		}

		manager.close();

	}

}
