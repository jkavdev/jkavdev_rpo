package com.algaworks.cursojavaee.service;

import javax.enterprise.inject.Default;

//por padrao toda bean no cdi eh anotado com @default
@Default
public class MensageiroCorreio implements Mensageiro{

	@Override
	public void enviarMensagem(String mensagem) {
		System.out.println("Enviando mensagem por correio: " + mensagem);
	}

}
