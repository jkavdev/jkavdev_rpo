package br.com.gospro.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gospro.model.Funcionario;
import br.com.gospro.service.FuncionarioService;
import br.com.gospro.service.NegocioException;
import br.com.gospro.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFuncionarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioService funcionarioService;
	private List<Funcionario> funcionarios;
	private Funcionario funcionarioSelecionado;

	@PostConstruct
	public void init() {
		funcionarios = funcionarioService.buscarTodos();
	}

	public void excluir() {
		try {
			funcionarioService.excluir(funcionarioSelecionado);
			funcionarios.remove(funcionarioSelecionado);
			FacesUtil.addSuccessMessage("Funcionário " + funcionarioSelecionado.getNome() + " excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
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
