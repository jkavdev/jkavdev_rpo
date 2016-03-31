package br.com.cocodonto.modelo.dao;

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

		try {
			daoHelper.beginTransaction();

			String query = "insert into paciente(nome, rg, cpf, sexo) values(?, ?, ?, ?)";
			long id = daoHelper.executePreparedUpdateAndReturnGeneratedKeys(query, paciente.getNome(),
					paciente.getRg(), paciente.getCpf(), paciente.getSexo().toString());

			paciente.setId(id);

			inserirPacienteEndereco(paciente);
			inserirPacienteContato(paciente);

			daoHelper.endTransaction();

		} catch (SQLException e) {
			daoHelper.rollbackTransaction();
			throw new CreateDaoException("Não foi possivel realizar a transacao!", e);
		} finally {
		}
	}

	private void inserirPacienteEndereco(Paciente paciente) throws SQLException {
		EnderecoDao enderecoDao = new EnderecoDao();
		enderecoDao.inserir(paciente.getEndereco());

		String query = "insert into paciente_endereco(paciente_id, endereco_id) values(?, ?)";

		daoHelper.executePreparedUpdate(query, paciente.getId(), paciente.getEndereco().getId());
	}

	private void inserirPacienteContato(Paciente paciente) throws SQLException {
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.inserir(paciente.getContato());

		String query = "insert into paciente_contato(paciente_id, contato_id) values(?, ?)";

		daoHelper.executePreparedUpdate(query, paciente.getId(), paciente.getContato().getId());
	}
}
