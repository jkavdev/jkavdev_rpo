package br.com.jkavdev.caelum.fj21.database.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.jkavdev.caelum.fj21.database.connection.DaoException;
import br.com.jkavdev.caelum.fj21.model.Contato;

public class ContatoDao {
	
	private Connection connection;
	
	private Logger logger = Logger.getLogger(ContatoDao.class);
	
	public ContatoDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Contato contato) throws DaoException{
		String sql = "insert into contatos "
				+ "(nome, email, endereco, dataNascimento) "
				+ "values(?, ?, ?, ?)";
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, contato.getNome());
			prepareStatement.setString(2, contato.getEmail());
			prepareStatement.setString(3, contato.getEndereco());
			prepareStatement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			prepareStatement.execute();
			prepareStatement.close();
			
		} catch (SQLException e) {
			logger.error("Contato não salvo: ", e);
			
			throw new DaoException("Contato não salvo", e);
		}
	}
	
	public List<Contato> getFindAll() throws DaoException{
		String sql = "select * from Contatos";
		List<Contato> contatos = new ArrayList<>();
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()){
				Contato contato = unmarshall(resultSet);
				
				contatos.add(contato);
			}
			
			resultSet.close();
			prepareStatement.close();
			
			return contatos;
		} catch (SQLException e) {
			logger.error("Nao foi possivel retornar registros: ", e);
			
			throw new DaoException(e);
		}
	}
	
	public List<Contato> findAllContatosByName(String nome) throws DaoException{
//		String sql = "select * from Contatos c where c.nome like ?" + "\"%\"";
		String sql = "select * from Contatos c where c.nome like ?";
		List<Contato> contatos = new ArrayList<>();
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, nome + "%");
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()){
				Contato contato = unmarshall(resultSet);
				
				contatos.add(contato);
			}
			
			resultSet.close();
			prepareStatement.close();
			
			return contatos;
		} catch (SQLException e) {
			logger.error("Nao foi possivel retornar registros: ", e);
			
			throw new DaoException(e);
		}
	}
	
	public Contato find(Long id){
		String sql = "select * from Contatos c where c.id = ?";
		Contato contato = null;
		
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
			logger.error("Nao foi possivel retornar registro: ", e);
			
			throw new DaoException(e);
		}
		
	}
	
	public void update(Contato contato){
		String sql = "update Contatos "
				+ "set nome = ?, email = ?, endereco = ?, dataNascimento = ? "
				+ "where id = ?";
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, contato.getNome());
			prepareStatement.setString(2, contato.getEmail());
			prepareStatement.setString(3, contato.getEndereco());
			prepareStatement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis())  );
			prepareStatement.setLong(5, contato.getId());
			
			prepareStatement.execute();
			prepareStatement.close();
		} catch (SQLException e) {
			logger.error("Nao foi possivel alterar o registro: ", e);
			
			throw new DaoException(e);
		}
	}
	
	public void remove(Contato contato){
		String sql = "delete from Contatos where id = ?";
		
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setLong(1, contato.getId());
			
			prepareStatement.execute();
			prepareStatement.close();
		} catch (SQLException e) {
			logger.error("Nao foi possivel remover o registro: ", e);

			throw new DaoException(e);
		}
	}

	public Contato unmarshall(ResultSet resultSet) throws SQLException {
		Contato contato = new Contato();
		contato.setId(resultSet.getLong("id"));
		contato.setNome(resultSet.getString("nome"));
		contato.setEmail(resultSet.getString("email"));
		contato.setEndereco(resultSet.getString("endereco"));
		
		Calendar data = Calendar.getInstance();
		data.setTime(resultSet.getDate("dataNascimento"));
		contato.setDataNascimento(data);
		return contato;
	}

}
