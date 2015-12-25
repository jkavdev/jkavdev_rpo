package com.algaworks.curso.jpa2.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.modelolazy.LazyModeloCarroDataModel;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

import java.util.List;
import java.io.Serializable;

@Named
@ViewScoped
public class PesquisaModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloCarroDAO modeloCarroDAO;
	private List<ModeloCarro> modelosCarro;
	private ModeloCarro modeloCarroSelecionado;
	private LazyModeloCarroDataModel lazyModeloCarro;

	@PostConstruct
	public void init() {
		lazyModeloCarro = new LazyModeloCarroDataModel(modeloCarroDAO);
	}

	public void excluir() {
		try {
			modeloCarroDAO.excluir(modeloCarroSelecionado);
			modelosCarro.remove(modeloCarroSelecionado);
			FacesUtil.addSuccessMessage("Modelo " + modeloCarroSelecionado.getDescricao() + " excluido com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public List<ModeloCarro> getModelosCarro() {
		return modelosCarro;
	}

	public void setModelosCarro(List<ModeloCarro> modelosCarro) {
		this.modelosCarro = modelosCarro;
	}

	public ModeloCarro getModeloCarroSelecionado() {
		return modeloCarroSelecionado;
	}

	public void setModeloCarroSelecionado(ModeloCarro modeloCarroSelecionado) {
		this.modeloCarroSelecionado = modeloCarroSelecionado;
	}

	public LazyModeloCarroDataModel getLazyModeloCarro() {
		return lazyModeloCarro;
	}

}
