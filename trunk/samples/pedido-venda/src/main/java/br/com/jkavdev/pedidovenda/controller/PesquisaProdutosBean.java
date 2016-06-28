package br.com.jkavdev.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.pedidovenda.model.Produto;
import br.com.jkavdev.pedidovenda.repository.ProdutoRepository;
import br.com.jkavdev.pedidovenda.repository.filter.ProdutoFilter;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoRepository produtoRepository;
	private List<Produto> produtosFiltrados;
	private ProdutoFilter filtro;

	public PesquisaProdutosBean() {
		this.filtro = new ProdutoFilter();
	}

	public void pesquisar() {
		this.produtosFiltrados = this.produtoRepository.filtrados(filtro);
	}

	public List<Produto> getProdutosFiltrados() {
		return this.produtosFiltrados;
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}

}
