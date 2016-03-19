package com.algaworks.cursojavaee.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.cursojavaee.service.Mensageiro;
import com.algaworks.cursojavaee.service.Urgente;

@Named
@RequestScoped
public class EnvioMensagemBean {

	//neste caso o cdi nao sabe qual objeto instanciar correio ou sms
	//para isso precisamos criar um qualificador
	@Inject @Urgente
	private Mensageiro mensageiro;
	
	private String texto;

	public void enviarMensagem() {
		System.out.println("chegou");
		mensageiro.enviarMensagem(texto);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexo(String texto) {
		this.texto = texto;
	}

}
