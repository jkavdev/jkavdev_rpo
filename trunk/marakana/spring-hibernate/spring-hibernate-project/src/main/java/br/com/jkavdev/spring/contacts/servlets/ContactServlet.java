package br.com.jkavdev.spring.contacts.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jkavdev.spring.contacts.entities.Address;
import br.com.jkavdev.spring.contacts.entities.Contact;
import br.com.jkavdev.spring.contacts.repositories.AddressRepository;
import br.com.jkavdev.spring.contacts.repositories.ContactRepository;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final AddressRepository addressRepository = new AddressRepository();
	private final ContactRepository contactRepository = new ContactRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("add") != null) {
			req.getRequestDispatcher("jsp/addContact.jsp").forward(req, resp);
		} else {
			super.doGet(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if (req.getParameter("add") != null) {
				Address address = new Address(req.getParameter("street"), req.getParameter("city"),
						req.getParameter("state"), req.getParameter("zip"));
				addressRepository.create(address);

				Contact contact = new Contact(req.getParameter("name"), address.getId());
				contactRepository.create(contact);

				resp.sendRedirect("contacts");
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}
