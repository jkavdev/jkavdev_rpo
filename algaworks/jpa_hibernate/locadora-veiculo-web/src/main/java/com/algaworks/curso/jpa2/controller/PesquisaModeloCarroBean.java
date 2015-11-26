package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloCarroDAO modeloCarroDAO;
	private ModeloCarro modeloCarroSelecionado;
	private List<ModeloCarro> modelosCarros;

	@PostConstruct
	public void init() {
		this.modelosCarros = this.modeloCarroDAO.buscarTodos();
	}

	public void excluir() {
		try {
			modeloCarroDAO.excluir(modeloCarroSelecionado);
			this.modelosCarros.remove(modeloCarroSelecionado);
			FacesUtil.addSuccessMessage("Modelo "
					+ modeloCarroSelecionado.getDescricao()
					+ " excluido com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public ModeloCarro getModeloCarro() {
		return modeloCarroSelecionado;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarroSelecionado = modeloCarro;
	}

	public List<ModeloCarro> getModelosCarros() {
		return modelosCarros;
	}

}
