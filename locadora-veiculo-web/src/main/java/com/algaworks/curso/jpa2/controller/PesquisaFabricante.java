package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

public class PesquisaFabricante implements Serializable {

	@Inject
	FabricanteDAO fabricanteDAO;

	private List<Fabricante> fabricantes;

	private Fabricante fabricanteSelecionado;

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void excluir() {
//		try {
//			fabricanteDAO.excluir(fabricanteSelecionado);
//			this.fabricantes.remove(fabricanteSelecionado);
//			FacesUtil.addSuccessMessage("Fabricante "
//					+ fabricanteSelecionado.getNome()
//					+ " excluído com Sucesso!");
//		} catch (NegocioException e) {
//			FacesUtil.addErrorMessage(e.getMessage());
//		}
	}
	
	@PostConstruct
	public void init(){
		fabricantes = fabricanteDAO.buscarTodos();
	}

}
