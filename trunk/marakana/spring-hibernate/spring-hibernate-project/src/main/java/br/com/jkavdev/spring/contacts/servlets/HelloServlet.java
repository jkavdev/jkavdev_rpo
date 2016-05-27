package br.com.jkavdev.spring.contacts.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//recebendo uma lista de parametros pela url, e separando-as por '|'
		String[] names = req.getParameter("names").split("\\|");
		
		req.setAttribute("names", names);
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/hello.jsp");
		view.forward(req, resp);
	}
}
