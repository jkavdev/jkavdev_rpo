package br.com.jkavdev.caelum.fj21.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class PrimeiraLogica implements Logica {
	
	private static final Logger logger = Logger.getLogger(PrimeiraLogica.class);

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("Executando logica");
		
		logger.info("Retornando pagina jsp");
		
		return "primeira-logica.jsp";
	}

}
