package br.com.cocodonto.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.cocodonto.framework.dao.CreateDaoException;
import br.com.cocodonto.framework.dao.DaoHelper;
import br.com.cocodonto.modelo.entidade.Paciente;

public class PacienteDAO {

	private DaoHelper daoHelper;

	public PacienteDAO() {
		daoHelper = new DaoHelper();
	}

	public void inserir(Paciente paciente) throws CreateDaoException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = daoHelper.getConnection();
			int index = 0;
			String sql = "insert into paciente(nome, rg, cpf, sexo) " + "values(?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(++index, paciente.getNome());
			ps.setString(++index, paciente.getCpf());
			ps.setString(++index, paciente.getRg());
			ps.setString(++index, paciente.getSexo().toString());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new CreateDaoException("Não foi possível realizar a Transação", e);
		} finally {
			daoHelper.releaseAll(conn, ps);
		}
	}
}
