package com.algaworks.cursojavaee.service;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;

//bean padrao do cdi

//deendent significa tambem que este bean e dependente
//de quem o injeta
//no caso se produto bean que eh o injeto deste bean
//for request este bean tambem sera request, mudando seu escopo 
//@Dependent
@ApplicationScoped
public class CalculadoraPreco {
	
	@PostConstruct
	public void init(){
		System.out.println("init calculadoraPreco");
	}

	public double CalculaPreco(int quantidade, double precoUnitario) {
		return quantidade * precoUnitario;
	}

}
