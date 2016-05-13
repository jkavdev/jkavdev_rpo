package br.com.cocodonto.modelo.dao;

import java.sql.SQLException;

import br.com.cocodonto.framework.dao.DaoHelper;
import br.com.cocodonto.modelo.entidade.Contato;

public class ContatoDao {

	private DaoHelper daoHelper;

	public ContatoDao() {
		daoHelper = new DaoHelper();
	}

	public void inserir(Contato contato) throws SQLException {

		String query = "insert into contato(email, telefone, fax, celular) values(?, ?, ?, ?)";
		long id = 0;
		id = daoHelper.executePreparedUpdateAndReturnGeneratedKeys(query, contato.getEmail(), contato.getTelefone(),
				contato.getFax(), contato.getCelular());

		contato.setId(id);
	}

	public void atualizar(Contato contato) throws SQLException {
		String query = "update contato ser email = ?, celular = ?, telefone = ?, fax = ? where id = ?";
		daoHelper.executePreparedUpdate(query, contato.getEmail(), contato.getCelular(), contato.getTelefone(),
				contato.getFax(), contato.getId());
	}

	public void delete(Contato contato) throws SQLException {
		try {
			daoHelper.beginTransaction();

			String query = "delete from contato where id = ?";
			daoHelper.executePreparedUpdate(query, contato.getId());

			daoHelper.endTransaction();
		} catch (SQLException e) {
			daoHelper.rollbackTransaction();
		}
	}

}
