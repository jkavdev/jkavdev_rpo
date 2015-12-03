package com.algaworks.curso.jpa2.service;

//lançamentos de exceção de regras de negocio

public class NegocioException extends Exception {
	
	public NegocioException(String message){
		super(message);
	}

}
