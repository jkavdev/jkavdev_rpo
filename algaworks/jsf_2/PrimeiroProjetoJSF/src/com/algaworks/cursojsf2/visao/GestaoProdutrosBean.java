package com.algaworks.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.cursojsf2.dominio.Produto;

//o jsf criara uma instancia do bean
//utilizara deste bean durante toda a vida da aplicacao
//nao instanciando outro bean
//@ApplicationScoped

//o jsf criara um instancia do bean
//utilizara deste bean durante toda a sessao do usuario
//sessao eh por usuario, nao compartilha dados
//uma vez que a sessao acaba, o bean e finalizado
@SessionScoped

// o jsf criara um instancia do bean
// utilizara deste bean durante a tela
// uma vez que a tela for atualizada o bean sera finalizado
// @ViewScoped

// o jsf criara um instancia do bean
// utilizara deste bean durante a requisicao
// uma vez que seja feita uma nova requisao criara uma nova instancia do bean
// @RequestScoped

// o jsf criara um instancia do bean
// utilizara por demanda,
// uma vez que certo atributo precisa do bean
// instanciara um novo bean
// @NoneScoped

@ManagedBean
public class GestaoProdutrosBean implements Serializable {

	private Produto produto;
	private List<Produto> produtos;
	private String fabricaPesquisa;

	// produto a ser excluido
	private Produto produtoSelecionado;
	//produtos a serem filtrados
	private List<Produto> produtosFiltrados;

	public GestaoProdutrosBean() {
		produtos = new ArrayList<>();
		this.produtosFiltrados = new ArrayList<>();
		produto = new Produto();
	}
	
	public void pesquisar(){
		System.out.println("Pesquisando...");
	}
	
	//este metodo sera executado
	//toda vez em que o valor do campo for alterado
	//e recebe como parametro um ValueChangeEvent
	//se o valor nao for alterado, nao sera chamado
	public void fabricantePesquisaAlterado(ValueChangeEvent changeEvent){
		System.out.println("evento de mudanca de valor");
		
		System.out.println("Valor Atual : " + this.fabricaPesquisa);
		System.out.println("Valor Novo : " + changeEvent.getNewValue());
		
		
		
	}

	public void incluir() {
		System.out.println("incluindo");
		this.produtos.add(produto);
		this.produto = new Produto();
	}

	// retornar para qual pagina de ajuda sera exibido
	public String obterAjuda() {
		if (this.produtos.isEmpty()) {
			return "AjudaGestaoProdutos?faces-redirect=true";
		} else {
			return "AjudaGestaoProdutosTelefone?faces-redirect=true";
		}
	}

	// este metodo sera executado antes da acao do botao
	// recebe como parametro um actionevent
	public void verificarInclusao(ActionEvent event) {
		System.out.println("verificando");
		if ("".equals(this.produto.getFabricante())) {
			this.produto.setFabricante("Sem Fabricante");
		}
	}

	//setando produto com setPropertyActionListener
	//no qual pegara cada item da tabela e atribuira ao produto selecionado
	public void excluir() {
		this.produtos.remove(produtoSelecionado);
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	@PostConstruct
	public void init() {
		System.out.println("Bean Iniciado");
	}

	@PreDestroy
	public void des() {
		System.out.println("Bean Finalizado");
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public String getFabricaPesquisa() {
		return fabricaPesquisa;
	}

	public void setFabricaPesquisa(String fabricaPesquisa) {
		this.fabricaPesquisa = fabricaPesquisa;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	
	

}
