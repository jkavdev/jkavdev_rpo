package br.com.jkavdev.cocodonto.model.dao;

import java.sql.SQLException;

import br.com.jkavdev.cocodonto.model.entidade.Contato;
import br.com.jkavdev.cocodonto.model.framework.dao.DaoHelper;

public class ContatoDao {

	private DaoHelper daoHelper;

	public ContatoDao() {
		daoHelper = new DaoHelper();
	}

	public void inserir(Contato contato) throws SQLException {

		String query = "insert into contatos(email, telefone, celular) values(?, ?, ?)";
		long id = 0;
		id = daoHelper.executePreparedUpdateAndReturnGeneratedKeys(query, contato.getEmail(), contato.getTelefone(), contato.getCelular());

		contato.setId(id);
	}

	public void atualizar(Contato contato) throws SQLException {
		String query = "update contatos ser email = ?, celular = ?, telefone = ? where id = ?";
		daoHelper.executePreparedUpdate(query, contato.getEmail(), contato.getCelular(), contato.getTelefone(), contato.getId());
	}

	public void delete(Contato contato) throws SQLException {
		try {
			daoHelper.beginTransaction();

			String query = "delete from contatos where id = ?";
			daoHelper.executePreparedUpdate(query, contato.getId());

			daoHelper.endTransaction();
		} catch (SQLException e) {
			daoHelper.rollbackTransaction();
		}
	}

}
