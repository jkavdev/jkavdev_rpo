package br.com.jkavdev.caelum.fj21.spring.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jkavdev.caelum.fj21.spring.jdbc.DaoException;
import br.com.jkavdev.caelum.fj21.spring.jdbc.JdbcTarefaDao;
import br.com.jkavdev.caelum.fj21.spring.model.Tarefa;

@Controller
public class TarefasController {

	private static final Logger logger = Logger.getLogger(TarefasController.class);

	@RequestMapping("novaTarefa")
	public String form() {

		logger.info("Formulário de cadastro de tarefas");
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {

		// if (result.hasFieldErrors("descricao")) {
		if (tarefa.getDescricao() == null || tarefa.getDescricao().equals("")) {
			return form();
		}

		tarefa.setDataFinalizacao(Calendar.getInstance());

		JdbcTarefaDao tarefaDao = new JdbcTarefaDao();

		try {
			tarefaDao.insert(tarefa);
		} catch (DaoException e) {
			logger.error("Tarefa não cadastrada", e);
		}

		logger.info("Tarefa: " + tarefa.getDescricao() + " adicionada");
		return "tarefa/tarefa-adicionada";
	}

	// @RequestMapping("listaTarefas")
	// public ModelAndView lista(){
	//
	// JdbcTarefaDao tarefaDao = new JdbcTarefaDao();
	// List<Tarefa> tarefas = new ArrayList<>();
	//
	// try {
	// tarefas = tarefaDao.getFindAll();
	// } catch (DaoException e) {
	// logger.error("Tarefas não encontradas", e);
	// }
	//
	// ModelAndView view = new ModelAndView("tarefa/lista");
	// view.addObject("tarefas", tarefas);
	//
	// return view;
	// }

	@RequestMapping("listaTarefas")
	public String lista(Model model) {

		JdbcTarefaDao tarefaDao = new JdbcTarefaDao();
		List<Tarefa> tarefas = new ArrayList<>();

		try {
			tarefas = tarefaDao.getFindAll();
		} catch (DaoException e) {
			logger.error("Tarefas não encontradas", e);
		}

		model.addAttribute("tarefas", tarefas);

		return "tarefa/lista";
	}

}
