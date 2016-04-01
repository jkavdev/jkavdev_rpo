package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.CategoriaRepository;
import com.algaworks.pedidovenda.service.CadastroProdutoService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaRepository categoriaRepository;
	@Inject
	private CadastroProdutoService cadastroProdutoService;
	private Produto produto;
	private List<Categoria> categoriasRaizes;
	private List<Categoria> subCategorias;
	private Categoria categoriaPai;

	public CadastroProdutoBean() {
		this.limpar();
	}

	public void inicializar() {
		System.out.println("Inicializando");

		// se ainda estiver na mesma tela e ao tiver atualizado
		// nao vai fazer a consulta
		if (FacesUtil.isNotPostback()) {
			categoriasRaizes = categoriaRepository.raizes();
			System.out.println(categoriasRaizes.size());
		}
	}

	private void limpar() {
		this.produto = new Produto();
		categoriaPai = null;
		subCategorias = new ArrayList<>();
	}

	public void salvar() {
		this.produto = cadastroProdutoService.salvar(produto);
		this.limpar();
		FacesUtil.addInfoMessage("Produto salvo com Sucesso");
	}

	public void carregarSubCategorias() {
		// prencheendo as subcategorias de acordo com a categoria pai
		subCategorias = categoriaRepository.subCategoriasDe(categoriaPai);
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

	public List<Categoria> getSubCategorias() {
		return subCategorias;
	}

	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

}