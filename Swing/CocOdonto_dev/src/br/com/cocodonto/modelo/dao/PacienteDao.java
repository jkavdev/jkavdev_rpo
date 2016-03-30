package br.com.cocodonto.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.cocodonto.frameworkdao.CreateDaoException;
import br.com.cocodonto.frameworkdao.DaoHelper;
import br.com.cocodonto.modelo.entidade.Paciente;

public class PacienteDao {

	private DaoHelper daoHelper;

	public PacienteDao() {
		daoHelper = new DaoHelper();
	}

	public void inserir(Paciente paciente) throws CreateDaoException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = daoHelper.getConnection();

			int index = 0;
			String sql = "insert int paciente(nome, rg, cpf, sexo) values(?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);

			statement.setString(++index, paciente.getNome());
			statement.setString(++index, paciente.getRg());
			statement.setString(++index, paciente.getCpf());
			statement.setString(++index, paciente.getSexo().toString());

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new CreateDaoException("Não foi possivel realizar a transacao!", e);
		} finally {
			daoHelper.releaseAll(connection, statement);
		}
	}

}
