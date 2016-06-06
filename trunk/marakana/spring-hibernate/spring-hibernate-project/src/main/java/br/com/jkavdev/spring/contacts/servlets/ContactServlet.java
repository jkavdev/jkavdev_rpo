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
		try {
			if (req.getParameter("add") != null) {
				req.getRequestDispatcher("jsp/addContact.jsp").forward(req, resp);
			} else {
				// get contact id from request parameter, and populate model
				// with
				long id = Long.parseLong(req.getParameter("id"));

				Contact contact = contactRepository.find(id);
				Address address = addressRepository.find(contact.getAddressId());

				req.setAttribute("contact", contact);
				req.setAttribute("address", address);

				// dispatch either to the edit page or to the view page
				if (req.getParameter("edit") != null) {
					req.getRequestDispatcher("jsp/editContact.jsp").forward(req, resp);
				} else {
					req.getRequestDispatcher("jsp/viewContact.jsp").forward(req, resp);
				}

			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// add a new contact
			if (req.getParameter("add") != null) {
				// create new contact and address from form parameters and
				// persist
				Address address = new Address(req.getParameter("street"), req.getParameter("city"),
						req.getParameter("state"), req.getParameter("zip"));
				addressRepository.create(address);

				Contact contact = new Contact(req.getParameter("name"), address.getId());
				contactRepository.create(contact);

				// contact list
				// resp.sendRedirect("contacts");
				// contact view

				// redirect to contact view page
				resp.sendRedirect("contact?id=" + contact.getId());
			} else if (req.getParameter("edit") != null) {

				// look up for existing contact and address, edit fields and
				// persist
				long id = Long.parseLong(req.getParameter("id"));

				Contact contact = contactRepository.find(id);
				Address address = addressRepository.find(contact.getAddressId());

				contact.setName(req.getParameter("name"));
				address.setStreet(req.getParameter("street"));
				address.setState(req.getParameter("state"));
				address.setCity(req.getParameter("city"));
				address.setZip(req.getParameter("zip"));

				contactRepository.update(contact);
				addressRepository.update(address);

				// redirect to contact view page
				resp.sendRedirect("contact?id=" + contact.getId());
			} else {
				super.doPost(req, resp);
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}
