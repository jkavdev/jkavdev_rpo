package br.com.jkavdev.facesmotors.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.jkavdev.facesmotors.dao.AutomovelDao;
import br.com.jkavdev.facesmotors.model.Automovel;

public class JdbcAutomovelDao implements AutomovelDao {
	
	Connection connection = new ConnectionFactory().getConnection();

	@Override
	public void salva(Automovel automovel) {
		
		String sql = "insert into automoveis " + "(ano_fabricacao, ano_modelo, marca, modelo, observacoes)"
				+ " values (?, ?, ?, ?, ?)";

		try {
			PreparedStatement pst = null;
			pst = connection.prepareStatement(sql);
			pst.setInt(1, automovel.getAnoFabricacao());
			pst.setInt(2, automovel.getAnoModelo());
			pst.setString(3, automovel.getMarca());
			pst.setString(4, automovel.getModelo());
			pst.setString(5, automovel.getObservacoes());
			pst.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public List<Automovel> lista() {
		List<Automovel> automoveis = new ArrayList<Automovel>();
		String sql = "select * from Automoveis";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Automovel automovel = new Automovel();
				automovel.setId(resultSet.getLong("id"));
				automovel.setAnoFabricacao(resultSet.getInt("ano_fabricacao"));
				automovel.setAnoModelo(resultSet.getInt("ano_modelo"));
				automovel.setMarca(resultSet.getString("marca"));
				automovel.setModelo(resultSet.getString("modelo"));
				automovel.setObservacoes(resultSet.getString("observacoes"));
				automoveis.add(automovel);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return automoveis;
	}

}
