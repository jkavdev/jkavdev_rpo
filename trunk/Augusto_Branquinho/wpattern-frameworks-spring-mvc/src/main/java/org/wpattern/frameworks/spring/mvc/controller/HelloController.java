package org.wpattern.frameworks.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//indicando que esta classe eh um controller
@Controller
//indicando qual o metodo de acesso na url
//http://localhost:8080/hello
@RequestMapping("/hello")
public class HelloController {

	//outro mapeamento
	//http://localhost:8080/hello/controller.html
	@RequestMapping("/controller")
	public ModelAndView hello() {
		String message = "Welcome to Spring MVC 4";

		//qual view sera chamada, qual pagina. Apenas o caminho e seu nome, no caso sera view
		//estamos passando uma string para a view com message
		//"message" eh como a view tera acesso a esta variavel
		return new ModelAndView("/hello/view", "message", message);
	}

}
