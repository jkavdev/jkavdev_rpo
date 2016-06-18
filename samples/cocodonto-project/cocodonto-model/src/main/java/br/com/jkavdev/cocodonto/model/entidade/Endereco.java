package br.com.jkavdev.cocodonto.model.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.cocodonto.model.util.jpa.BaseEntity;

@Entity
@Table(name = "enderecos")
public class Endereco extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String endereco;
	private String cidade;
	private String bairro;
	private String cep;

	public Endereco() {
	}

	public Endereco(String endereco, String cidade, String bairro, String cep) {
		this();
		this.endereco = endereco;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
	}

	@Column(nullable = false)
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(nullable = false)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(nullable = false)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(nullable = false)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}