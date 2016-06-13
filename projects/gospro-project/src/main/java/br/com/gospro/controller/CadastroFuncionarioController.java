package br.com.gospro.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gospro.model.Funcionario;
import br.com.gospro.model.Sexo;
import br.com.gospro.service.FuncionarioService;
import br.com.gospro.service.NegocioException;
import br.com.gospro.util.datas.DateUtil;
import br.com.gospro.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFuncionarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioService funcionarioService;
	@Inject
	private Funcionario funcionario;
	private List<Sexo> sexos;
	private String data;

	@PostConstruct
	public void init() {
		sexos = Arrays.asList(Sexo.values());
	}

	public void salvar() {
		try {
			if (data != null) {
				funcionario.setDataNascimento(DateUtil.getCalendarByString(data));
				funcionarioService.salvar(funcionario);
				FacesUtil.addSuccessMessage("Funcionario: " + funcionario.getNome() + " salvo com Sucesso");
			}else{
				FacesUtil.addErrorMessage("Data de Nascimento obrigatorio!");
			}
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		funcionario = new Funcionario();
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
