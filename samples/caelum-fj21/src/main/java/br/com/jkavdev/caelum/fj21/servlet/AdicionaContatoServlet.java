package br.com.jkavdev.caelum.fj21.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.caelum.fj21.database.dao.ContatoDao;
import br.com.jkavdev.caelum.fj21.model.Contato;
import br.com.jkavdev.caelum.fj21.util.data.DataUtil;

@WebServlet("/contato/AdicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataNascimentoTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = Calendar.getInstance();

		try {
			dataNascimento = DataUtil.formataDataCalendar(dataNascimentoTexto);
		} catch (ParseException e) {
			System.out.println("Erro ao formatar data: " + e);
		}

		Contato contato = createContato(nome, email, endereco, dataNascimento);

		Connection connection = (Connection) req.getAttribute("connection");
		ContatoDao contatoDao = new ContatoDao(connection);

		if (contato.getNome() != null) {
			contatoDao.insert(contato);
			
			req.getRequestDispatcher("/contato/contato-adicionado.jsp").forward(req, resp);
		}
	}

	private Contato createContato(String nome, String email, String endereco, Calendar dataNascimento) {
		Contato contato = new Contato(nome, email, endereco, dataNascimento);
		return contato;
	}

}
