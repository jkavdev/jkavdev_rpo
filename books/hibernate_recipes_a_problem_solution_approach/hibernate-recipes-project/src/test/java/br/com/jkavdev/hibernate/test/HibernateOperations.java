package br.com.jkavdev.hibernate.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.hibernate.model.Book;

public class HibernateOperations extends HibernateConfig {

	Session session;

	@Before
	public void init() {
		session = this.getSessionFactory().openSession();
	}

	@Test
	public void retrievingObjets() {

		String isbn = "PBN456";

		// se nao houver um registro lanca uma excecao
		// retorna um proxy, o acesso só ocorrera quando invocado o proxy
		Book book = session.load(Book.class, isbn);

		// se nao houver um registro retorna null
		//acessa o banco imediatamente 
		Book book1 = session.get(Book.class, isbn);

		System.out.println(book.getName());

	}
	
	@Test
	public void allBooks(){
		Query createQuery = session.createQuery("from Book");
		List<Book> books = createQuery.list();
		
		for (Book book : books) {
			System.out.println(book.getName());
		}
		
	}
	
	@Test
	public void uniqueBook(){
		Book book = (Book) session.createQuery("from Book where isbn = ?")
				.setParameter(0, "PBN456")
				.uniqueResult();
		
		System.out.println(book.getIsbn());
	}

}
