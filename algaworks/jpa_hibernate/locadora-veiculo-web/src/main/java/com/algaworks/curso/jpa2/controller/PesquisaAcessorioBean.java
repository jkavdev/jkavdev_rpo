package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.AcessorioDAO;
import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.modelolazy.LazyAcessorioDataModelo;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAcessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AcessorioDAO acessorioDAO;
	private List<Acessorio> acessorios;
	//lista carregada de acordo com a pagina
	private LazyAcessorioDataModelo lazyAcessorio;
	private Acessorio acessorioSelecionado;

	public void excluir() {
		try {
			acessorioDAO.excluir(acessorioSelecionado);
			acessorios.remove(acessorioSelecionado);
			FacesUtil.addSuccessMessage("Acessorio " + acessorioSelecionado.getDescricao() + " excluido com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void init() {
		//inicializando a lista
		//passando acessoriodao por parametro
		lazyAcessorio = new LazyAcessorioDataModelo(acessorioDAO);
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public Acessorio getAcessorioSelecionado() {
		return acessorioSelecionado;
	}

	public void setAcessorioSelecionado(Acessorio acessorioSelecionado) {
		this.acessorioSelecionado = acessorioSelecionado;
	}

	public LazyAcessorioDataModelo getLazyAcessorio() {
		return lazyAcessorio;
	}

}
