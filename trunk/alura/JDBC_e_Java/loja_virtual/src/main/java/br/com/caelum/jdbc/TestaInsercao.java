package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();

		// o mysql nao aceita o as simples inserido deste jeito
		// tem que ser feito com caractere de scape
		String nome = "notebook'i5 2013";
		String descricacao = "notebook i5 3 geracao";
		int index = 0;
		// para usar com preparedStatement usamos '?'
		String sql = "insert into produto (nome, descricao) values (?, ?)";

		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		//tratando os parametros passados
		statement.setString(++index, nome);
		statement.setString(++index, descricacao);

		boolean resultado = statement.execute(sql);
		System.out.println(resultado);

//		ResultSet resultSet = statement.getGeneratedKeys();
//
//		while (resultSet.next()) {
//			long id = resultSet.getLong("id");
//			System.out.println(id + " gerado");
//		}

		connection.close();

	}

}
