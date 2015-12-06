package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaDescricaoECategoriaDeModelo {
	
	public static void main(String[] args) {

		EntityManager manager = JPAUtil.createEntityManager();

		String consulta = "select mc.descricao, mc.categoria from ModeloCarro mc";
		
		List<Object[]> resultados = manager.createQuery(consulta).getResultList();
		
		for (Object[] obj : resultados) {
			System.out.println("Descricao: " + obj[0] + " - " + obj[1]);
		}
		
		manager.close();

	}

}
