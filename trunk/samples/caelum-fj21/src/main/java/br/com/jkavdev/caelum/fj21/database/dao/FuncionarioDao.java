package br.com.jkavdev.caelum.fj21.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.jkavdev.caelum.fj21.database.connection.ConnectionFactory;
import br.com.jkavdev.caelum.fj21.database.connection.DaoException;
import br.com.jkavdev.caelum.fj21.model.Funcionario;

public class FuncionarioDao {
	
	private Connection connection;
	
	public FuncionarioDao() throws DaoException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insert(Funcionario funcionario) throws DaoException{
		String sql = "insert into Funcionarios "
				+ "(nome, usuario, senha) "
				+ "values(?, ?, ?)";
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, funcionario.getNome());
			prepareStatement.setString(2, funcionario.getSenha());
			prepareStatement.setString(3, funcionario.getUsuario());
			
			prepareStatement.execute();
			prepareStatement.close();
			
		} catch (SQLException e) {
			throw new DaoException("Funcionario não salvo", e);
		}
	}
	
	public List<Funcionario> findAll() throws DaoException{
		String sql = "select * from Funcionarios";
		List<Funcionario> Funcionarios = new ArrayList<>();
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()){
				Funcionario contato = unmarshall(resultSet);
				
				Funcionarios.add(contato);
			}
			
			resultSet.close();
			prepareStatement.close();
			
			return Funcionarios;
		} catch (SQLException e) {
			System.out.println("Nao foi possivel retornar registros");
			throw new DaoException(e);
		}
	}
	
	public List<Funcionario> findAllFuncionariosByName(String nome) throws DaoException{
//		String sql = "select * from Funcionarios c where c.nome like ?" + "\"%\"";
		String sql = "select * from Funcionarios f where f.nome like ?";
		List<Funcionario> Funcionarios = new ArrayList<>();
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, nome + "%");
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()){
				Funcionario contato = unmarshall(resultSet);
				
				Funcionarios.add(contato);
			}
			
			resultSet.close();
			prepareStatement.close();
			
			return Funcionarios;
		} catch (SQLException e) {
			System.out.println("Nao foi possivel retornar registros");
			throw new DaoException(e);
		}
	}
	
	public Funcionario find(Long id){
		String sql = "select * from Funcionarios c where c.id = ?";
		Funcionario contato = null;
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, id);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()){
				contato = unmarshall(resultSet);
			}
			
			resultSet.close();
			prepareStatement.close();
			
			return contato;
		} catch (SQLException e) {
			System.out.println("Nao foi possivel retornar registros");
			throw new DaoException(e);
		}
		
	}
	
	public void update(Funcionario funcionario){
		String sql = "update Funcionarios "
				+ "set nome = ?, usuario = ?, senha = ?"
				+ "where id = ?";
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, funcionario.getNome());
			prepareStatement.setString(2, funcionario.getSenha());
			prepareStatement.setString(3, funcionario.getUsuario());
			prepareStatement.setLong(4, funcionario.getId());
			
			prepareStatement.execute();
			prepareStatement.close();
		} catch (SQLException e) {
			System.out.println("Nao foi possivel alterar o registro");
			throw new DaoException(e);
		}
	}
	
	public void remove(Funcionario funcionario){
		String sql = "delete from Funcionarios where id = ?";
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, funcionario.getId());
			
			prepareStatement.execute();
			prepareStatement.close();
		} catch (SQLException e) {
			System.out.println("Nao foi possivel remover o registro");
			throw new DaoException(e);
		}
	}

	public Funcionario unmarshall(ResultSet resultSet) throws SQLException {
		Funcionario funcionario = new Funcionario();
		funcionario.setId(resultSet.getLong("id"));
		funcionario.setNome(resultSet.getString("nome"));
		funcionario.setSenha(resultSet.getString("senha"));
		funcionario.setUsuario(resultSet.getString("usuario"));
		
		return funcionario;
	}
	
	

}
