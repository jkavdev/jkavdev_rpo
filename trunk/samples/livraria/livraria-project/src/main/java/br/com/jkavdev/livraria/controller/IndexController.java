package br.com.jkavdev.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	// @RequestMapping("/login")
	// public String login() {
	//
	// return "login";
	// }

	// Login form with error
	@RequestMapping("/login-error.html")
	public String loginError(Model model) {

		model.addAttribute("loginError", true);

		return "login.html";
	}
}
