package br.com.cocodonto.frameworkdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoHelper {
	
	/**
	 * 	Fornece conexao com o banco de dados
	 * @return Connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException{
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
	 * tratando fechamento das conexoes
	 */
	public void release(Statement statement){
		//se nulo passa direto
		if(statement == null){
			return;
		}
		
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void release(Connection connection){
		if(connection == null){
			return;
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void release(ResultSet resultSet){
		if(resultSet == null){
			return;
		}
		
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void releaseAll(Connection connection, Statement statement){
		release(connection);
		release(statement);
	}
	
	public void releaseAll(Connection connection, Statement statement, ResultSet resultSet){
		releaseAll(connection, statement);
		release(resultSet);
	}

}
