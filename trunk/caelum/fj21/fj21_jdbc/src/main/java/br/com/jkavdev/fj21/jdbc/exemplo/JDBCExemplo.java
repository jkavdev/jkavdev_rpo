package br.com.jkavdev.fj21.jdbc.exemplo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.jkavdev.fj21.jdbc.util.ConnectionFactory;

public class JDBCExemplo {
	
	//checked exception
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//para versoes do java 5 e inferiores
		//registrando o driver do mysql
		Class.forName("com.mysql.jdbc.Driver");
		
		//conectando ao banco
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_fj21", "root", "99346554");
		
		//usando a fabrica de Conexao
		Connection connection = new ConnectionFactory().getConnection();
		
		System.out.println("Conectado!");
		//fechando conexao
		connection.close();
		
	}

}
