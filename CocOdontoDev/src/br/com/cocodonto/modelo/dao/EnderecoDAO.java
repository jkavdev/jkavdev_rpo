package br.com.cocodonto.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cocodonto.framework.dao.CreateDAOException;
import br.com.cocodonto.framework.dao.DAOHelper;
import br.com.cocodonto.modelo.entidade.Endereco;

public class EnderecoDAO {

	private DAOHelper daoHelper;

	public EnderecoDAO() {
		daoHelper = new DAOHelper();
	}

	public void inserir(Endereco endereco) throws CreateDAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = daoHelper.getConnection();
			String sql = "insert into endereco(endereco, cidade, bairro, cep) values(?, ?, ?, ?)";
			int index = 0;
			ps = conn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(++index, endereco.getEndereco());
			ps.setString(++index, endereco.getCidade());
			ps.setString(++index, endereco.getBairro());
			ps.setString(++index, endereco.getCep());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				endereco.setId(rs.getLong(1));
			}
		} catch (SQLException e) {
			throw new CreateDAOException("Nao foi possivel armazenar endereco "
					+ endereco, e);
		}
	}

}
