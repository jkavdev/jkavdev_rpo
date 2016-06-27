package br.com.jkavdev.models.dpj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.models.dpj.util.jpa.BaseEntity;

@Entity
@Table(name = "enderecos")
public class Endereco extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;

	@Column(nullable = false, length = 64)
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Column(nullable = false, length = 32)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(nullable = false, length = 32)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(nullable = false, length = 2)
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Column(nullable = false, length = 8)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
