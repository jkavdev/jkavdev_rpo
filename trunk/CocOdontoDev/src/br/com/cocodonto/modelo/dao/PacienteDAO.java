package br.com.cocodonto.modelo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.cocodonto.framework.dao.DaoHelper;
import br.com.cocodonto.modelo.entidade.Paciente;

public class PacienteDAO {
	
	private DaoHelper daoHelper;
	
	public PacienteDAO() {
		daoHelper = new DaoHelper();
	}
	
	public void inserir(Paciente paciente){				
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = daoHelper.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into paciente(nome, rg, cpf, sexo) "
					+ "values('"+paciente.getNome()+"', "
							+ "'"+paciente.getRg()+"', "
							+ "'"+paciente.getCpf()+"', "
							+ "'"+paciente.getSexo()+"')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			daoHelper.releaseAll(conn, stmt);
		}		
	}
}
