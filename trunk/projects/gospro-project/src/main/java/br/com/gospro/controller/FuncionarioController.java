package br.com.gospro.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gospro.dao.IFuncionarioDao;
import br.com.gospro.model.Funcionario;
import br.com.gospro.util.jsf.FacesUtil;

@Named
@ViewScoped
public class FuncionarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	IFuncionarioDao funcionarioDao;
	private Funcionario funcionario;

	@PostConstruct
	public void init() {
		this.limpar();
	}

	public void salvar() {
		if (funcionario != null) {
			funcionarioDao.salvar(funcionario);
			FacesUtil.addSuccessMessage("Funcionario: " + funcionario.getNome() + " salvo com Sucesso");
		} else {
			FacesUtil.addErrorMessage("Funcionario não salvo");
		}

		this.limpar();
	}

	private void limpar() {
		funcionario = new Funcionario();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
