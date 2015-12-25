package com.algaworks.curso.jpa2.modelolazy;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.algaworks.curso.jpa2.dao.AcessorioDAO;
import com.algaworks.curso.jpa2.modelo.Acessorio;

@ManagedBean
public class LazyAcessorioDataModelo extends LazyDataModel<Acessorio> implements Serializable {

	private static final long serialVersionUID = 1L;

	private AcessorioDAO acessorioDAO;

	public LazyAcessorioDataModelo(AcessorioDAO acessorioDAO) {
		this.acessorioDAO = acessorioDAO;
	}

	@Override
	// first - quantidade de linhas a serem inicializadas
	// pagesize - quantidade de registros do banco
	public List<Acessorio> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
		// passando por parametro a onde sera inicializado a busca
		// e quantidade de registros a serem retornados
		List<Acessorio> acessorios = this.acessorioDAO.buscarComPaginacao(first, pageSize);

		// informando a quantidade de registros total do banco
		this.setRowCount(this.acessorioDAO.encontrarQuantidadeDeCarros().intValue());

		return acessorios;
	}

}
