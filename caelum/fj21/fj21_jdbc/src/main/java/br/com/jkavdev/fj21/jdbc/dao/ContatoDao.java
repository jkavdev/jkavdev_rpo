package br.com.jkavdev.fj21.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.jkavdev.fj21.jdbc.modelo.Contato;
import br.com.jkavdev.fj21.jdbc.util.ConnectionFactory;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		try {
			String sql = "insert into contato(nome, email, endereco, data_nascimento) values(?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// preenche os valores
			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getEmail());
			preparedStatement.setString(3, contato.getEndereco());
			preparedStatement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			// executa
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
