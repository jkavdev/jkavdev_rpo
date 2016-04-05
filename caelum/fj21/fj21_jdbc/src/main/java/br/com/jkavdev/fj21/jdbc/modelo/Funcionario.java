package br.com.jkavdev.fj21.jdbc.modelo;

public class Funcionario {

	private Long id;
	private String nome;
	private String usuario;
	private String senha;

	public Funcionario() {
	}

	public Funcionario(Long id, String nome, String usuario, String senha) {
		this(nome, usuario, senha);
		this.id = id;
	}

	public Funcionario(String nome, String usuario, String senha) {
		this();
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
