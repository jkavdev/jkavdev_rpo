package br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.dao.FabricanteDao;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.model.Fabricante;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.model.ModeloCarro;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.service.ModeloCarroService;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.service.NegocioException;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloCarroService modeloService;
	@Inject
	private FabricanteDao fabricanteDao;
	private ModeloCarro modelo;
	private List<Fabricante> fabricantes;

	@PostConstruct
	public void init() {
		this.limpar();
		//buscando fabricantes cadastrados
		this.fabricantes = this.fabricanteDao.buscarTodos();
	}

	public void salvar() {
		try {
			this.modeloService.salvar(modelo);

			FacesUtil.addSuccessMessage("Modelo " + modelo.getDescricao() + " salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}

		this.limpar();
	}

	private void limpar() {
		modelo = new ModeloCarro();
	}

	public ModeloCarro getModelo() {
		return modelo;
	}

	public void setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

}
