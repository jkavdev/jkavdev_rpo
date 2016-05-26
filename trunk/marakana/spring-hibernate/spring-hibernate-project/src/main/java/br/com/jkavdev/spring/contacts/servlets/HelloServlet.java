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
//		resp.setContentType("text/html");
//
//		PrintWriter writer = resp.getWriter();
//
//		writer.println("<html><body>Hello</body></html>");
		
		//dispachando para o jsp, no caso nossa view
		RequestDispatcher view = req.getRequestDispatcher("jsp/hello.jsp");
		view.forward(req, resp);
	}
}
