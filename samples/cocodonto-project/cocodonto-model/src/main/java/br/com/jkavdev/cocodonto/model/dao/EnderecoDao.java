package br.com.jkavdev.cocodonto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.jkavdev.cocodonto.model.entidade.Endereco;
import br.com.jkavdev.cocodonto.model.framework.dao.CreateDaoException;
import br.com.jkavdev.cocodonto.model.framework.dao.DaoHelper;

public class EnderecoDao {

	private DaoHelper daoHelper;

	public EnderecoDao() {
		daoHelper = new DaoHelper();
	}

	public void inserir(Endereco endereco) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into enderecos(endereco, cidade, bairro, cep) values(?, ?, ?, ?)";
			connection = daoHelper.getConnection();
			preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			int index = 0;
			preparedStatement.setString(++index, endereco.getEndereco());
			preparedStatement.setString(++index, endereco.getCidade());
			preparedStatement.setString(++index, endereco.getBairro());
			preparedStatement.setString(++index, endereco.getCep());

			preparedStatement.executeUpdate();

			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				endereco.setId(generatedKeys.getLong(1));
			}

		} catch (SQLException e) {
			throw new CreateDaoException("Nao foi possivel armazenar Endereco: " + e);
		}
	}

	public void atualizar(Endereco endereco) throws SQLException {
		String query = "update enderecos set endereco = ?, cidade = ?, bairro = ?, cep = ? where id = ?";
		daoHelper.executePreparedUpdate(query, endereco.getEndereco(), endereco.getCidade(), endereco.getBairro(), endereco.getCep());
	}

	public void delete(Endereco endereco) throws SQLException {

		try {
			daoHelper.beginTransaction();

			String query = "delete from enderecos  where id = ?";
			daoHelper.executePreparedUpdate(query, endereco.getId());

			daoHelper.endTransaction();
		} catch (SQLException e) {
			daoHelper.rollbackTransaction();
		}
	}

}
