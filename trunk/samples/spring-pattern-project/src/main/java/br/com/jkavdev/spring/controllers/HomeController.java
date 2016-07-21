package br.com.jkavdev.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jkavdev.spring.model.Person;

@Controller
public class HomeController {

	@RequestMapping({ "/", "/welcome" })
	public String home() {

		return "index";
	}

	@RequestMapping("/viewPerson")
	public ModelAndView viewPersons(Model model) {

		Map<String, List<Person>> persons = new HashMap<String, List<Person>>();
		persons.put("persons", Person.createPersons());

		return new ModelAndView("person-list", persons);
	}

}
