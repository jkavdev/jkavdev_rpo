package br.com.jkavdev.algaworks.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.jkavdev.algaworks.spring.model.Imovel;
import br.com.jkavdev.algaworks.spring.model.TipoImovel;

@Controller
// controller que tratara todas as requisicoes de imoveis
@RequestMapping("/imoveis/")
public class ImoveisController {

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("cadastro-imovel");

		// adicionando objeto na view
		modelAndView.addObject(new Imovel());
		// adicionando lista de tipoImovel na view
		// por padrao o nome da lista sera tipoImovelList
		modelAndView.addObject(TipoImovel.values());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adicionar(Imovel imovel, RedirectAttributes attributes) {
		ModelAndView modelAndView = new ModelAndView("cadastro-imovel");

		modelAndView.setViewName("redirect:/imovies/novo");
		// atributo que durara durante o redirect
		attributes.addFlashAttribute("mensagem", "Imovel cadastrado com sucesso!");

		return modelAndView;
	}

}
