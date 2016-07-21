package br.com.jkavdev.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping({ "/", "/welcome" })
	public ModelAndView home() {

		String message = "Spring MVC and JSP";

		return new ModelAndView("welcome", "message", message);
	}

}
