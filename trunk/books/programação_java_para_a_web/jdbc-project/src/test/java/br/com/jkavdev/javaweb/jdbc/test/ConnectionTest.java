package br.com.jkavdev.javaweb.jdbc.test;

import java.sql.Connection;

import org.junit.Test;

import br.com.jkavdev.javaweb.jdbc.JdbcConnection;

public class ConnectionTest {

	@Test
	public void connectionTest() {

		Connection connection = new JdbcConnection().getConnection();

		System.out.println("Conectado");

	}

}
