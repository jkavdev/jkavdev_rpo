package br.com.jkavdev.caelum.fj21.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jkavdev.caelum.fj21.spring.jdbc.DaoException;
import br.com.jkavdev.caelum.fj21.spring.jdbc.JdbcTarefaDao;
import br.com.jkavdev.caelum.fj21.spring.model.Tarefa;

@Controller
public class TarefasController {

	private static final Logger logger = Logger.getLogger(TarefasController.class);

	@RequestMapping("novaTarefa")
	public String form() {

		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(Tarefa tarefa) {

		JdbcTarefaDao tarefaDao = new JdbcTarefaDao(null);
		try {
			tarefaDao.insert(tarefa);
		} catch (DaoException e) {
			logger.error("Tarefa não cadastrada", e);
		}

		return "tarefa/adicionada";
	}

}
