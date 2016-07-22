package br.com.jkavdev.javaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	String password = "123456";
	String user = "jkavdev";
	String url = "jdbc:mysql://localhost:3306/db_javaweb_agenda";

	public Connection getConnection() {

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
