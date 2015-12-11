package br.com.javaparaweb.capitulo3.crudjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContatoCrudJDBC {

	public void salvar(Contato contato) throws SQLException {
		Connection conexao = this.geraConexao();
		PreparedStatement ps = null;
		int index = 0;
		String sql = "insert into contato(nome, telefone, email, data_nascimento, observacao) values(?, ?, ?, ?, ?)";

		try {
			ps = conexao.prepareStatement(sql);
			ps.setString(++index, contato.getNome());
			ps.setString(++index, contato.getTelefone());
			ps.setString(++index, contato.getEmail());
			ps.setDate(++index, contato.getDataNascimento());
			ps.setString(++index, contato.getObservacao());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao incluir contato! " + e.getMessage());
		} finally {
			try {
				ps.close();
				conexao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar conexoes! " + e.getMessage());
			}
		}
	}

	public void atualizar(Contato contato) {
	}

	public void excluir(Contato contato) {
	}

	public List<Contato> listar() throws SQLException {
		Connection conexao = this.geraConexao();
		List<Contato> contatos = new ArrayList<>();
		Statement consulta = null;
		ResultSet resultado = null;
		Contato contato = null;
		String sql = "select * from Contato";

		try {
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);

			while (resultado.next()) {
				contato = new Contato();
				contato.setCodigo(resultado.getInt("codigo"));
				contato.setNome(resultado.getString("nome"));
				contato.setEmail(resultado.getString("email"));
				contato.setTelefone(resultado.getString("telefone"));
				contato.setObservacao(resultado.getString("observacao"));
				contato.setDataNascimento(resultado.getDate("data_nascimento"));
				contatos.add(contato);
			}			

		} catch (SQLException e) {
			System.out.println("Erro ao buscar codigo contato! " + e.getMessage());
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				System.out.println("Erro ao fechar conexoes! " + e.getMessage());
			}
		}
		return contatos;
	}

	public Contato buscaContato(int codigo) {
		return new Contato();
	}

	public Connection geraConexao() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/db_agenda";
		String usuario = "root";
		String senha = "99346554";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, usuario, senha);
	}

	public static void main(String[] args) throws SQLException {
		
		ContatoCrudJDBC contatoCrudJDBC = new ContatoCrudJDBC();
		
		Contato jhonatan = criaContato("jhonatan", "jhonatan@gmail.com", "99346554", "Novo Cliente");
		jhonatan.setDataNascimento(new Date(System.currentTimeMillis()));
		
		Contato lucas = criaContato("lucas", "lucas@gmail.com", "95546554", "Novo Cliente");
		lucas.setDataNascimento(new Date(System.currentTimeMillis()));
		
//		contatoCrudJDBC.salvar(lucas);
//		contatoCrudJDBC.salvar(jhonatan);
		
		System.out.println("Contatos salvos");
		
		List<Contato> contatos = contatoCrudJDBC.listar();
		
		for (Contato contato : contatos) {
			System.out.println("Nome : " + contato.getNome() + " - " + contato.getEmail());
		}

	}

	private static Contato criaContato(String nome, String email, String telefone, String obs) {
		Contato jhonatan = new Contato();
		jhonatan.setNome(nome);
		jhonatan.setEmail(email);
		jhonatan.setTelefone(telefone);
		jhonatan.setObservacao(obs);
		return jhonatan;
	}

}
