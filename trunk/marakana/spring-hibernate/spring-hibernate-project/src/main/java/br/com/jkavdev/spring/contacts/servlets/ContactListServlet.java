package br.com.jkavdev.spring.contacts.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.spring.contacts.repositories.ContactRepository;

@WebServlet("/contacts")
public class ContactListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ContactRepository contactRepository = new ContactRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			req.setAttribute("contacts", contactRepository.findAll());

			RequestDispatcher view = req.getRequestDispatcher("jsp/contactList.jsp");
			view.forward(req, resp);
		} catch (SQLException e) {
			// wrapping exception
			throw new ServletException(e);
		}

	}
}