package br.com.jkavdev.servlet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletexample")
public class ServletExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// chamando minha pagina jsp, no caso o formulario
		// caso os campos do formularios forem vazios
		if (request.getParameter("firstname") == null || request.getParameter("lastname") == null) {
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			// atualizara a pagina
			return;
		}

		// recebendo parametros do formulario
		//caso os campos nao forem passados, nao chegara nesta parte
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");

		request.setAttribute("firstname", firstName);
		request.setAttribute("lastname", lastName);

		//chamando saida
		getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);

	}

}
