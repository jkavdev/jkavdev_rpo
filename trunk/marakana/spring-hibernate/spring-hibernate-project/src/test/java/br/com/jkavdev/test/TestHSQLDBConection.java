package br.com.jkavdev.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestHSQLDBConection {

	public static void main(String[] args) {

		String password = "123456";
		String user = "jkavdev";
		String url = "jdbc:hsqldb:file:target/data/spring-hibernatedb";

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");

			try (Connection connection = DriverManager.getConnection(url, user, password)) {

				System.out.println("Conectado");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
