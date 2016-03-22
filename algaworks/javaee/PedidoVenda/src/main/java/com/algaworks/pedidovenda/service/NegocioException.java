package com.algaworks.pedidovenda.service;

//Excecoes das regras de Negocios

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NegocioException(String message) {
		super(message);
	}

}
