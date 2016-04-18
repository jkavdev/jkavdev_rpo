package com.algaworks.curso.jpa2.criteria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.Categoria;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;

public class ExemplosCascata {

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
	public void exemploEntidadeTransient() {
		
		Carro carro = new Carro();
		carro.setCor("Preto");
		carro.setPlaca("AAA-2121");
		
		//tratando atributos transient
		ModeloCarro modeloCarro = new ModeloCarro();
		modeloCarro.setCategoria(Categoria.ESPORTIVO);
		modeloCarro.setDescricao("Ferrari S2");
		
		carro.setModelo(modeloCarro);
		
		this.manager.getTransaction().begin();
		this.manager.persist(carro);
		this.manager.getTransaction().commit();

	}

}
