package br.com.jkavdev.persistence.test;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.persistence.util.jpa.JpaUtil;

public class TestSecondaryTable {
	
	private EntityManager manager;

	@Before
	public void setUp() {
		this.manager = JpaUtil.geEntityManager();
	}

	@After
	public void tearDown() {
		JpaUtil.close();
	}
	
	@Test
	public void insertMultipleTable(){
		this.manager.getTransaction().begin();
		this.manager.getTransaction().commit();
	}

}
