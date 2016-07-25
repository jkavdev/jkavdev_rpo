package br.com.jkavdev.persistence.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import br.com.jkavdev.persistence.util.jpa.JpaUtil;

public class TestDatasourceConnection {

	Connection connection;

	@Test
	public void testDataSourceConnection() {
		try {
			connection = JpaUtil.getConnection();

			System.out.println("Conectado!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
