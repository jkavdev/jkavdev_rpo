package br.com.jkavdev.fj21.jdbc.exemplo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.jkavdev.fj21.jdbc.util.ConnectionFactory;

public class JDBCInsere {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().getConnection()) {

			// cria um preparedStatement com o comando a ser executando
			String sql = "insert into contato(nome, email, endereco, data_nascimento) values(?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// preenche os valores
			preparedStatement.setString(1, "Caelum");
			preparedStatement.setString(2, "contato@caelum.com.br");
			preparedStatement.setString(3, "R. Vargueiro 3185 cj67");
			preparedStatement.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));

			// executa
			preparedStatement.execute();
			preparedStatement.close();

			System.out.println("Gravado");
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
