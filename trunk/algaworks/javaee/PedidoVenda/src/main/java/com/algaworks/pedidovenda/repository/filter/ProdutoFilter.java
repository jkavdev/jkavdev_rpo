package com.algaworks.pedidovenda.repository.filter;

import java.io.Serializable;

import com.algaworks.pedidovenda.validation.SKU;

//classe responsavel por receber os atributos para filtrar
//na pesquisa com o banco de dados

public class ProdutoFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sku;
	private String nome;

	@SKU
	public String getSku() {
		return sku;
	}

	// passando para maiusculo
	public void setSku(String sku) {
		this.sku = sku == null ? null : sku.toUpperCase();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
