package br.com.jkavdev.springmvc.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping("/home")
	public String index() {

		logger.info("Carregando produtos");

		return "hello-world";

	}

}
