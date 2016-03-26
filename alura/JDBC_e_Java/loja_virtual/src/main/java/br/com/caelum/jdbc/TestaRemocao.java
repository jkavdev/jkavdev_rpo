package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = Database.getConnection();
		
		String sql = "delete from Produto where id > 3";
		
		Statement statement = connection.createStatement();
		statement.execute(sql);
		//mostra quantos registros foram atualizados
		int count = statement.getUpdateCount();
		System.out.println(count + " linha atualizada");
		
		connection.close();
		
	}

}
