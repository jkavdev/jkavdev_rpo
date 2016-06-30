package br.com.jkavdev.caelum.fj21.service.contato;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.com.jkavdev.caelum.fj21.database.dao.ContatoDao;
import br.com.jkavdev.caelum.fj21.model.Contato;
import br.com.jkavdev.caelum.fj21.service.Logica;
import br.com.jkavdev.caelum.fj21.util.data.DataUtil;

public class SaveContact extends HttpServlet implements Logica {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SaveContact.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		req.getRequestDispatcher("WEB-INF/jsp/contato/contato-adicionado.jsp");
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			req.getRequestDispatcher("WEB-INF/jsp/contato/contato-adicionado.jsp").forward(req, resp);
			
		} catch (ServletException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		};
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataNascimentoTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = Calendar.getInstance();

		try {
			dataNascimento = DataUtil.formataDataCalendar(dataNascimentoTexto);
		} catch (ParseException e) {
			logger.error("Erro ao formatar Data", e);
		}

		Contato contato = createContato(nome, email, endereco, dataNascimento);

		ContatoDao contatoDao = new ContatoDao();

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
