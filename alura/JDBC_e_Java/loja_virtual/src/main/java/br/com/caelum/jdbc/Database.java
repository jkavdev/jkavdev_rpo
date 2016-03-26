package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/db_loja_virtual";
		String user = "root";
		String pass = "99346554";

		Connection connection = DriverManager.getConnection(url, user, pass);
		return connection;
	}

}
