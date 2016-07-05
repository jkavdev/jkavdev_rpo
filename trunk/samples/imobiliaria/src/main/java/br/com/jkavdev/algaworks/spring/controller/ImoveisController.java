package br.com.jkavdev.algaworks.spring.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.jkavdev.algaworks.spring.model.Imovel;
import br.com.jkavdev.algaworks.spring.model.TipoImovel;
import br.com.jkavdev.algaworks.spring.repository.Imoveis;

@Controller
// controller que tratara todas as requisicoes de imoveis
@RequestMapping("/imoveis")
public class ImoveisController {

	@Autowired
	private Imoveis imoveis;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("cadastro-imovel");

		// adicionando objeto na view
		modelAndView.addObject(new Imovel());

		return modelAndView;
	}

	// tratara uma requisicao do tipo post
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adicionar(@Validated Imovel imovel, Errors errors, RedirectAttributes attributes) {
		// ModelAndView modelAndView = new ModelAndView("cadastro-imovel"); erro
		// aqui
		ModelAndView modelAndView = new ModelAndView();
		
		if(errors.hasErrors()){
			modelAndView.setViewName("cadastro-imovel");
			return modelAndView;
		}

		imoveis.guardar(imovel);

		modelAndView.setViewName("redirect:/imoveis/novo");
		// atributo que durara durante o redirect
		attributes.addFlashAttribute("mensagem", "Imóvel cadastrado com sucesso!");

		return modelAndView;
	}
	
	@ModelAttribute
	public List<TipoImovel> tiposImoveis(){
		// adicionando lista de tipoImovel na view
		// por padrao o nome da lista sera tipoImovelList
		return Arrays.asList(TipoImovel.values());
	}

}
