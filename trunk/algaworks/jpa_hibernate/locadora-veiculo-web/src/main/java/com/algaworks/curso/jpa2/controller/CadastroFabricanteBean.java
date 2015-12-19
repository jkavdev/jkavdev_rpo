package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.CadastroFabricanteService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroFabricanteService cadastroFabricanteService;
	private Fabricante fabricante;
	
	//salvando fabricante
	public void salvar(){
		try {
			//cadastra fabricante preenchido da tela
			cadastroFabricanteService.salvar(fabricante);
			FacesUtil.addSuccessMessage("Fabricante "+ fabricante.getNome() + " salvo com Sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		this.limpar();
	}

	// logo que o bean for iniciado
	@PostConstruct
	public void init() {
		this.limpar();
	}

	// limpando o formulario, criando um novo fabricante
	private void limpar() {
		this.fabricante = new Fabricante();
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

}
