package br.com.jkavdev.samples.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class MessagesBean {

	public void adicionarMensagemErro() {
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Resumo da mensagem de erro", "Mensagem de erro completa");

		//informo id e mensagem do componente
		context.addMessage("destinoErro", message);

	}

	public void adicionarMensagemAviso() {
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Resumo da mensagem de aviso", "Mensagem de aviso completa");

		context.addMessage(null, message);

	}

}
