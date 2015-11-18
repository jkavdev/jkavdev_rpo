package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
//gerenciador de dados
//visao com a logica

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.CadastroFabricanteService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
// enquanto estiver na mesma tela
// sera criada apenas um instancia do objeto
@ViewScoped
public class CadastroFabricanteBean implements Serializable {

	@Inject
	private CadastroFabricanteService cadastroFabricanteService;

	private Fabricante fabricante;

	// metodo que o jsf chamara
	public void salvar() {
		try {
			this.cadastroFabricanteService.salvar(fabricante);
			// mensagem de sucesso
			FacesUtil.addSuccessMessage("Fabricante salvo com Sucesso!");
			this.limpar();
		} catch (NegocioException e) {
			// mensagem de erro
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	// toda vez que for criado o bean,
	// este metodo sera chamado
	@PostConstruct
	public void init() {
		this.limpar();
	}

	public void limpar() {
		// limpamos os formularios criando um nova instancia do objeto
		// fabricante
		this.fabricante = new Fabricante();
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

}
