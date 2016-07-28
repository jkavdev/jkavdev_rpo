package br.com.jkavdev.algaworks.jsf.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class FacesUtil {

	public static void adicionarMensagem(Severity tipo, String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, msg, msg));
	}

	public static Object getRequesAttribute(String name) {
		
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		ExternalContext externalContext = currentInstance.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		
		return request.getAttribute(name);

	}

}
