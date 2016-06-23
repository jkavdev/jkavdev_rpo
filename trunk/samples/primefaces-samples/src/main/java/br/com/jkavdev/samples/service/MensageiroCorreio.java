package br.com.jkavdev.samples.service;

import javax.enterprise.inject.Default;

//qualificador padrao do cdi
@Default
public class MensageiroCorreio implements Mensageiro {

	@Override
	public void enviarMensagem(String texto) {
		System.out.println("Enviando mensagem por correio: " + texto);
	}

}
