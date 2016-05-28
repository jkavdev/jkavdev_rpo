package br.com.simulados.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.simulados.modelo.Instituicao;
import br.com.simulados.service.InstituicaoService;
import br.com.simulados.service.NegocioException;
import br.com.simulados.util.jsf.FacesUtil;

@Named
@ViewScoped
public class InstituicaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private InstituicaoService instituicaoService;
	private Instituicao instituicao;

	@PostConstruct
	public void init() {
		//limpando formulario quando iniciar a tela
		this.limpar();
	}

	private void limpar() {
		//limpar dados do formulario
		instituicao = new Instituicao();
	}

	public void salvar() {
		try {
			instituicaoService.salvar(instituicao);
			FacesUtil.addSuccessMessage("Todos os campos devem ser preenchidos!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
