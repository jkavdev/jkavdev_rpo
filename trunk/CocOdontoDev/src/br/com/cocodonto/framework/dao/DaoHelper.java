package br.com.cocodonto.framework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoHelper {
	String pass = "123";
	String user = "user";
	String url = "jdbc:derby://localhost:1527/coc";
	String url1 = "jdbc:mysql://localhost:3306/db_cocodonto";
	String vendord = "org.apache.derby.jdbc.ClientDriver";
	String vendorm = "com.mysql.jdbc.Driver";

	/**
	 * Fornecer conexao ao banco de dados
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(vendorm);
			conn = DriverManager.getConnection(url1, "root", "99346554");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void release(Statement statement) {
		if (statement == null)
			return;
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void release(Connection conn) {
		if (conn == null)
			return;
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void release(ResultSet rs) {
		if (rs == null)
			return;
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void releaseAll(Connection conn, Statement stmt){
		release(conn);
		release(stmt);
	}
	
	public void releaseAll(Connection conn, Statement stmt, ResultSet rs){
		release(rs);
		releaseAll(conn, stmt);		
	}
	
}
