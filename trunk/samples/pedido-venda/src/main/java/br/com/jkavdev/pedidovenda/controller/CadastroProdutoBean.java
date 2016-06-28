package br.com.jkavdev.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import br.com.jkavdev.pedidovenda.model.Categoria;
import br.com.jkavdev.pedidovenda.model.Produto;
import br.com.jkavdev.pedidovenda.repository.CategoriaRepository;
import br.com.jkavdev.pedidovenda.service.CadastroProdutoService;
import br.com.jkavdev.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaRepository categoriaRepository;
	@Inject
	private CadastroProdutoService produtoService;

	private Produto produto;
	private Categoria categoriaPai;

	private List<Categoria> categoriasRaizes;
	private List<Categoria> subCategorias;

	public CadastroProdutoBean() {
		this.limpar();
	}

	public void limpar() {
		produto = new Produto();
		categoriaPai = null;
		subCategorias = new ArrayList<>();
	}

	public void init() {
		if (FacesUtil.isNotPostBack()) {
			this.categoriasRaizes = this.categoriaRepository.raizes();

			// carrega as subcategoria, na hora da edicao
			if (categoriaPai != null) {
				this.carregarSubcategorias();
			}
		}
	}

	public void carregarSubcategorias() {
		this.subCategorias = this.categoriaRepository.SubcategoriasDe(categoriaPai);
	}

	public void salvar() {
		this.produto = this.produtoService.salvar(this.produto);
		this.limpar();

		FacesUtil.addInfoMessage("Produto salvo com sucesso!");
	}

	public boolean isEditando() {
		return this.produto.getId() != null;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;

		// carrega a categoria pai, na hora da edicao
		if (produto != null) {
			this.categoriaPai = this.produto.getCategoria().getCategoriaPai();
		}
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

	public List<Categoria> getSubCategorias() {
		return subCategorias;
	}

}
