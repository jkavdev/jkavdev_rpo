package com.algaworks.cursojavaee.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.cursojavaee.service.CalculadoraPreco;

//bean cdi
@Named
//por padrao todo bean do cdi eh anotado com depedant
//seu tempo de vida e curto, durando apenas a cada chamada de um componente
//@Dependent

//com o request, o tempo de vida do bean durara a uma requisicao http
//@RequestScoped

//como o session eh um escopo de longa duracao
//a classe que o tiver tem que implementar serializable
@SessionScoped
public class PrecoProdutoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//fazendo a injecao de CalculadoraPreco
	//nao nos preocupamos como o objeto sera criado
	@Inject
	private CalculadoraPreco calculadoraPreco;
	
	//executado sempre quando o bean for instanciado
	//usado em vez do construtor
	//pois no construtor o objeta esta sendo instanciado
	//sem tempo de instanciar todos os seus atibutos
	//com postconstruct ele agira quando todo o bean estiver pronto
	
	//chamado depois do construtor e depois dos objetos serem injetados
	@PostConstruct
	public void init(){
		System.out.println("init precoBean");
	}
	
	public double getPreco(){
		//$Proxy$_$$_WeldClientProxy copiara a classe a ser injetada
		//e instanciara um objeto se for requerido
		//ela tambem faz esta verificacao se o objet eh usado ou nao
		System.out.println(calculadoraPreco.getClass());
		return calculadoraPreco.CalculaPreco(12, 44.55);
	}

}
