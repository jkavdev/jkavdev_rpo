package br.com.jkavdev.hibernate.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;

public class JdbcConfig {

	String user = "jkavdev";
	String url = "jdbc:mysql://localhost:3306/db_hibernate_recipes_books";
	String password = "123456";
	Connection connection = null;

	@Before
	public void init() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

}
