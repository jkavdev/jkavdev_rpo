package br.com.jkavdev.caelum.fj21.service.contato;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.com.jkavdev.caelum.fj21.database.dao.ContatoDao;
import br.com.jkavdev.caelum.fj21.model.Contato;
import br.com.jkavdev.caelum.fj21.service.Logica;
import br.com.jkavdev.caelum.fj21.service.PrimeiraLogica;

public class FindAllContacts implements Logica {

	private static final Logger logger = Logger.getLogger(PrimeiraLogica.class);

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {

		Connection connection = (Connection) request.getAttribute("connection");
		
		List<Contato> contatos = new ContatoDao(connection).getFindAll();

		request.setAttribute("contatos", contatos);

		logger.info("Retornando todos os contatos");

		return "WEB-INF/jsp/contato/lista-contatos.jsp";
	}

}
