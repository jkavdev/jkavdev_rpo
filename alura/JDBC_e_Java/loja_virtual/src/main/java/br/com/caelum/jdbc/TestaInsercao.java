package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		// tentara abrir uma conexao e no final de tudo fechara esta conexao
		// automaticamente
		try (Connection connection = Database.getConnection()) {
			// desabilitando autocommit
			connection.setAutoCommit(false);

			int index = 0;
			String sql = "insert into produto (nome, descricao) values (?, ?)";

			// criara um statement e no final fechara automaticamente
			try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				adiciona("TV LCD", "32 Polegadas", index, sql, statement);
				adiciona("Bluray", "Full HDMI", index, sql, statement);

				// comitando operacao
				connection.commit();

			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
				System.out.println("Rollback Efetuado!");
			}
		}

	}

	private static void adiciona(String nome, String descricacao, int index, String sql, PreparedStatement statement)
			throws SQLException {

		if (nome.equals("blueray")) {
			throw new IllegalArgumentException("Problema Ocorrido!");
		}

		// tratando os parametros passados
		statement.setString(++index, nome);
		statement.setString(++index, descricacao);

		boolean resultado = statement.execute(sql);
		System.out.println(resultado);

		// ResultSet resultSet = statement.getGeneratedKeys();
		//
		// while (resultSet.next()) {
		// long id = resultSet.getLong("id");
		// System.out.println(id + " gerado");
		// }
		//
		// resultSet.close();
	}

}
