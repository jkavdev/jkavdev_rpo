package br.com.cocodonto.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cocodonto.frameworkdao.CreateDaoException;
import br.com.cocodonto.frameworkdao.DaoHelper;
import br.com.cocodonto.modelo.entidade.Endereco;

public class EnderecoDao {

	private DaoHelper daoHelper;

	public EnderecoDao() {
		daoHelper = new DaoHelper();
	}

	public void inserir(Endereco endereco) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into endereco(endereco, cidade, bairro, cep) values(?, ?, ?, ?)";
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

}
