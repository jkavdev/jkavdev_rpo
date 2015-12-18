package com.algaworks.cursojsf2.visao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

@ManagedBean
public class GestaoProdutrosBean {

	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<>();

	public void incluir() {
		this.produtos.add(produto);
		this.produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
