package com.algaworks.pedidovenda.util.jsf;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import com.algaworks.pedidovenda.service.NegocioException;

//tratador de excecoes

public class JsfExceptionHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;

	public JsfExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	// retorna o tratador de excecoes empacotado
	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

	@Override
	public void handle() throws FacesException {
		// itero sobre as fila de eventos de excecoes
		Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();

		// faço uma iteracao no conteudo de events
		while (events.hasNext()) {
			// pego o evento
			ExceptionQueuedEvent event = events.next();

			// origem da excecao
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

			// excecao
			Throwable exception = context.getException();

			NegocioException negocioException = getNegocioException(exception);

			// variavel para remocao da excecao
			boolean handled = false;

			try {
				// se a exception for de ViewExpiredException
				// redirecionar para o home
				if (exception instanceof ViewExpiredException) {
					redirect("/");
					handled = true;
				} else if (negocioException != null) {
					handled = true;
					FacesUtil.addErrorMessage(negocioException.getMessage());
				} else {
					// se nao ViewExpiredException
					// joga para tela de erro
					handled = true;
					redirect("/Erro.xhtml");
				}
				// retira a excecao da pilha
			} finally {
				// entao remove
				if (handled) {
					events.remove();
				}
			}
		}

		// passando para o manipulador de excecoes para fazer as proximas
		// instrucoes
		getWrapped().handle();
	}

	private NegocioException getNegocioException(Throwable exception) {
		if (exception instanceof NegocioException) {
			return (NegocioException) exception;
		} else if (exception.getCause() != null) {
			return getNegocioException(exception.getCause());
		}
		return null;
	}

	// pega o contexto da aplicacao e redireciona
	private void redirect(String page) {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			String contextPath = externalContext.getRequestContextPath();

			externalContext.redirect(contextPath + page);
			facesContext.responseComplete();
		} catch (IOException e) {
			throw new FacesException(e);
		}

	}

}
