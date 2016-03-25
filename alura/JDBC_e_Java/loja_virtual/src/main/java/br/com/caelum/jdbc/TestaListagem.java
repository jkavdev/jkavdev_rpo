package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/db_loja_virtual";
		String user = "root";
		String pass = "99346554";

		Connection connection = DriverManager.getConnection(url, user, pass);

		String sql = "select * from produto";

		Statement statement = connection.createStatement();
		// indica que retornou uma lista com registros
		boolean resultado = statement.execute(sql);
		System.out.println(resultado);
		// lista com registros
		ResultSet resultSet = statement.getResultSet();

		// o resultset inicia antes do primeiro registro
		// podemos indicar se ha registros com o next
		// que retorna um boolean se há ou nao um proximo registro

		// enquanto tiver um registro
		// fara o loop apresentando os dados
		while (resultSet.next()) {
			String nome = resultSet.getString("nome");
			String descricao = resultSet.getString("decricao");
			int id = resultSet.getInt("id");
			System.out.println(id + " - " + nome + " - " + descricao);
		}

		resultSet.close();
		statement.close();
		connection.close();

	}

}
