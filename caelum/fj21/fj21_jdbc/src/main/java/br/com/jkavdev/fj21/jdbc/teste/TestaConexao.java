package br.com.jkavdev.fj21.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.jkavdev.fj21.jdbc.util.ConnectionFactory;

public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionFactory().getConnection();
		
		System.out.println("Conexao Aberta!");;
		connection.close();
		
	}

}
