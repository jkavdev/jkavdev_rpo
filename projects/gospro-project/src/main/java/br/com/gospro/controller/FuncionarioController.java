package br.com.gospro.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.gospro.dao.IFuncionarioDao;
import br.com.gospro.dao.hibernate.HibernateFuncionarioDao;
import br.com.gospro.model.Funcionario;
import br.com.gospro.util.jsf.FacesUtil;

@ManagedBean
@RequestScoped
public class FuncionarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	IFuncionarioDao funcionarioDao = new HibernateFuncionarioDao();
	private Funcionario funcionario = new Funcionario();

	public FuncionarioController() {
		funcionario = new Funcionario();
	}

	public void salvar() {
		if (funcionario != null) {
			funcionarioDao.salvar(funcionario);
			FacesUtil.addSuccessMessage("Funcionario: " + funcionario.getNome() + " salvo com Sucesso");
		} else {
			FacesUtil.addErrorMessage("Funcionario não salvo");
		}
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
