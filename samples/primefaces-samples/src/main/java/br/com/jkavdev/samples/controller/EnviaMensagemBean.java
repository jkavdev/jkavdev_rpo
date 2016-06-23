package br.com.jkavdev.samples.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.samples.service.Mensageiro;
import br.com.jkavdev.samples.service.Urgente;

@Named
@RequestScoped
public class EnviaMensagemBean {

	@Inject
	// informando que sera a implemetacao default sera instanciada
	// @Default
	// informando a implementacao que contem @Urgente,
	// apesar de termos uma com @default
	@Urgente
	private Mensageiro mensageiro;
	private String texto;

	public void enviarMensagem() {
		this.mensageiro.enviarMensagem(this.texto);
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
