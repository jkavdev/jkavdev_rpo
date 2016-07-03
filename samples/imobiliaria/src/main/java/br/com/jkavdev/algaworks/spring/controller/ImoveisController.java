package br.com.jkavdev.algaworks.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// controller que tratara todas as requisicoes de imoveis
@RequestMapping("/imoveis/")
public class ImoveisController {

	@RequestMapping("/novo")
	public String novo() {
		
		
		
		return "cadastro-imovel";
	}

}
