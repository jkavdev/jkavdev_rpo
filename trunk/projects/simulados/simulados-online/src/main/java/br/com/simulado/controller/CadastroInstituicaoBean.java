package br.com.simulado.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.simulado.modelo.Instituicao;
import br.com.simulado.service.CadastroInstituicaoService;
import br.com.simulado.service.NegocioException;

@Named
@RequestScoped
public class CadastroInstituicaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroInstituicaoService instituicaoService;
	private Instituicao instituicao;

	@PostConstruct
	public void init() {
		instituicao = new Instituicao();
	}

	public void salvar() {

		try {
			if (instituicaoService != null || instituicao != null) {
				this.instituicaoService.salvar(instituicao);
				System.out.println(instituicao.getNome() + " salva com Sucesso!");
			}
		} catch (NegocioException e) {
			e.printStackTrace();
		}

	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
