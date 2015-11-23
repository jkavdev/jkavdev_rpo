package com.algaworks.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.algaworks.cursojsf2.dominio.Produto;

//o view scoped tem um tempo de vida menor ainda que o session
//seu tempo de vida e quando se estiver usando aquela tela
//@ViewScoped

//o escopo padrao do jsf e o reques
//a cada requisao e inicada um novo bean
//@RequestScoped

//com o none , e apenas utilizado por demanda
//por exemplo, temos na pagina html tree atributos
//entao sera criado um escopo para cada atributo
@ManagedBean
public class GestaoProdutosImplicitoBean implements Serializable {

	private Produto produto;
	private List<Produto> produtos;

	// instanciando objetos para nao serem criados nulos
	public GestaoProdutosImplicitoBean() {
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

	// logo depois da criação do bean
	@PostConstruct
	public void init() {
		System.out.println("Inicializou bean");
	}

	// pouco antes de finalizar o escopo
	@PreDestroy
	public void finalizar() {
		System.out.println("Finalizando bean");
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

}
