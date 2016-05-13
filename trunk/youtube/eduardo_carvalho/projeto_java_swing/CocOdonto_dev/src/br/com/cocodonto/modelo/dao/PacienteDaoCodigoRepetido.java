package br.com.cocodonto.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cocodonto.framework.dao.CreateDaoException;
import br.com.cocodonto.framework.dao.DaoHelper;
import br.com.cocodonto.modelo.entidade.Paciente;

public class PacienteDaoCodigoRepetido {

	private DaoHelper daoHelper;

	public PacienteDaoCodigoRepetido() {
		daoHelper = new DaoHelper();
	}

	public void inserir(Paciente paciente) throws CreateDaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		EnderecoDao enderecoDao = new EnderecoDao();

		try {
			daoHelper.beginTransaction();
			connection = daoHelper.getConnectionFromContext();

			int index = 0;
			String sql = "insert into paciente(nome, rg, cpf, sexo) values(?, ?, ?, ?)";
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			statement.setString(++index, paciente.getNome());
			statement.setString(++index, paciente.getRg());
			statement.setString(++index, paciente.getCpf());
			statement.setString(++index, paciente.getSexo().toString());

			statement.executeUpdate();

			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				paciente.setId(resultSet.getLong(1));
			}

			daoHelper.endTransaction();

		} catch (SQLException e) {
			throw new CreateDaoException("Não foi possivel realizar a transacao!", e);
		} finally {
			daoHelper.releaseAll(connection, statement);
		}
	}

	private void inserirPacienteEndereco(Paciente paciente) {
		EnderecoDao enderecoDao = new EnderecoDao();

		enderecoDao.inserir(paciente.getEndereco());

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			daoHelper.beginTransaction();
			connection = daoHelper.getConnectionFromContext();

			int index = 0;
			String sql = "insert into paciente_endereco(paciente_id, endereco_id) values(?, ?)";
			statement = connection.prepareStatement(sql);

			statement.setLong(++index, paciente.getId());
			statement.setLong(++index, paciente.getEndereco().getId());

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new CreateDaoException("Não foi possivel realizar a transacao!", e);
		} finally {
			daoHelper.releaseAll(connection, statement);
		}
	}

}
