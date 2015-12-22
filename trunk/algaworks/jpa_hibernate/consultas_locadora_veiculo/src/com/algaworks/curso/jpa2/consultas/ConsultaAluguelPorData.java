package com.algaworks.curso.jpa2.consultas;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaAluguelPorData {
	
	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.createEntityManager();
		
		String jpql = "select count(a)"
				+ " from Aluguel a"
				+ " where a.dataDevolucao BETWEEN :inicio "
				+ " AND :fim";
		
		//precisamos converter para date
		Calendar inicioCalendar = Calendar.getInstance();
		inicioCalendar.set(2015, 6, 25, 4, 25);
		Date inicio = inicioCalendar.getTime();
		
		Calendar fimCalendar = Calendar.getInstance();
		inicioCalendar.set(2015, 7, 26, 4, 25);
		Date fim = fimCalendar.getTime();
		
		//informamos os parametros e o tipo do campo noa banco
		Long quantidadeDevolucoes = manager.createQuery(jpql, Long.class)
				.setParameter("inicio", inicio, TemporalType.TIMESTAMP)
				.setParameter("fim", fim, TemporalType.TIMESTAMP)
				.getSingleResult();
		
		System.out.println(quantidadeDevolucoes);
		
		manager.close();
		
	}

}
