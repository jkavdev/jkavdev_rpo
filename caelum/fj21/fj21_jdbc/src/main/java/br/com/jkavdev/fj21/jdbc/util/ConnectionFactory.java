package br.com.jkavdev.fj21.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/db_fj21";
			String password = "99346554";
			String user = "root";
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			//lancando uma runtime, indicando que o codigo nao fico
			//acoplado com o sql
			throw new RuntimeException(e);
		}
	}

}
