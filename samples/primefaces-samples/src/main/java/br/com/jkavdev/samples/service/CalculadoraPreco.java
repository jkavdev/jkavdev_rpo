package br.com.jkavdev.samples.service;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

//escopo padrao, será instanciado toda vez que chamado
//indicando que este bean é dependente de quem o injeta
//herdando o escopo que quem o injeta
//@Dependent
//informando o escopo do bean, nao importando o escopo
//de quem o injeta
//@ApplicationScoped
@RequestScoped
public class CalculadoraPreco implements Serializable {

	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		System.out.println("Init CalculadoraPreco");
	}

	public double calcularPreco(int quantidade, double precoUnitario) {
		return quantidade * precoUnitario;
	}

}
