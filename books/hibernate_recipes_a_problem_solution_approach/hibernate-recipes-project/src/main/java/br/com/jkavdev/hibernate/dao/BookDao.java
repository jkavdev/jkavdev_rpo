package br.com.jkavdev.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.jkavdev.hibernate.config.SessionManager;
import br.com.jkavdev.hibernate.model.Book;

public class BookDao {

	private Session session;

	public BookDao() {
		session = SessionManager.getSessionFactory().openSession();
	}

	@SuppressWarnings("unchecked")
	public List<Book> readAll() {
		session.beginTransaction();

		List<Book> books = session.createQuery("from Book").list();

		session.getTransaction().commit();

		return books;

	}
	
	public void create(Book book){
		session.beginTransaction();
		
		session.saveOrUpdate(book);
		
		session.getTransaction().commit();
	}

}
