package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaFabricante {

	public static void main(String[] args) {

		EntityManager manager = JPAUtil.createEntityManager();

		// nesta consulta ela retorna todo o objeto
		// e se quisermos apenas o nome do fabricante
		List<Fabricante> fabricantes = manager.createQuery("select f from Fabricante f", Fabricante.class)
				.getResultList();

		for (Fabricante fabricante : fabricantes) {
			System.out.println(fabricante.getNome());
		}

		// buscando apenas o nome dos fabricantes
		List<String> nomes = manager.createQuery("select f.nome from Fabricante f", String.class).getResultList();

		for (String nome : nomes) {
			System.out.println(nome);
		}

		manager.close();

	}

}
