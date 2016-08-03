package br.com.jkavdev.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.jkavdev.hibernate.config.SessionManager;
import br.com.jkavdev.hibernate.model.Book;

public class BookDao {

	private EntityManager manager;

	public BookDao() {
		manager = SessionManager.geEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List<Book> readFromManager() {
		manager.getTransaction().begin();

		Query createQuery = manager.createQuery("select b from Book b");

		List<Book> books = createQuery.getResultList();

		manager.getTransaction().commit();

		return books;
	}

}
