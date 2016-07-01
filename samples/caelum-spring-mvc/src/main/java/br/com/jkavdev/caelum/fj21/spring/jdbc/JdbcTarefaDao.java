package br.com.jkavdev.caelum.fj21.spring.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.jkavdev.caelum.fj21.spring.model.Tarefa;

public class JdbcTarefaDao {

	private Connection connection = null;
	
	public JdbcTarefaDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	private Logger logger = Logger.getLogger(JdbcTarefaDao.class);

	public void insert(Tarefa tarefa) throws DaoException {
		String sql = "insert into Tarefas " + "(descricao, finalizado, dataFinalizacao) " + "values(?, ?, ?)";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, tarefa.getDescricao());
			prepareStatement.setBoolean(2, tarefa.isFinalizado());
			prepareStatement.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));

			prepareStatement.execute();
			prepareStatement.close();

		} catch (SQLException e) {
			logger.error(e);
			
			throw new DaoException(e);
		}
	}

	public List<Tarefa> getFindAll() throws DaoException {
		String sql = "select * from Tarefas";
		List<Tarefa> Tarefas = new ArrayList<>();

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				Tarefa Tarefa = unmarshall(resultSet);

				Tarefas.add(Tarefa);
			}

			resultSet.close();
			prepareStatement.close();

			return Tarefas;
		} catch (SQLException e) {
			logger.error(e);
			
			throw new DaoException(e);
		}
	}

	public Tarefa find(Long id) throws DaoException {
		String sql = "select * from Tarefas c where c.id = ?";
		Tarefa Tarefa = null;

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, id);
			ResultSet resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				Tarefa = unmarshall(resultSet);
			}

			resultSet.close();
			prepareStatement.close();

			return Tarefa;
		} catch (SQLException e) {
			logger.error(e);
			
			throw new DaoException(e);
		}

	}

	public void remove(Tarefa Tarefa) throws DaoException {
		String sql = "delete from Tarefas where id = ?";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, Tarefa.getId());

			prepareStatement.execute();
			prepareStatement.close();
		} catch (SQLException e) {
			logger.error(e);
			
			throw new DaoException(e);
		}
	}

	public Tarefa unmarshall(ResultSet resultSet) throws SQLException {
		Tarefa Tarefa = new Tarefa();
		Tarefa.setId(resultSet.getLong("id"));
		Tarefa.setDescricao(resultSet.getString("descricao"));
		Tarefa.setFinalizado(resultSet.getBoolean("finalizado"));

		Calendar data = Calendar.getInstance();
		data.setTime(resultSet.getDate("dataNascimento"));
		Tarefa.setDataFinalizacao(data);
		return Tarefa;
	}

}
