package br.com.gospro.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gospro.model.Funcionario;
import br.com.gospro.model.Sexo;
import br.com.gospro.service.FuncionarioService;
import br.com.gospro.service.NegocioException;
import br.com.gospro.util.jsf.FacesUtil;

@Named
@ViewScoped
public class FuncionarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioService funcionarioService;
	private Funcionario funcionario;
	private Funcionario funcionarioSelecionado;
	private List<Funcionario> funcionarios;
	private List<Sexo> sexos;

	@PostConstruct
	public void init() {
		this.limpar();
		// funcionarios = funcionarioService.buscarTodos();
		sexos = Arrays.asList(Sexo.values());
	}

	public void salvar() {
		try {
			funcionarioService.salvar(funcionario);
			FacesUtil.addSuccessMessage("Funcionario: " + funcionario.getNome() + " salvo com Sucesso");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Funcionario não salvo");
		}

		this.limpar();
	}

	public void excluir() {
		try {
			funcionarioService.excluir(funcionarioSelecionado);
			funcionarios.remove(funcionarioSelecionado);
			FacesUtil.addSuccessMessage("Funcionario: " + funcionario.getNome() + " removido com Sucesso");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

	}

	private void limpar() {
		if (funcionario == null) {
			funcionario = new Funcionario();
		}
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public List<Sexo> getSexos() {
		return sexos;
	}

}
