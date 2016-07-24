package br.com.jkavdev.algaworks.jsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import br.com.jkavdev.algaworks.jsf.model.Produto;

@ManagedBean
// cria uma instancia para ser usada durante toda a aplicacao
// @ApplicationScoped¨

// criara uma instancia para ser usada durante a sessao do usuario
 @SessionScoped

// criara uma instancia para ser usada durante a vida pagina
//@ViewScoped

// escopo padrao criara uma instancia para a requisicao
// @RequestScoped

// escopo nao definido
// @NoneScoped
public class GestaoProdutosBeans implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Produto> produtos;
	private Produto produto;
	private Produto produtoSelecionado;
	private String nomePesquisa;
	private List<Produto> produtosFiltrados;

	public GestaoProdutosBeans() {
		this.produtos = new ArrayList<>();
		this.produto = new Produto();
		this.produtosFiltrados = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		System.out.println("Bean Inicializado");
	}

	public void incluir() {
		System.out.println("Incluindo");
		this.produtos.add(produto);
		this.produto = new Produto();
	}

	public String obterAjuda() {
		if (this.produtos.isEmpty()) {
			return "ajuda-gestao-produtos?faces-redirect=true";
		} else {
			return "ajuda-gestao-produtos-telefone?faces-redirect=true";
		}

	}

	public void verificarInclusao(ActionEvent event) {
		System.out.println("Verificando");
		if ("".equals(this.produto.getFabricante())) {
			this.produto.setFabricante("Sem fabricante");
		}
	}

	public void excluir() {
		this.produtos.remove(this.produtoSelecionado);
	}

	public void nomePesquisaAlterado(ValueChangeEvent event) {
		System.out.println("Evento de mudancao de valor");

		System.out.println("Valor atual: " + event.getOldValue());
		System.out.println("Valor novo: " + event.getNewValue());

		this.produtosFiltrados.clear();

		// se o nome do fabricante comecar com o pesquisar
		for (Produto produto : produtos) {
			if (produto.getNome() != null && produto.getNome().toLowerCase()
					.startsWith(event.getNewValue().toString().toLowerCase())) {
				this.produtosFiltrados.add(produto);
			}
		}
	}

	@PreDestroy
	public void dest() {
		System.out.println("Bean Finalizado");
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

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String fabricantePesquisa) {
		this.nomePesquisa = fabricantePesquisa;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

}
