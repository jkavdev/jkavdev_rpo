package br.com.jkavdev.algaworks.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jkavdev.algaworks.spring.model.Vinho;
import br.com.jkavdev.algaworks.spring.repository.Vinhos;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@Autowired
	private Vinhos vinhos;

	@RequestMapping
	public ModelAndView pesquisa() {
		// criando objeto com o nome da view
		ModelAndView modelAndView = new ModelAndView("/vinho/listagem-vinhos");

		// retornando todos os vinhos
		List<Vinho> todosVinhos = vinhos.findAll();

		// adicionando os vinhos para acesso na pagina
		modelAndView.addObject("vinhos", todosVinhos);

		return modelAndView;
	}

	@RequestMapping("/novo")
	public String novo() {
		return "/vinho/cadastro-vinho";
	}
}
