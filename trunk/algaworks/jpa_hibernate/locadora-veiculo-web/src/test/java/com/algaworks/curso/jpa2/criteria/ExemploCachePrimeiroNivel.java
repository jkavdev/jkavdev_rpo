package com.algaworks.curso.jpa2.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Carro;

public class ExemploCachePrimeiroNivel {

	private static EntityManagerFactory factory;
	private EntityManager manager;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
	}

	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}

	@After
	public void tearDown() {
		this.manager.close();
	}

	@Test
	public void cache() {

		TypedQuery<Carro> query = manager.createQuery("from Carro c", Carro.class);
		List<Carro> carros = query.getResultList();

		for (Carro carro : carros) {
			System.out.println(carro.getCodigo() + " - " + carro.getPlaca());
		}
		
		manager.close();
		//agora obrigo o manager a fazer uma nova consulta pois ele foi criado denovo
		manager = factory.createEntityManager();
		
		System.out.println("--------------------------------------");
		//nesta caso o jpa usara a consulta que esta em cache, pois o manager ainda esta aberto
		Carro carro = manager.find(Carro.class, 5L);
		System.out.println(carro.getCodigo() + " - " + carro.getPlaca());

	}

}
