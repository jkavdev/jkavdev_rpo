package br.com.jkavdev.caelum.fj21.service.contato;

import java.sql.Connection;
import java.text.ParseException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import br.com.jkavdev.caelum.fj21.database.connection.ConnectionFactory;
import br.com.jkavdev.caelum.fj21.database.dao.ContatoDao;
import br.com.jkavdev.caelum.fj21.model.Contato;
import br.com.jkavdev.caelum.fj21.service.Logica;
import br.com.jkavdev.caelum.fj21.util.data.DataUtil;

public class SaveContact implements Logica {

	private static final Logger logger = Logger.getLogger(SaveContact.class);

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataNascimentoTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = Calendar.getInstance();

		if (!StringUtils.isBlank(dataNascimentoTexto)) {
			try {
				dataNascimento = DataUtil.formataDataCalendar(dataNascimentoTexto);
			} catch (ParseException e) {
				logger.error("Erro ao formatar data: ", e);

			}
		}

		Contato contato = createContato(nome, email, endereco, dataNascimento);

		Connection connection = (Connection) req.getAttribute("connection");
		ContatoDao contatoDao = new ContatoDao(connection);

		if (contato.getNome() != null) {
			contatoDao.insert(contato);
		}		

		return "WEB-INF/jsp/contato/contato-adicionado.jsp";
	}

	private Contato createContato(String nome, String email, String endereco, Calendar dataNascimento) {
		Contato contato = new Contato(nome, email, endereco, dataNascimento);

		return contato;
	}

}
