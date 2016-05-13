package br.com.cocodonto.framework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoHelper {

	private static final ThreadLocal<Connection> context = new ThreadLocal<>();

	/**
	 * Fornece conexao com o banco de dados
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_coc_odonto", "root", "99346554");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * controle de transacao
	 * 
	 * @throws SQLException
	 */
	public void beginTransaction() throws SQLException {
		Connection connection = getConnection();
		connection.setAutoCommit(false);
		context.set(connection);
	}

	public void endTransaction() throws SQLException {
		commit(getConnectionFromContext());
		releaseTransaction();
	}

	public void releaseTransaction() throws SQLException {
		Connection connection = getConnectionFromContext();
		release(connection);
		context.remove();
	}

	public void rollbackTransaction() {
		Connection connection;
		try {
			connection = getConnectionFromContext();
			rollback(connection);
			release(connection);
			context.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void commit(Connection connection) throws SQLException {
		connection.commit();
	}

	public void rollback(Connection connection) throws SQLException {
		if (connection != null) {
			connection.rollback();
		}
	}

	public Connection getConnectionFromContext() throws SQLException {
		Connection connection = context.get();
		if (connection == null) {
			throw new SQLException("Transacao Invalida!");
		}
		if (connection.isClosed()) {
			throw new SQLException("Transacao Invalida!, Conexão esta fechada!");
		}
		return connection;
	}

	/**
	 * tratando fechamento das conexoes
	 */
	public void release(Statement statement) {
		// se nulo passa direto
		if (statement == null) {
			return;
		}

		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void release(Connection connection) {
		if (connection == null) {
			return;
		}

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void release(ResultSet resultSet) {
		if (resultSet == null) {
			return;
		}

		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void releaseAll(Connection connection, Statement statement) {
		release(connection);
		release(statement);
	}

	public void releaseAll(Connection connection, Statement statement, ResultSet resultSet) {
		releaseAll(connection, statement);
		release(resultSet);
	}

	/**
	 * controlando chaves e conteudos a serem persistidos
	 * 
	 * @throws SQLException
	 */
	public long executePreparedUpdateAndReturnGeneratedKeys(String query, Object... params) throws SQLException {
		return executePreparedUpdateAndReturnGeneratedKeys(getConnectionFromContext(), query, params);
	}

	public long executePreparedUpdateAndReturnGeneratedKeys(Connection connection, String query, Object... params)
			throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		long result = 0;

		try {
			preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			populatePreparedStatement(preparedStatement, params);

			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				result = resultSet.getLong(1);
			}
		} finally {
			release(preparedStatement);
			release(resultSet);
		}

		return result;
	}

	public void executePreparedUpdate(String query, Object... params) throws SQLException {
		executePreparedUpdate(getConnectionFromContext(), query, params);
	}

	public void executePreparedUpdate(Connection connection, String query, Object... params) throws SQLException {
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(query);
			populatePreparedStatement(preparedStatement, params);

			preparedStatement.executeUpdate();
		} finally {
			release(preparedStatement);
		}
	}

	private void populatePreparedStatement(PreparedStatement preparedStatement, Object... params) throws SQLException {
		int index = 0;
		for (Object param : params) {
			preparedStatement.setObject(++index, param);
		}
	}

	public <T> void executePreparedQuery(String query, QueryMapping<T> queryMapping) throws SQLException {
		executePreparedQuery(getConnection(), query, queryMapping);
	}

	public <T> void executePreparedQuery(Connection connection, String query, QueryMapping<T> queryMapping) throws SQLException {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			queryMapping.mapping(resultSet);
		} finally {
			release(resultSet);
			release(statement);
		}
	}

	public <T> void executePreparedQuery(String query, QueryMapping<T> queryMapping, Object... params)
			throws SQLException {
		executePreparedQuery(getConnection(), query, queryMapping, params);
	}

	public <T> void executePreparedQuery(Connection connection, String query, QueryMapping<T> queryMapping, Object... params) throws SQLException {
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		ResultSet resultSet = null;		
		try {
			prepareStatement = connection.prepareStatement(query);
			populatePreparedStatement(prepareStatement, params);	
			resultSet = prepareStatement.getResultSet();
			queryMapping.mapping(resultSet);
		} finally {
			release(resultSet);
			release(prepareStatement);
		}
	}

}
