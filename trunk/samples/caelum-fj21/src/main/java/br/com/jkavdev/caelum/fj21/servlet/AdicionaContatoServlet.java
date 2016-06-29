package br.com.jkavdev.caelum.fj21.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
public class AdicionaContatoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
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
		
		ContatoDao contatoDao = new ContatoDao();
		
		if (contato.getNome() != null) {
			contatoDao.insert(contato);
			
			// imprime o nome do contato que foi adicionado
			out.println("<html>");
			out.println("<body>");
			out.println("Contato " + contato.getNome() + " adicionado com sucesso!");
			out.println("</body>");
			out.println("</html>");
		}
	}

	private Contato createContato(String nome, String email, String endereco, Calendar dataNascimento) {
		Contato contato = new Contato(nome, email, endereco, dataNascimento);
		return contato;
	}

}
