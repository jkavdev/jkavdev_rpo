package br.com.jkavdev.models.dpj.dao;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.models.dpj.dao.jpa.JpaDelegaciaDao;
import br.com.jkavdev.models.dpj.model.Delegacia;
import br.com.jkavdev.models.dpj.util.jpa.JpaUtil;

public class InsertTest {

	private static final Logger logger = Logger.getLogger(InsertTest.class);
	private IDelegaciaDao delegaciaDao;

	@Test
	public void insertDelegacia() {
		Delegacia delegacia = new Delegacia("Operações especiais");

		this.delegaciaDao.salvar(delegacia);
		
		logger.info("delegacia inserida: " + delegacia);
	}

	@Before
	public void setUp() {
		delegaciaDao = new JpaDelegaciaDao();
	}

	@After
	public void tearDown() {
		JpaUtil.close();
	}

}
