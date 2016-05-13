package br.com.cocodonto.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.cocodonto.modelo.entidade.Paciente;

public class PacienteDaoOld {

	public void inserir(Paciente paciente) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_coc_odonto", "root", "99346554");
			
			statement = connection.createStatement();
			String sql = "insert into paciente(nome, rg, cpf, sexo) values"
					+ "( '"+paciente.getNome()+"'"
							+ ", '"+paciente.getRg()+"'"
							+ ", '"+paciente.getCpf()+"'"
							+ ", '"+paciente.getSexo()+"')";
			
			statement.executeUpdate(sql);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally{
			if(statement != null){
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
