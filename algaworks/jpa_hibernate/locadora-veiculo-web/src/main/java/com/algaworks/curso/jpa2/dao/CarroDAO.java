package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CarroDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void salvar(Carro carro) {
		manager.merge(carro);
	}

	@SuppressWarnings("unchecked")
	public List<Carro> buscarTodos() {
		return manager.createQuery("from Carro").getResultList();
	}

	@Transactional
	public void excluir(Carro carroSelecionado) throws NegocioException {
		carroSelecionado = buscarPeloCodigo(carroSelecionado.getCodigo());
		try {
			manager.remove(carroSelecionado);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Este carro não pode ser Excluido!");
		}

	}

	public Carro buscarPeloCodigo(Long codigo) {
		return manager.find(Carro.class, codigo);
	}

}
