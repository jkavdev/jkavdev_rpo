package br.com.jkavdev.pedidovenda.repository.filter;

import java.io.Serializable;

import br.com.jkavdev.pedidovenda.validation.SKU;

public class ProdutoFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String sku;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@SKU
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku == null ? null : sku.toUpperCase();
	}

}
