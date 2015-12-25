package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class ModeloCarroDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void salvar(ModeloCarro modeloCarro) {
		manager.merge(modeloCarro);
	}

	@SuppressWarnings("unchecked")
	public List<ModeloCarro> buscarTodos() {
		return manager.createQuery("from ModeloCarro").getResultList();
	}

	@Transactional
	public void excluir(ModeloCarro modeloCarroSelecionado) throws NegocioException {
		modeloCarroSelecionado = buscarPeloCodigo(modeloCarroSelecionado.getCodigo());
		try {
			manager.remove(modeloCarroSelecionado);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Este modelo não pode ser Excluido!");
		}

	}

	public ModeloCarro buscarPeloCodigo(Long codigo) {
		return manager.find(ModeloCarro.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ModeloCarro> buscarComPaginacao(int first, int pageSize) {
		return manager.createQuery("from ModeloCarro")
				.setFirstResult(first)
				.setMaxResults(pageSize)
				.getResultList();
	}

	public Long encontrarQuantidadeDeModeloCarros() {
		return manager.createQuery("select count(m) from ModeloCarro m", Long.class).getSingleResult();
	}

}
