package br.com.jkavdev.caelum.fj21.database.connection;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionFactoryTest {

	@Test
	public void testConnection() {
		try {
			Connection connection = new ConnectionFactory().getConnection();

			System.out.println("Conexao aberta");

			connection.close();
			
		} catch (DaoException e) {
			System.out.println("Erro ao abrir conecão:");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro ao fechar conecão:");
			e.printStackTrace();
		}
	}

}
