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

public class ExemploProblemaNMaisUm {

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
	public void problema() {
		
//		TypedQuery<Carro> query = manager.createQuery("from Carro c", Carro.class);//traria os resultados do modelo mas farias varios select para tal
		//trazendo os dados do carro e do modelo apenas em uma consulta
		TypedQuery<Carro> query = manager.createQuery("from Carro c join fetch c.modelo", Carro.class);
		List<Carro> carros = query.getResultList();

		for (Carro carro : carros) {
			System.out.println(carro.getPlaca() + " - " + carro.getModelo().getDescricao());
		}

	}

}
