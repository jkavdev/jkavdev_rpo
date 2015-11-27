package br.com.cocodonto.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import br.com.cocodonto.framework.dao.CreateDAOException;
import br.com.cocodonto.framework.dao.DAOHelper;
import br.com.cocodonto.modelo.entidade.Paciente;

public class PacienteDAO {

	private DAOHelper daoHelper;

	public PacienteDAO() {
		daoHelper = new DAOHelper();
	}

	public void inserir(Paciente paciente) throws CreateDAOException {
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = daoHelper.getConnection();
			String sql = "insert into paciente(nome, rg, cpf, sexo) values(?, ?, ?, ?, ?)";
			int index = 0;

			ps = conn.prepareStatement(sql);
			ps.setString(++index, paciente.getNome());
			ps.setString(++index, paciente.getRg());
			ps.setString(++index, paciente.getCpf());
			ps.setString(++index, paciente.getSexo().toString());
			ps.setDate(++index, (java.sql.Date) new Date(paciente.getCricacao().getTime()));
			ps.executeUpdate();
			
			enderecoDAO.inserir(paciente.getEndereco());

		} catch (SQLException e) {
			throw new CreateDAOException(
					"Não foi Possivel realizar a transação! ", e);
		} finally {
			daoHelper.releaseAll(conn, ps);
		}
	}
}
