package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaDescricaoECategoriaDeModeloCarro {

	public static void main(String[] args) {

		EntityManager manager = JPAUtil.createEntityManager();

		//nesta consulta, buscamos dois valores
		//descricao e categoria do modelo
		//como sera retornado dois, sera armazenaremos o resultado 
		//num array de objetos
		String jpql = "select mc.descricao, mc.categoria from ModeloCarro mc";

		List<Object[]> resultados = manager.createQuery(jpql).getResultList();

		for (Object[] obj : resultados) {
			System.out.println("Descricao : " + obj[0]);
			System.out.println("Categoria: " + obj[1]);
		}

		manager.close();

	}

}
