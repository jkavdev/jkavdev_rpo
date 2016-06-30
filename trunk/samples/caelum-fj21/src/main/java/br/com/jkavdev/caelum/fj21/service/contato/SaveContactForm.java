package br.com.jkavdev.caelum.fj21.service.contato;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.com.jkavdev.caelum.fj21.service.Logica;

public class SaveContactForm extends HttpServlet implements Logica {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SaveContactForm.class);

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		return "WEB-INF/jsp/contato/adiciona-contato.jsp";
	}

}
