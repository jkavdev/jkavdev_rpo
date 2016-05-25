package br.com.jkavdev.primefaces.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.primefaces.service.CalculadoraPreco;

@Named("precoBean")
@ViewScoped
public class PrecoProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CalculadoraPreco calculadora;

	public double getPreco() {
		return calculadora.calcularPreco(12, 4.5);
	}

}
