package br.com.jkavdev.jdbc.crudjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.jkavdev.jdbc.modelo.Contato;

public class ContatoCrudJDBC {

	public void salvar(Contato contato) {
		Connection conexao = this.geraConexao();
		PreparedStatement preparedStatement = null;
		String sql = "insert into contato(nome, telefone, email, data_cadastro, observacao) values(?, ?, ?, ?, ?)";

		try {
			preparedStatement = conexao.prepareStatement(sql);
			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getTelefone());
			preparedStatement.setString(3, contato.getEmail());
			preparedStatement.setDate(4, new Date(contato.getDataCadastro().getTime()));
			preparedStatement.setString(5, contato.getObservacao());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao incluir Contato: " + e.getMessage());
		} finally {
			try {
				preparedStatement.close();
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar operacoes: " + e.getMessage());
			}

		}
	}

	public void atualizar(Contato contato) {

	}

	public void excluir(Contato contato) {

	}

	public List<Contato> listar() {
		Connection conexao = this.geraConexao();
		List<Contato> contatos = new ArrayList<Contato>();
		Statement statement = null;
		ResultSet resultSet = null;
		Contato contato = null;
		String sql = "select * from contato";

		try {
			statement = conexao.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				contato = new Contato();
				contato.setCodigo(resultSet.getInt("codigo"));
				contato.setNome(resultSet.getString("nome"));
				contato.setTelefone(resultSet.getString("telefone"));
				contato.setEmail(resultSet.getString("email"));
				contato.setObservacao(resultSet.getString("observacao"));
				contato.setDataCadastro(new java.util.Date(resultSet.getDate("data_cadastro").getTime()));

				contatos.add(contato);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar contato: " + e.getMessage());
		} finally {
			try {
				resultSet.close();
				statement.close();
				conexao.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar operacoes: " + e.getMessage());
			}
		}

		return contatos;
	}

	public Contato buscaContato(int valor) {
		return null;

	}

	public Connection geraConexao() {
		Connection conexao = null;

		try {
			
			String url = "jdbc:mysql://localhost:3306/db_jpw_agenda";
			String usuario = "root";
			String senha = "99346554";
			
			conexao = DriverManager.getConnection(url, usuario, senha);
			
			System.out.println("Conectou");
		} catch (SQLException e) {
			System.out.println("Erro de Conexao: " + e);
		}
		
		return conexao;

	}

	public static void main(String[] args) {
		ContatoCrudJDBC contatoCrudJDBC = new ContatoCrudJDBC();

		// criando um contato
		Contato jhonatan = criarContato("Jhonatan", "jhonatan@gmail.com", "99346554", "Novo Cliente");
		Contato lucas = criarContato("Lucas", "lucas@gmail.com", "91940455", "Novo Cliente");
		Contato douglas = criarContato("Douglas", "douglas@gmail.com", "99220468", "Novo Cliente");
		
		contatoCrudJDBC.salvar(jhonatan);
		contatoCrudJDBC.salvar(lucas);
		contatoCrudJDBC.salvar(douglas);
		
		System.out.println("Contatos Cadastrados");
	}

	private static Contato criarContato(String nome, String telefone, String email, String observacao) {
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setTelefone(telefone);
		contato.setObservacao(observacao);
		contato.setDataCadastro(new java.util.Date(System.currentTimeMillis()));
		return contato;
	}

}
