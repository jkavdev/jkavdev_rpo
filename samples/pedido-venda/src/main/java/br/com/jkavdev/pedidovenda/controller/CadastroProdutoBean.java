package br.com.jkavdev.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.jkavdev.pedidovenda.model.Categoria;
import br.com.jkavdev.pedidovenda.model.Produto;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	private Produto produto;
	private List<Categoria> categoriasRaizes;

	public CadastroProdutoBean() {
		this.produto = new Produto();
	}

	@PostConstruct
	public void init() {
		categoriasRaizes = manager.createQuery("from Categoria", Categoria.class).getResultList();
	}

	public void salvar() {

	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

}
