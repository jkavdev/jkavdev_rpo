package br.com.jkavdev.fj21.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jkavdev.fj21.spring.dao.JdbcTarefaDao;
import br.com.jkavdev.fj21.spring.modelo.Tarefa;

@Controller
public class TarefasController {

	@RequestMapping("novaTarefa")
	private String form() {

		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	private String adiciona(@Valid Tarefa tarefa, BindingResult result) {

		if (result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}

		if (result.hasErrors()) {
			return "tarefa/formulario";
		}

		JdbcTarefaDao tarefaDao = new JdbcTarefaDao();

		tarefaDao.adiciona(tarefa);

		return "tarefa/adicionada";
	}

}
