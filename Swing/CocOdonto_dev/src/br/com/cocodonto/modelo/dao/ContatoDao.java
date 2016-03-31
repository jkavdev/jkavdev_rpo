package br.com.cocodonto.modelo.dao;

import java.sql.SQLException;

import br.com.cocodonto.frameworkdao.DaoHelper;
import br.com.cocodonto.modelo.entidade.Contato;

public class ContatoDao {

	private DaoHelper daoHelper;

	public ContatoDao() {
		daoHelper = new DaoHelper();
	}
	
	public void inserir(Contato contato) throws SQLException{
		
		String query = "insert into contato(email, telefone, fax, celular) values(?, ?, ?, ?)";
		long id = 0;
		id = daoHelper.executePreparedUpdateAndReturnGeneratedKeys(query, contato.getEmail(), contato.getTelefone(), contato.getFax(), contato.getCelular());
		
		contato.setId(id);
	}

}
