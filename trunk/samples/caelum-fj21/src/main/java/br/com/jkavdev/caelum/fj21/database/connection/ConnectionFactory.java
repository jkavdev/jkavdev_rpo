package br.com.jkavdev.caelum.fj21.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private String password = "123456";
	private String user = "jkavdev";
	private String url = "jdbc:mysql://localhost:3306/db_caelum_fj21";

	public Connection getConnection() throws DaoException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			throw new DaoException(e);
		}
	}

}
