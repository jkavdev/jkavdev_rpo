package br.com.cocodonto.frameworkdao;

import java.sql.Connection;
import java.sql.DriverManager;
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

	public void commit(Connection connection) throws SQLException {
		connection.commit();
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

}
