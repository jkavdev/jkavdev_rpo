package br.com.jkavdev.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import br.com.jkavdev.pedidovenda.model.Categoria;
import br.com.jkavdev.pedidovenda.model.Produto;
import br.com.jkavdev.pedidovenda.repository.CategoriaRepository;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaRepository categoriaRepository;
	private Produto produto;
	private List<Categoria> categoriasRaizes;
	private Categoria categoriaPai;

	public CadastroProdutoBean() {
		this.produto = new Produto();
	}

//	@PostConstruct
	public void init() {
		categoriasRaizes = categoriaRepository.raizes();
	}

	public void salvar() {
		System.out.println("Categoria Pai: " + categoriaPai.getDescricao());
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

	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

}
