package br.com.jkavdev.k19.jpa_hibernate.test;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Cidade;

public class CacheTest extends AbstractJUnitConfig {

	@Test
	public void insertCidade(){
		
		Cidade cidade = new Cidade();
		cidade.setNomeDaCidade("São Paulo");
		cidade.setNomeDoEstado("São Paulo");
		
		Cidade rio = new Cidade();
		rio.setNomeDaCidade("Rio de Janeiro");
		rio.setNomeDoEstado("Rio de Janeiro");
		
		beginTransaction();
		
		this.getManager().persist(rio);
		this.getManager().persist(cidade);
		
		commit();
		
	}
	
	@Test
	public void cacheSegundoNivelTest(){
		
		Cidade cidade = this.getManager().find(Cidade.class, 5L);
		
		EntityManager entityManager = this.getFactory().createEntityManager();
		
		cidade = entityManager.find(Cidade.class, 5L);
	}

}
