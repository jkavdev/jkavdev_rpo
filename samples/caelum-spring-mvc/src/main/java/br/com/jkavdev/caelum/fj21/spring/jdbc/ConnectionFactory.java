package br.com.jkavdev.caelum.fj21.spring.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionFactory {

	private static final Logger logger = Logger.getLogger(ConnectionFactory.class);

	private static final String password = "123456";
	private static final String user = "jkavdev";
	private static final String url = "jdbc:mysql://localhost:3306/db_caelum_spring";

	public static Connection getConnection() throws ConnectionFactoryException {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			logger.info("Obtendo connection===============");

			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			logger.error("Erro ao se conectar com o banco: ", e);

			throw new ConnectionFactoryException(e);
		}
	}

}
