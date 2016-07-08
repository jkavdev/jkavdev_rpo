package br.com.jkavdev.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livros")
public class LivroController {

	@RequestMapping("/novo")
	public String novo() {

		return "ok";

	}

}
