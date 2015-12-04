package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// como não precisamos de regras de negocio para listar ou
	// editar um fabricante, podemos fazer o uso do dao

	@Inject
	private FabricanteDAO fabricanteDAO;
	// lista de fabricante para apresentar
	private List<Fabricante> fabricantes = new ArrayList<>();
	// fabricante a ser seleionado para edicao
	private Fabricante fabricanteSelecionado;

	public void excluir() {
		try {
			fabricanteDAO.excluir(fabricanteSelecionado);
			this.fabricantes.remove(fabricanteSelecionado);
			FacesUtil.addSuccessMessage("Fabricante "
					+ fabricanteSelecionado.getNome()
					+ " excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

	}
	
	//trazendo todos os fabricante no inciado do bean
	@PostConstruct
	public void init(){
		fabricantes = fabricanteDAO.buscarTodos();
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}

	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

}
