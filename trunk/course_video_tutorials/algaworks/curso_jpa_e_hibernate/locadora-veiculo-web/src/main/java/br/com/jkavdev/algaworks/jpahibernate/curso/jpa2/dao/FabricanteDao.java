package br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.model.Fabricante;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.service.NegocioException;
import br.com.jkavdev.algaworks.jpahibernate.curso.jpa2.util.jpa.Transactional;

public class FabricanteDao implements Serializable {

	private static final long serialVersionUID = 1L;

	// informando que o manager será injetado
	@Inject
	private EntityManager manager;

	public void salvar(Fabricante fabricante) {
		manager.persist(fabricante);
	}

	@Transactional
	public void excluir(Fabricante fabricanteSelecionado) throws NegocioException {
		// ligando novamente a entidade ao registro do banco
		fabricanteSelecionado = this.manager.find(Fabricante.class, fabricanteSelecionado.getCodigo());

		this.manager.remove(fabricanteSelecionado);
		this.manager.flush();
	}

	public List<Fabricante> buscarTodos() {
		return manager.createQuery("from Fabricante", Fabricante.class)
				.getResultList();
	}

}
