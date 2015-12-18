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

//o jsf criara um instancia do bean
//utilizara deste bean durante a tela
//uma vez que a tela for atualizada o bean sera finalizado
//@ViewScoped

//o jsf criara um instancia do bean
//utilizara deste bean durante a requisicao
//uma vez que seja feita uma nova requisao criara uma nova instancia do bean
//@RequestScoped

//o jsf criara um instancia do bean
//utilizara por demanda, 
//uma vez que certo atributo precisa do bean
//instanciara um novo bean
//@NoneScoped

@ManagedBean
public class GestaoProdutrosBean implements Serializable{

	private Produto produto;
	private List<Produto> produtos;
	
	public GestaoProdutrosBean() {
		produtos = new ArrayList<>();
		produto = new Produto();
	}

	public void incluir() {
		this.produtos.add(produto);
		this.produto = new Produto();
	}
	
	//retornar para qual pagina de ajuda sera exibido
	public String obterAjuda(){
		if(this.produtos.isEmpty()){
			return "AjudaGestaoProdutos?faces-redirect=true";
		}else{
			return "AjudaGestaoProdutosTelefone?faces-redirect=true";
		}
	}
	

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("Bean Iniciado");
	}
	
	@PreDestroy
	public void des(){
		System.out.println("Bean Finalizado");
	}

}
