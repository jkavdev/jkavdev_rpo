package br.com.cocodonto.framework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOHelper {

	private static final ThreadLocal<Connection> context = new ThreadLocal<>();

	/**
	 * Fornece conexao com o banco de dados
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db_cocodonto", "root",
					"99346554");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void beginTransaction() throws SQLException {
		Connection conn = getConnection();
		conn.setAutoCommit(false);
		context.set(conn);
	}

	public void endTransaction() throws SQLException {
		commit(getConnectionFromContext());
	}

	public void commit(Connection conn) throws SQLException {
		conn.commit();
		releaseTransaction();
	}

	public void releaseTransaction() throws SQLException {
		Connection conn = getConnectionFromContext();
		release(conn);
		context.remove();
	}

	public Connection getConnectionFromContext() throws SQLException {
		Connection conn = context.get();
		if (conn == null)
			throw new SQLException("Transação invalida!");
		if (conn.isClosed())
			throw new SQLException("Transação invalida! Conexao fechada");
		return conn;
	}

	public void release(Statement stmt) {
		if (stmt == null)
			return;
		try {
			stmt.close();
		} catch (SQLException e) {
		}
	}

	public void release(Connection conn) {
		if (conn == null)
			return;
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}

	public void release(ResultSet rs) {
		if (rs == null)
			return;
		try {
			rs.close();
		} catch (SQLException e) {
		}
	}

	public void releaseAll(Connection conn, Statement stmt) {
		release(conn);
		release(stmt);
	}

	public void releaseAll(Connection conn, Statement stmt, ResultSet rs) {
		release(rs);
		releaseAll(conn, stmt);
	}

}
