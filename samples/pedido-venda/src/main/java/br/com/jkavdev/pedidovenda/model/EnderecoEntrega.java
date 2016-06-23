package br.com.jkavdev.pedidovenda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnderecoEntrega implements Serializable {

	private static final long serialVersionUID = 1L;

	private String logradouro;
	private String numero;
	private String complemento;
	private String cidade;
	private String uf;
	private String cep;

	@Column(nullable = false, length = 150, name = "entrega_logradouro")
	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Column(nullable = false, length = 20, name = "entrega_numero")
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(length = 150, name = "entrega_complemento")
	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(nullable = false, length = 60, name = "entrega_cidade")
	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(nullable = false, length = 60, name = "entrega_uf")
	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Column(nullable = false, length = 9, name = "entrega_cep")
	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
