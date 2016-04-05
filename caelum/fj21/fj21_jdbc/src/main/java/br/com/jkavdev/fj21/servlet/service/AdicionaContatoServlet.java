package br.com.jkavdev.fj21.servlet.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.fj21.jdbc.dao.ContatoDao;
import br.com.jkavdev.fj21.jdbc.modelo.Contato;

@WebServlet("/adicionaContatos")
public class AdicionaContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		//recebendo os parametros do request
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataEmTexto = req.getParameter("dataNascimento");
		
		Calendar dataNascimento = null;
		
		//convertada a data
		try{
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
			
			//codigo que pode lancar uma ParseException
		}catch(ParseException e){
			writer.println("Erro de Conversao de Data");
			//para execucao
			return;
			
			//podemos lancar uma servletException
			//wrapping servletException
			//throw new ServletException(e);
		}
		
		//montando objeto
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		//salva contato
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.adiciona(contato);
		
		//imprime o nome do contato que foi adicionado
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Contato: " + contato.getNome() + " adicionado com Sucesso!");
		writer.println("</body>");
		writer.println("</html>");
		
	}

}

