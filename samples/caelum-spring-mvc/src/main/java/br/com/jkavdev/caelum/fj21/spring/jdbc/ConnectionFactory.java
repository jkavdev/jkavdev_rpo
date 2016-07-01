package br.com.jkavdev.caelum.fj21.spring.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionFactory {

	private Logger logger = Logger.getLogger(ConnectionFactory.class);
	
	private String password = "123456";
	private String user = "jkavdev";
	private String url = "jdbc:mysql://localhost:3306/db_caelum_spring";

	public Connection getConnection() throws DaoException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			logger.info("Obtendo conexão connection=====================================================");
			
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			logger.error("Erro ao se conectar com o banco: ", e);
			
			throw new DaoException(e);
		}
	}

}
