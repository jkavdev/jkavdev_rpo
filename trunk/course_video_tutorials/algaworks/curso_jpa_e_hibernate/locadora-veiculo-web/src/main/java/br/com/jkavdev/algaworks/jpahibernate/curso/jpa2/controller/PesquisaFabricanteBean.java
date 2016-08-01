package br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.dao.FabricanteDao;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.model.Fabricante;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteDao fabricanteDao;
	private List<Fabricante> fabricantes = new ArrayList<>();
	private Fabricante fabricanteSelecionado;

	// inicia buscando todos os fabricantes
	@PostConstruct
	public void init() {
		fabricantes = fabricanteDao.buscarTodos();
	}

	public void excluir() {
		try {
			fabricanteDao.excluir(fabricanteSelecionado);
			this.fabricantes.remove(fabricanteSelecionado);
			FacesUtil.addSuccessMessage("Fabricante " + fabricanteSelecionado.getNome() + " removido com sucesso");

		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}

	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}

}
