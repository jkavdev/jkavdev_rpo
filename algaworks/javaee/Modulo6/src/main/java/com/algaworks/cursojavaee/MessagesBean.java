package com.algaworks.cursojavaee;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class MessagesBean {

	public void adicionarMensagemErro() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, 
				"Resumo de Mensagem de erro", "Mensagem de erro completa");
		//addMessagem - recebe o id do componente que exibira e a mensagem
		//se null em clienteid, indica que qualquer componente exibira sua mensagem
		context.addMessage("destinoErro", message);
		
	}

	public void adicionarAvisoFlutuante() {
FacesContext context = FacesContext.getCurrentInstance();
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Resumo aviso flutuante", "Aviso flutuante completo");
		context.addMessage("destinoAviso", message);
	}

}
