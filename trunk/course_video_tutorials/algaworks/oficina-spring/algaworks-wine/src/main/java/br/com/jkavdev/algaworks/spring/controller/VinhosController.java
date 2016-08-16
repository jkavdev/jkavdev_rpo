package br.com.jkavdev.algaworks.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.jkavdev.algaworks.spring.model.TipoVinho;
import br.com.jkavdev.algaworks.spring.model.Vinho;
import br.com.jkavdev.algaworks.spring.repository.Vinhos;
import br.com.jkavdev.algaworks.spring.service.CadastroVinhoService;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@Autowired
	private Vinhos vinhos;
	@Autowired
	private CadastroVinhoService cadastroVinhoService;

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
	// adicionando vinho para a pagina de cadastro
	public ModelAndView novo(Vinho vinho) {
		ModelAndView modelAndView = new ModelAndView("/vinho/cadastro-vinho");
		modelAndView.addObject("tipos", TipoVinho.values());

		return modelAndView;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Vinho vinho, BindingResult result, RedirectAttributes attributes) {

		// se ocorrer algum erro, chamara metodo novo
		// passando o objeto com os atribtuos já preenchidos
		if (result.hasErrors()) {
			return novo(vinho);
		}

		cadastroVinhoService.salvar(vinho);
		
		//adicionando mensagem durante o redirect
		attributes.addFlashAttribute("mensagem", "Vinho salvo " + vinho.getNome() + " com sucesso!");

		// realizando refresh na pagina
		return new ModelAndView("redirect:/vinhos/novo");
	}
	
	@RequestMapping(value = "/{codigo}")
	public ModelAndView visualizar(@PathVariable Long codigo){
		
		ModelAndView modelAndView = new ModelAndView("/vinho/visualizacao-vinho");
		
		Vinho vinho = vinhos.findOne(codigo);
		
		return modelAndView.addObject("vinho", vinho);
		
	}
}
