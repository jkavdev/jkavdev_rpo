package br.com.jkavdev.caelum.fj21.service.contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.com.jkavdev.caelum.fj21.database.dao.ContatoDao;
import br.com.jkavdev.caelum.fj21.model.Contato;
import br.com.jkavdev.caelum.fj21.service.Logica;

public class RemoveContact implements Logica {

	private static final Logger logger = Logger.getLogger(PrimeiraLogica.class);

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {

		long id = Long.parseLong(request.getParameter("id"));

		Contato contato = new Contato();
		contato.setId(id);

		ContatoDao contatoDao = new ContatoDao();
		contatoDao.remove(contato);

		logger.info("Excluindo contato...");

		return "mvc?logica=FindAllContacts";
	}

}
