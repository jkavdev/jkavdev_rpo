package br.com.jkavdev.caelum.fj21.service.contato;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.com.jkavdev.caelum.fj21.database.dao.ContatoDao;
import br.com.jkavdev.caelum.fj21.model.Contato;
import br.com.jkavdev.caelum.fj21.service.Logica;
import br.com.jkavdev.caelum.fj21.service.PrimeiraLogica;

public class RemoveContact implements Logica {

	private static final Logger logger = Logger.getLogger(PrimeiraLogica.class);

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {

		Connection connection = (Connection) request.getAttribute("connection");
		long id = Long.parseLong(request.getParameter("id"));

		Contato contato = new Contato();
		contato.setId(id);

		ContatoDao contatoDao = new ContatoDao(connection);
		contatoDao.remove(contato);

		logger.info("Excluindo contato...");

		return "mvc?logica=FindAllContacts";
	}

}
