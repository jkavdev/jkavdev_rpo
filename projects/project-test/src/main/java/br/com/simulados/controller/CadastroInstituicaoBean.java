package br.com.simulados.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.simulados.modelo.Instituicao;
import br.com.simulados.service.CadastroInstituicaoService;
import br.com.simulados.service.NegocioException;
import br.com.simulados.util.FacesUtil;

@ManagedBean
@ViewScoped
public class CadastroInstituicaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private CadastroInstituicaoService instituicaoService;
	private Instituicao instituicao;
	
	public CadastroInstituicaoBean() {
		instituicaoService = new CadastroInstituicaoService();
		this.limpar();
	}

	private void limpar() {
		instituicao = new Instituicao();
	}

	public void salvar() {
		try {
			this.instituicaoService.salvar(instituicao);
			FacesUtil.addSuccessMessage("Instituição " + instituicao.getNome() + " salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public CadastroInstituicaoService getInstituicaoService() {
		return instituicaoService;
	}

	public void setInstituicaoService(CadastroInstituicaoService instituicaoService) {
		this.instituicaoService = instituicaoService;
	}

}
