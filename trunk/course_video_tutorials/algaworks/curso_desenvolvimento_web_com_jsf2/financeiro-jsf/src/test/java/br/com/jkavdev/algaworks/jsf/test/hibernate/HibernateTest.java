package br.com.jkavdev.algaworks.jsf.test.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.algaworks.jsf.model.Pessoa;
import br.com.jkavdev.algaworks.jsf.util.jpa.HibernateUtil;

public class HibernateTest {

	private static final Logger logger = Logger.getLogger(HibernateTest.class);
	Session session;

	@SuppressWarnings({ "unchecked" })
	@Test
	public void hibernateTest() {

		List<Pessoa> pessoas = session.createCriteria(Pessoa.class)
				.add(Restrictions.gt("codigo", 2))
				.list();

		logger.info("Pessoas encontradas");
		for (Pessoa pessoa : pessoas) {
			logger.info("Nome: " + pessoa.getNome());
		}

	}
	
	@Test
	public void insertPessoas(){
		Pessoa jhonatan = new Pessoa();
		jhonatan.setNome("Jhonatan Kolen");
		
		beginTransaction();
		
		session.save(jhonatan);
		
		commit();
	}

	private void beginTransaction() {
		session.getTransaction().begin();
	}

	private void commit() {
		session.getTransaction().commit();
	}

	@Before
	public void init() {
		session = HibernateUtil.getSession();
	}

	@After
	public void des() {
		session.close();
	}

}
