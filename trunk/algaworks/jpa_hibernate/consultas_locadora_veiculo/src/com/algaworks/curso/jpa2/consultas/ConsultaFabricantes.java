package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaFabricantes {

	public static void main(String[] args) {

		EntityManager manager = JPAUtil.createEntityManager();

		//selecionando todos os atributos dos fabricantes
//		List<Fabricante> fabricantes = manager.createQuery(
//				"select f from Fabricante f", Fabricante.class).getResultList();
//		
//		for (Fabricante fabricante : fabricantes) {
//			System.out.println(fabricante.getCodigo() + " - " + fabricante.getNome());
//		}
		
		//selecionando apenas os nomes dos fabricantes
		List<String> nomesDosFabricantes = manager.createQuery(
				"select f.nome from Fabricante f", String.class).getResultList();

		for (String nome : nomesDosFabricantes) {
			System.out.println("Nome : " + nome);
		}

		manager.close();

	}

}
