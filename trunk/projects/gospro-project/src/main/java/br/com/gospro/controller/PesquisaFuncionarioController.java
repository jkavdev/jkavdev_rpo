package br.com.gospro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gospro.model.Funcionario;
import br.com.gospro.service.FuncionarioService;

@Named
@ViewScoped
public class PesquisaFuncionarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FuncionarioService funcionarioService;
	private List<Funcionario> funcionarios;
	private Funcionario funcionarioSelecionado;

	public void init() {
		funcionarios = funcionarioService.buscarTodos();
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

}
