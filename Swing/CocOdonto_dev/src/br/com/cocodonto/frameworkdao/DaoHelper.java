package br.com.cocodonto.frameworkdao;

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
	public long executePreparedUpdateAndReturnGeneratedKeys(Connection connection, String query, Object... params)
			throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		long result = 0;

		try {
			preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			int index = 0;
			for (Object param : params) {
				preparedStatement.setObject(++index, param);
			}

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

	public void executePreparedUpdate(Connection connection, String query, Object... params) throws SQLException {
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(query);
			int index = 0;
			for (Object param : params) {
				preparedStatement.setObject(++index, param);
			}

			preparedStatement.executeUpdate();
		} finally {
			release(preparedStatement);
		}
	}
}
