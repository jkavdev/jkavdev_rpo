package br.com.jkavdev.wpattern.spring.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

}
