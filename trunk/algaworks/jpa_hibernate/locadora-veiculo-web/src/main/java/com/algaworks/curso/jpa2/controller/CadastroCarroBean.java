package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.AcessorioDAO;
import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.service.CadastroCarroService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroCarroService cadastroCarroService;
	@Inject
	private ModeloCarroDAO modeloCarroDAO;
	@Inject
	private AcessorioDAO acessorioDAO;
	private Carro carro;
	private List<Acessorio> acessorios;
	private List<ModeloCarro> modelosCarro;

	public void salvar() {
		try {
			cadastroCarroService.salvar(carro);
			FacesUtil.addSuccessMessage("Carro " + carro.getPlaca() + " salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		} catch (Exception e) {
			FacesUtil.addErrorMessage("Erro desconhecido. Contatar o administrador : " + e.getMessage());
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
		this.acessorios = this.acessorioDAO.buscarTodos();
		this.modelosCarro = this.modeloCarroDAO.buscarTodos();
	}

	private void limpar() {
		this.carro = new Carro();
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public List<ModeloCarro> getModelosCarro() {
		return modelosCarro;
	}

	public void setModelosCarro(List<ModeloCarro> modelosCarro) {
		this.modelosCarro = modelosCarro;
	}

}
