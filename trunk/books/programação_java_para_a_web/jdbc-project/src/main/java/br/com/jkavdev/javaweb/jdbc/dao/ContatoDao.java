package br.com.jkavdev.javaweb.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.jkavdev.javaweb.jdbc.JdbcConnection;
import br.com.jkavdev.javaweb.jdbc.model.Contato;

public class ContatoDao {

	Connection connection = null;

	public ContatoDao() {
		connection = new JdbcConnection().getConnection();
	}

	public void salvar(Contato contato) {
		PreparedStatement preparedStatement = null;
		String sql = "insert into contato(nome, telefone, email, data_cadastro, observacao) values(?, ?, ?, ?, ?)";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getTelefone());
			preparedStatement.setString(3, contato.getEmail());
			preparedStatement.setDate(4, new Date(contato.getDataCadastro()
					.getTime()));
			preparedStatement.setString(5, contato.getObservacao());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao incluir Contato: " + e.getMessage());

			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException ex) {
				System.out.println("Erro ao fechar operacoes: "
						+ e.getMessage());
			}
		}
	}

	public List<Contato> listar() {
		List<Contato> contatos = new ArrayList<Contato>();
		Statement statement = null;
		ResultSet resultSet = null;
		Contato contato = null;
		String sql = "select * from contato";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				contato = new Contato();
				contato.setCodigo(resultSet.getInt("codigo"));
				contato.setNome(resultSet.getString("nome"));
				contato.setTelefone(resultSet.getString("telefone"));
				contato.setEmail(resultSet.getString("email"));
				contato.setObservacao(resultSet.getString("observacao"));
				contato.setDataCadastro(new java.util.Date(resultSet.getDate(
						"data_cadastro").getTime()));

				contatos.add(contato);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar contato: " + e.getMessage());

			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException ex) {
				System.out.println("Erro ao fechar operacoes: "
						+ e.getMessage());
			}
		}

		return contatos;
	}

	public Contato buscarContato(int valor) {
		return null;

	}

	public void atualizar(Contato contato) {

	}

	public void excluir(Contato contato) {

	}

}
