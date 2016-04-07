package br.com.jkavdev.jdbc.modelo;

import java.util.Date;

//classe representacao do banco

public class Contato {

	private Integer codigo;
	private String nome;
	private String email;
	private String telefone;
	private String observacao;
	private Date dataCadastro;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "codigo = " + codigo 
				+ ", nome = " + nome 
				+ ", email = " + email 
				+ ", telefone = " + telefone 
				+ ", observacao = " + observacao 
				+ ", dataCadastro = " + dataCadastro + "]";
	}
	
	

}
