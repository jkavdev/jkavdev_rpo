package com.algaworks.cursojavaee.controller;

import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.cursojavaee.service.CalculadoraPreco;

//bean cdi
@Named
public class PrecoProdutoBean {
	
	//fazendo a injecao de CalculadoraPreco
	//nao nos preocupamos como o objeto sera criado
	@Inject
	private CalculadoraPreco calculadoraPreco;
	
	public double getPreco(){
		return calculadoraPreco.CalculaPreco(12, 44.55);
	}

}
