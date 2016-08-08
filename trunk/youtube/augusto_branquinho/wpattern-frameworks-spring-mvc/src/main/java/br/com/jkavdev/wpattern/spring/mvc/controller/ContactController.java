package br.com.jkavdev.wpattern.spring.mvc.controller;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.jkavdev.wpattern.spring.mvc.model.ContactBean;
import br.com.jkavdev.wpattern.spring.mvc.model.ContactFormBean;
import br.com.jkavdev.wpattern.spring.mvc.model.Dataset;

@Controller
@RequestMapping(value = { "/contact" })
public class ContactController {

	private static final Logger logger = Logger.getLogger(ContactController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		logger.info("List all contacts");

		ContactFormBean contactFormBean = new ContactFormBean();

		contactFormBean.setContacts(Dataset.getContacts());

		return new ModelAndView("contact/list", "contactForm", contactFormBean);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id) {
		logger.info(String.format("Delete the contact with id [%s]", id));

		Iterator<ContactBean> iterator = Dataset.getContacts().iterator();

		while (iterator.hasNext()) {
			ContactBean contact = (ContactBean) iterator.next();

			if (contact.getId() == id) {
				iterator.remove();
			}
		}

		return this.list();
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") int id) {
		logger.info(String.format("Update the contact with id [%s]", id));

		Iterator<ContactBean> iterator = Dataset.getContacts().iterator();

		while (iterator.hasNext()) {
			ContactBean contact = (ContactBean) iterator.next();

			if (contact.getId() == id) {
				return new ModelAndView("contact/addEdit", "contact", contact);
			}
		}

		return this.list();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("contact") ContactBean contact, @RequestParam("action") String action) {

		if ((action != null) && (action.trim().toLowerCase().equals("cancel"))) {
			return this.list();
		}

		logger.info(String.format("Saving the contact [%s]", contact));

		if (contact == null) {
			logger.error("Contact not received");

			return this.list();
		} else if (contact.getId() == null) {
			Dataset.addContact(contact);
		} else {
			Dataset.updateContact(contact);
		}

		return this.list();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		logger.info("Creating a new contact");

		return "contact/addEdit";
	}

}

