package br.com.jkavdev.fj21.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.jkavdev.fj21.jdbc.modelo.Contato;
import br.com.jkavdev.fj21.jdbc.util.ConnectionFactory;
import br.com.jkavdev.fj21.jdbc.util.DaoException;

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

	public List<Contato> getLista() {
		try {
//			PreparedStatement preparedStatement = this.connection.prepareStatement("select * from contato where nome like 'C%'");
			PreparedStatement preparedStatement = this.connection.prepareStatement("select * from contato");
			ResultSet resultSet = preparedStatement.executeQuery();

			List<Contato> contatos = new ArrayList<Contato>();

			while (resultSet.next()) {
				// criando o objeto Contato
				Contato contato = new Contato();
				contato.setNome(resultSet.getString("nome"));
				contato.setEmail(resultSet.getString("email"));
				contato.setEndereco(resultSet.getString("endereco"));

				// montando a data atraves do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(resultSet.getDate("data_nascimento"));

				contato.setDataNascimento(data);

				// adiciona Objeto na lista
				contatos.add(contato);
			}

			resultSet.close();
			preparedStatement.close();

			return contatos;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public Contato pesquisar(Long id) {
		String sql = "select * from contato where id = ? ";
		Contato contato = null;
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				contato = new Contato();
				Calendar data = Calendar.getInstance();
				data.setTime(resultSet.getDate("data_nascimento"));

				contato.setId(resultSet.getLong("id"));
				contato.setNome(resultSet.getString("nome"));
				contato.setEmail(resultSet.getString("email"));
				contato.setEndereco(resultSet.getString("endereco"));
				contato.setDataNascimento(data);
			}

			resultSet.close();
			preparedStatement.close();

			return contato;

		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public void alterar(Contato contato) {

		try {
			String sql = "update contato set nome = ?, email =?, endereco = ?, data_nascimento = ? where id = ?";
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getEmail());
			preparedStatement.setString(3, contato.getEndereco());
			preparedStatement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			preparedStatement.setLong(5, contato.getId());

			preparedStatement.execute();

			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	public void remove(Contato contato) {
		try {
			String sql = "delete from contato where id = ?";
			PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.setLong(1, contato.getId());

			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
