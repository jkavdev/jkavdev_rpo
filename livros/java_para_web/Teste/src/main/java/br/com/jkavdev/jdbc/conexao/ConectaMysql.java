package br.com.jkavdev.jdbc.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMysql {

	public static void main(String[] args) {

		Connection conexao = null;

		try {
			
			//dados para acesso ao banco
			String url = "jdbc:mysql://localhost:3306/db_jpw_agenda";
			String usuario = "root";
			String senha = "99346554";
			
			//registrando conexao
			conexao = DriverManager.getConnection(url, usuario, senha);
			
			System.out.println("Conectou");
			
			//fechando conexao
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro de Conexao: " + e);
		}

	}

}
