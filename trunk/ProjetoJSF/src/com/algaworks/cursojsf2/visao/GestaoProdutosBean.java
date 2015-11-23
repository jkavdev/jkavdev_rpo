package com.algaworks.cursojsf2.visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.algaworks.cursojsf2.dominio.Produto;

//por padrao o escopo de um managed bean
//eh request, quer dizer que a cada requisao ele perdera as informa��es da requisao anterior

//no nosso caso precisaremos manter as informa��es do nosso bean durante toda a aplica��o
//podemos fazer isso com a seguinte anota��o
//@ApplicationScoped

//uma sessao eh por usuario
//nao compartilha dados
//tem um tempo de timeout, de vida
@SessionScoped

@ManagedBean
public class GestaoProdutosBean {

	private Produto produto;
	private List<Produto> produtos;

	// instanciando objetos para nao serem criados nulos
	public GestaoProdutosBean() {
		this.produtos = new ArrayList<>();
		this.produto = new Produto();
	}

	public void incluir() {
		this.produtos.add(this.produto);
		// limpando o produto
		this.produto = new Produto();
		// testando lista
		for (Produto produto : produtos) {
			System.out.println(produtos);
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

}
