package br.com.jkavdev.algaworks.jsf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jkavdev.algaworks.jsf.model.Produto;

@ManagedBean
// cria uma instancia para ser usada durante toda a aplicacao
// @ApplicationScoped¨

//criara uma instancia para ser usada durante a sessao do usuario
@SessionScoped
public class GestaoProdutosBeans {

	private List<Produto> produtos;
	private Produto produto;

	public GestaoProdutosBeans() {
		this.produtos = new ArrayList<>();
		this.produto = new Produto();
	}

	public void incluir() {
		this.produtos.add(produto);
		this.produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

}
