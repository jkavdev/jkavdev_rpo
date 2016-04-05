package br.com.jkavdev.fj21.jdbc.modelo;

//javabeans sao classes que possuem o construtor sem argumentos e metodos
//de acesso do tipo get e set

import java.util.Calendar;

public class Contato {

	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;

	public Contato(String nome, String email, String endereco, Calendar dataNascimento) {
		this();
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}

	public Contato(Long id, String nome, String email, String endereco, Calendar dataNascimento) {
		this(nome, email, endereco, dataNascimento);
		this.id = id;
	}

	public Contato() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contato [id=").append(id)
				.append(", nome=").append(nome)
				.append(", email=").append(email)
				.append(", endereco=").append(endereco)
				.append(", dataNascimento=").append(dataNascimento).append("]");
		return builder.toString();
	}

}
