package br.com.gospro.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gospro.dao.IFuncionarioDao;
import br.com.gospro.model.Funcionario;
import br.com.gospro.model.Sexo;
import br.com.gospro.util.jsf.FacesUtil;

@Named
@ViewScoped
public class FuncionarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IFuncionarioDao funcionarioDao;
	private Funcionario funcionario;
	private List<Sexo> sexos;

	@PostConstruct
	public void init() {
		this.limpar();
		sexos = Arrays.asList(Sexo.values());
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
		funcionario.setDataNascimento(Calendar.getInstance());
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Sexo> getSexos() {
		return sexos;
	}

}
