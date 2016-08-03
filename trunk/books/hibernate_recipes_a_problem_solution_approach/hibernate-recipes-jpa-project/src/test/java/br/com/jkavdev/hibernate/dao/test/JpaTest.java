package br.com.jkavdev.hibernate.dao.test;

import org.junit.Test;

import br.com.jkavdev.hibernate.dao.BookDao;

public class JpaTest {

	private BookDao bookDao;

	public JpaTest() {
		bookDao = new BookDao();
	}

	@Test
	public void readAll() {
		System.out.println(bookDao.readFromManager().size());
	}

}
