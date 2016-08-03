package br.com.jkavdev.hibernate.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.jkavdev.hibernate.dao.BookDao;
import br.com.jkavdev.hibernate.model.Book;

public class HibernateDaoTest {
	
	private BookDao bookDao = new BookDao();
	
	@Test
	public void insertBookDao(){
		Book book = criaBook("PBN457", "Hibernate in Action", 2554, new Date());
		
		bookDao.create(book);
	}
	
	@Test
	public void findAll(){
		List<Book> booksFounded = bookDao.readAll();
		
		for (Book book : booksFounded) {
			System.out.println("Book: " + book.getIsbn());
		}
		
	}
	
	public Book criaBook(String isbn, String name, int price, Date publishDate){
		
		Book book = new Book();
		book.setIsbn(isbn);
		book.setName(name);
		book.setPrice(price);
		book.setPublishDate(publishDate);
		
		return book;
	}

}
