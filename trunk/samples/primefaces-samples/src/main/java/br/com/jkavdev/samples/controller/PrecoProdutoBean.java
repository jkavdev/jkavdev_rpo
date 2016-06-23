package br.com.jkavdev.samples.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.samples.service.CalculadoraPreco;

@Named
// escopo padrao, será instanciado toda vez que chamado
// @Dependent
// escopo de requisicao http
// @RequestScoped
@SessionScoped
public class PrecoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// @Inject
	private CalculadoraPreco calculadoraPreco;

	public PrecoProdutoBean() {
	}

	@Inject
	public PrecoProdutoBean(CalculadoraPreco calculadoraPreco) {
		System.out.println("Construtor: " + calculadoraPreco.getClass());
		this.calculadoraPreco = calculadoraPreco;
	}

	@PostConstruct
	public void init() {
		System.out.println("Init PrecoProdutoBean");
	}

	public double getPreco() {
		// exebindo objeto proxy que o cdi cria
		System.out.println(this.calculadoraPreco.getClass());
		return this.calculadoraPreco.calcularPreco(12, 45.32);
	}

	// @Inject
	public void setCalculadoraPreco(CalculadoraPreco calculadoraPreco) {
		System.out.println("setCalculadora: " + calculadoraPreco.getClass());
		this.calculadoraPreco = calculadoraPreco;
	}

}
