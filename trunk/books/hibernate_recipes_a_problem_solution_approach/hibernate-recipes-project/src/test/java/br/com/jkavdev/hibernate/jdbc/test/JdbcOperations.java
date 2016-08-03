package br.com.jkavdev.hibernate.jdbc.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import br.com.jkavdev.hibernate.model.Book;
import br.com.jkavdev.hibernate.model.Chapter;
import br.com.jkavdev.hibernate.model.Publisher;

public class JdbcOperations extends JdbcConfig {

	@Test
	public void selectBooks() throws SQLException {

		// selecionando todos os registros do banco
		String sql = "select * from book";

		PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println("ISBN: " + resultSet.getString("isbn"));
		}

		resultSet.close();
		preparedStatement.close();

	}

	@Test
	public void updateBook() throws SQLException {

		// atualizando registro
		String sql = "UPDATE BOOK SET BOOK_NAME = ? WHERE ISBN = ?";

		PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
		preparedStatement.setString(1, "Hibernate Quickly 2nd Edition");
		preparedStatement.setString(2, "PBN456");

		int count = preparedStatement.executeUpdate();
		System.out.println("Updated count : " + count);
		preparedStatement.close();

		connection.close();

	}

	@Test
	public void selectObjets() throws SQLException {

		String sql = "SELECT * FROM BOOK, PUBLISHER WHERE BOOK.PUBLISHER_CODE = PUBLISHER.CODE AND BOOK.ISBN = ?";
		String isbn = "PBN456";

		PreparedStatement stmt = this.getConnection().prepareStatement(sql);
		stmt.setString(1, isbn);

		ResultSet rs = stmt.executeQuery();
		Book book = new Book();

		if (rs.next()) {

			book.setIsbn(rs.getString("ISBN"));
			book.setName(rs.getString("BOOK_NAME"));
			book.setPublishDate(rs.getDate("PUBLISH_DATE"));
			book.setPrice(rs.getInt("PRICE"));

			Publisher publisher = new Publisher();
			publisher.setCode(rs.getString("PUBLISHER_CODE"));
			publisher.setName(rs.getString("PUBLISHER_NAME"));
			publisher.setAddress(rs.getString("ADDRESS"));
			book.setPublisher(publisher);
		}

		System.out.println(book.getIsbn() + " " + book.getName());

		rs.close();
		stmt.close();
	}

	@Test
	public void selectChapters() throws SQLException {

		String sql = "SELECT * FROM CHAPTER WHERE BOOK_ISBN = ?";
		String isbn = "PBN456";

		List<Chapter> chapters = new ArrayList<Chapter>();
		Book book = new Book();

		PreparedStatement stmt = this.getConnection().prepareStatement(sql);
		stmt.setString(1, isbn);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Chapter chapter = new Chapter();
			chapter.setIndex(rs.getInt("IDX"));
			chapter.setTitle(rs.getString("TITLE"));
			chapter.setNumOfPages(rs.getInt("NUM_OF_PAGES"));
			chapters.add(chapter);
		}

//		book.setChapters(chapters);

		for (Chapter chapter : chapters) {
			System.out.println(chapter.getTitle());
		}

		rs.close();
		stmt.close();
	}

	@Test
	public void insertObject() throws SQLException {
		String sql = "INSERT INTO PUBLISHER (CODE, PUBLISHER_NAME, ADDRESS) VALUES (?, ?, ?)";
		String sql2 = "INSERT INTO BOOK (ISBN, BOOK_NAME, PUBLISHER_CODE, PUBLISH_DATE, PRICE) VALUES (?, ?, ?, ?, ?)";
		String sql3 = "INSERT INTO CHAPTER (BOOK_ISBN, IDX, TITLE, NUM_OF_PAGES) VALUES (?, ?, ?, ?)";

		Book book = new Book();

		PreparedStatement stmt = this.getConnection().prepareStatement(sql);
		stmt.setString(1, book.getPublisher().getCode());
		stmt.setString(2, book.getPublisher().getName());
		stmt.setString(3, book.getPublisher().getAddress());
		stmt.executeUpdate();
		stmt.close();

		stmt = this.getConnection().prepareStatement(sql2);
		stmt.setString(1, book.getIsbn());
		stmt.setString(2, book.getName());
		stmt.setString(3, book.getPublisher().getCode());
		stmt.setDate(4, new java.sql.Date(book.getPublishDate().getTime()));
		stmt.setInt(5, book.getPrice());
		stmt.executeUpdate();
		stmt.close();

		stmt = this.getConnection().prepareStatement(sql3);
//		for (Iterator<Chapter> iter = book.getChapters().iterator(); iter.hasNext();) {
//			Chapter chapter = (Chapter) iter.next();
//			stmt.setString(1, book.getIsbn());
//			stmt.setInt(2, chapter.getIndex());
//			stmt.setString(3, chapter.getTitle());
//			stmt.setInt(4, chapter.getNumOfPages());
//			stmt.executeUpdate();
//		}
		stmt.close();
	}

}
