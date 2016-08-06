package br.com.jkavdev.wpattern.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping("/controller")
	public ModelAndView hello(){
		
		String message = "Spring MVC 4.0";
		
		return new ModelAndView(
				"hello/view",		//qual o nome da view que sera redirecionado 
				"message", 			//definindo o nome de uma variavel para acesso na view
				message);			//definindo o que contera na variavel
		
	}

}
