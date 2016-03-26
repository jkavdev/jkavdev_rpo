package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();

		String sql = "insert into Produto(nome, descricao) values('Notebook', 'Notebook i5')";

		Statement statement = connection.createStatement();
		boolean resultado = statement.execute(sql, Statement.RETURN_GENERATED_KEYS);
		System.out.println(resultado);

		ResultSet resultSet = statement.getGeneratedKeys();

		while (resultSet.next()) {
			long id = resultSet.getLong("id");
			System.out.println(id + " gerado");
		}

		connection.close();

	}

}
