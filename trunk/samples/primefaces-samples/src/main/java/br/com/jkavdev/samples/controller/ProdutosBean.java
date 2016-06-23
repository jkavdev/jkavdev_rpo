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
	private String produtoSelecionado;

	public ProdutosBean() {

		this.produtos.add("Feijão");
		this.produtos.add("Arroz");
		this.produtos.add("Carne");
		this.produtos.add("Açucar");

	}

	public void incluirProduto() {
		this.produtos.add(this.nomeProduto);
		this.nomeProduto = null;
	}

	public void excluirProduto() {
		this.produtos.remove(this.produtoSelecionado);
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

	public String getProdutoSelecionado() {
		return this.produtoSelecionado;
	}

	public void setProdutoSelecionado(String produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

}
