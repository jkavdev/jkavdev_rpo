package br.com.cocodonto.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.cocodonto.modelo.entidade.Paciente;

public class PacienteDAO {	
	public void inserir(Paciente paciente){		
		String pass = "123";
		String user = "user";
		String url = "jdbc:derby://localhost:1527/coc";
		String url1 = "jdbc:mysql://localhost:3306/db_cocodonto";
		String vendord = "org.apache.derby.jdbc.ClientDriver";
		Connection conn = null;
		Statement stmt = null;
		try {
			
			String vendorm = "com.mysql.jdbc.Driver";			
			Class.forName(vendorm);
			conn = DriverManager.getConnection(url1, "root", "99346554");
			stmt = conn.createStatement();
			String sql = "insert into paciente(nome, rg, cpf, sexo) "
					+ "values('"+paciente.getNome()+"', "
							+ "'"+paciente.getRg()+"', "
							+ "'"+paciente.getCpf()+"', "
							+ "'"+paciente.getSexo()+"')";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}
}
