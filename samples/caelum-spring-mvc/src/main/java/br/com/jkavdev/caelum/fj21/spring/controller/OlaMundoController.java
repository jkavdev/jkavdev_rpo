package br.com.jkavdev.caelum.fj21.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {

	private static final Logger logger = Logger.getLogger(OlaMundoController.class);

	@RequestMapping("/ola")
	public String execute() {
		logger.info("Executando Spring MVC");

		return "ok";
	}

}
