package br.com.jkavdev.cocodonto.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.jkavdev.cocodonto.model.entidade.Paciente;
import br.com.jkavdev.cocodonto.model.entidade.SexoType;
import br.com.jkavdev.cocodonto.model.framework.dao.CreateDaoException;
import br.com.jkavdev.cocodonto.model.framework.dao.DaoHelper;
import br.com.jkavdev.cocodonto.model.framework.dao.DeleteDaoException;
import br.com.jkavdev.cocodonto.model.framework.dao.QueryMapping;
import br.com.jkavdev.cocodonto.model.framework.dao.UpdateDaoException;

public class PacienteDao {

	private DaoHelper daoHelper;

	public PacienteDao() {
		daoHelper = new DaoHelper();
	}

	public void inserir(Paciente paciente) throws CreateDaoException {

		try {
			daoHelper.beginTransaction();

			String query = "insert into pacientes(nome, rg, cpf, sexo) values(?, ?, ?, ?)";
			long id = daoHelper.executePreparedUpdateAndReturnGeneratedKeys(query, paciente.getNome(), paciente.getRg(), paciente.getCpf(), paciente.getSexo().toString());

			paciente.setId(id);

			inserirPacienteEndereco(paciente);
			inserirPacienteContato(paciente);

			daoHelper.endTransaction();

		} catch (SQLException e) {
			daoHelper.rollbackTransaction();
			throw new CreateDaoException("Não foi possivel realizar a transacao!", e);
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

	public void atualizar(Paciente paciente) throws UpdateDaoException {
		try {
			daoHelper.beginTransaction();

			String query = "update paciente set nome = ?, rg = ?, cpf = ?, sexo = ? where id = ?";
			daoHelper.executePreparedUpdate(query, paciente.getNome(), paciente.getRg(), paciente.getCpf(), paciente.getSexo().toString(), paciente.getId());

			atualizarPacienteContato(paciente);
			atualizarPacienteEndereco(paciente);

			daoHelper.endTransaction();
		} catch (SQLException e) {
			daoHelper.rollbackTransaction();
			throw new UpdateDaoException("Nao foi possivel atualizar paciente!: ", e);
		}
	}

	private void atualizarPacienteEndereco(Paciente paciente) throws SQLException {
		EnderecoDao enderecoDao = new EnderecoDao();
		enderecoDao.atualizar(paciente.getEndereco());
	}

	private void atualizarPacienteContato(Paciente paciente) throws SQLException {
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.atualizar(paciente.getContato());
	}

	public void delete(Paciente paciente) throws DeleteDaoException {
		try {
			daoHelper.beginTransaction();

			String query = "delete from paciente where id = ?";
			daoHelper.executePreparedUpdate(query, paciente.getId());

			daoHelper.endTransaction();
		} catch (SQLException e) {
			daoHelper.rollbackTransaction();
			throw new DeleteDaoException("Nao foi possivel deletar paciente!: ", e);
		}
	}

	public List<Paciente> listaTodosPacientes() {
		final List<Paciente> pacientes = new ArrayList<>();
		try {
			String query = "select * from pacientes";
			daoHelper.executePreparedQuery(query, new QueryMapping<Paciente>() {

				@Override
				public void mapping(ResultSet resultSet) throws SQLException {
					while (resultSet.next()) {
						Paciente paciente = new Paciente();
						paciente.setId(resultSet.getLong("id"));
						paciente.setNome(resultSet.getString("nome"));
						paciente.setRg(resultSet.getString("rg"));
						paciente.setCpf(resultSet.getString("cpf"));
						paciente.setSexo(SexoType.valueOf(resultSet.getString("sexo")));
						pacientes.add(paciente);
					}
				}
			});
		} catch (SQLException e) {
			
		}
		return pacientes;
	}
}
