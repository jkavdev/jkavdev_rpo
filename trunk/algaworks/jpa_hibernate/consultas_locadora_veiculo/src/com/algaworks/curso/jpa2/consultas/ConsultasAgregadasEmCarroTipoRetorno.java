package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.info.AluguelCarroInfo;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultasAgregadasEmCarroTipoRetorno {

	public static void main(String[] args) {

		EntityManager manager = JPAUtil.createEntityManager();

		String jpql = "select new com.algaworks.curso.jpa2.info."
				+ "AluguelCarroInfo(c, count(a), max(a.valorTotal), avg(a.valorTotal))"
				+ " from Carro c JOIN c.alugueis a"
				+ " group by c"
				+ " having count(a) > 1";
		List<AluguelCarroInfo> resultados = manager.createQuery(jpql, AluguelCarroInfo.class).getResultList();
		
		for (AluguelCarroInfo aluguelCarroInfo : resultados) {
			System.out.println("Modelo : " + aluguelCarroInfo.getCarro().getModelo().getDescricao());
			System.out.println("Total de Alugueis : " + aluguelCarroInfo.getTotalAlugueis());
			System.out.println("Valor Maximo : " + aluguelCarroInfo.getValorMaximo());
			System.out.println("Valor Medio : " + aluguelCarroInfo.getValorMedio());
		}
		
		manager.close();

	}

}
