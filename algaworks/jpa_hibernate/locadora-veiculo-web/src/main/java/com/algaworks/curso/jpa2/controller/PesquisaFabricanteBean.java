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
public class PesquisaFabricanteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FabricanteDAO fabricanteDAO;
	private Fabricante fabricanteSelecionado;
	private List<Fabricante> fabricantes = new ArrayList<>();
	
	public List<Fabricante> getFabricantes(){
		return fabricantes;
	}
	
	public void excluir(){
		try {
			fabricanteDAO.excluir(fabricanteSelecionado);
			this.fabricantes.remove(fabricanteSelecionado);
			FacesUtil.addSuccessMessage("Fabricante " + fabricanteSelecionado.getNome() + " Excluido!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}		
	}
	
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
	
	

}
