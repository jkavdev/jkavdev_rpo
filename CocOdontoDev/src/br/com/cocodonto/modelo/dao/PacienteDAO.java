package br.com.cocodonto.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.cocodonto.modelo.entidade.Paciente;

;

public class PacienteDAO {

	public void inserir(Paciente paciente) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/db_cocodonto");
			
			String sql = "insert into paciente(nome, rg, cpf, sexo) "
					+ "values('"+paciente.getNome()+"'"
							+ ", '"+paciente.getRg()+"'"
							+ ", '"+paciente.getCpf()+"'"
							+ ", '"+paciente.getSexo()+"')";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
