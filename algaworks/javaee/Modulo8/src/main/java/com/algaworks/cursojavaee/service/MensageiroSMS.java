package com.algaworks.cursojavaee.service;

//indicando que este bean tem precedencia
@Urgente
public class MensageiroSMS implements Mensageiro{

	@Override
	public void enviarMensagem(String mensagem) {
		System.out.println("Eviando mensagem por sms: " + mensagem);
	}

}
