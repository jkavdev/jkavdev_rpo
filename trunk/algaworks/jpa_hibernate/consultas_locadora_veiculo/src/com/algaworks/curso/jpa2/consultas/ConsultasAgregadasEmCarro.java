package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultasAgregadasEmCarro {

	public static void main(String[] args) {

		EntityManager manager = JPAUtil.createEntityManager();

		String jpql = "select c, count(a), max(a.valorTotal), avg(a.valorTotal)"
				+ " from Carro c JOIN c.alugueis a"
				+ " group by c"
				+ " having count(a) > 1";
		List<Object[]> resultados = manager.createQuery(jpql).getResultList();
		
		for (Object[] obj : resultados) {
			System.out.println("Modelo " + ((Carro) obj[0]).getModelo().getDescricao());
			System.out.println("Quantidade de alugues " + obj[1]);
			System.out.println("Valor Maximo " + obj[2]);
			System.out.println("Valor Medio " + obj[3]);
		}

		manager.close();

	}

}
