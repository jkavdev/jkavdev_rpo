package br.com.jkavdev.primefaces.service;

public class CalculadoraPreco {

	public double calcularPreco(int quantidade, double precoUnitario) {
		return quantidade * precoUnitario;
	}

}
