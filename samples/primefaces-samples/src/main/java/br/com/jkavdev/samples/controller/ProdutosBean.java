package br.com.jkavdev.samples.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> produtos = new ArrayList<>();
	private String nomeProduto;

	public void incluirProduto() {
		this.produtos.add(this.nomeProduto);
		this.nomeProduto = null;
	}

	public String getNomeProduto() {
		return this.nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public List<String> getProdutos() {
		return this.produtos;
	}

}
