package br.com.jkavdev.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jkavdev.pedidovenda.model.Categoria;
import br.com.jkavdev.pedidovenda.model.Produto;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Produto produto;
	private List<Categoria> categoriasRaizes;

	public CadastroProdutoBean() {
		this.produto = new Produto();
	}
	
	@PostConstruct
	public void init(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pedidoPU");
		EntityManager manager = factory.createEntityManager();

		categoriasRaizes = manager.createQuery("from Categoria", Categoria.class).getResultList();
		
		manager.close();
		factory.close();
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
