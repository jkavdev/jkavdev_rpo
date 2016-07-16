package com.packtpub.springsecurity.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefautlController {

	// contralara o fluxo depois do login
	@RequestMapping("/default")
	public String defaultAfterLogin(HttpServletRequest request) {

		// redirecionara para pasta events, caso o usuario admin
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/events/";
		}

		// para o root contexto da aplicacao, caso usuario qualquer
		return "redirect:/";

	}

}
