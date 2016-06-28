package br.com.jkavdev.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.pedidovenda.model.Produto;
import br.com.jkavdev.pedidovenda.repository.ProdutoRepository;
import br.com.jkavdev.pedidovenda.repository.filter.ProdutoFilter;
import br.com.jkavdev.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoRepository produtoRepository;
	private List<Produto> produtosFiltrados;
	private Produto produtoSelecionado;
	private ProdutoFilter filtro;

	public PesquisaProdutosBean() {
		this.filtro = new ProdutoFilter();
	}

	public void pesquisar() {
		this.produtosFiltrados = this.produtoRepository.filtrados(filtro);
	}
	
	public void excluir(){
		produtoRepository.remover(produtoSelecionado);
		this.produtosFiltrados.remove(produtoSelecionado);
		
		FacesUtil.addInfoMessage("Produto: " + produtoSelecionado.getSku() + " excluido com sucesso!");
	}

	public List<Produto> getProdutosFiltrados() {
		return this.produtosFiltrados;
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

}
