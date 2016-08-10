package br.com.jkavdev.algaworks.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@RequestMapping
	public String pesquisa() {
		return "/vinho/listagem-vinhos";
	}

	@RequestMapping("/novo")
	public String novo() {
		return "/vinho/cadastro-vinho";
	}
}
