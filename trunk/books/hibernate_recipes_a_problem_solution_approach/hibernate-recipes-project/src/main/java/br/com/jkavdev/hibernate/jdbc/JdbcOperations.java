package br.com.jkavdev.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcOperations {

	public static void main(String[] args) throws SQLException {

		String user = "jkavdev";
		String url = "jdbc:mysql://localhost:3306/db_hibernate_recipes_books";
		String password = "123456";
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// selecionando todos os registros do banco
		String sql = "select * from book";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println("ISBN: " + resultSet.getString("isbn"));
		}

		resultSet.close();
		preparedStatement.close();

		// atualizando registro
		preparedStatement = connection.prepareStatement("UPDATE BOOK SET BOOK_NAME = ? WHERE ISBN = ?");
		preparedStatement.setString(1, "Hibernate Quickly 2nd Edition");
		preparedStatement.setString(2, "PBN456");
		
		int count = preparedStatement.executeUpdate();
		System.out.println("Updated count : " + count);
		preparedStatement.close();

		connection.close();

	}

}
