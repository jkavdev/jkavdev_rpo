package br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.model.Fabricante;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.service.FabricanteService;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.service.NegocioException;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteService fabricanteService;
	private Fabricante fabricante;

	@PostConstruct
	public void init() {
		this.limpar();
	}

	public void salvar() {
		try {
			fabricanteService.salvar(fabricante);

			FacesUtil.addSuccessMessage("Fabricante " + fabricante.getNome() + " salvo com sucesso");
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	// limpa formulário
	private void limpar() {
		this.fabricante = new Fabricante();
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

}
