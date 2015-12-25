package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Acessorio;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AcessorioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void salvar(Acessorio acessorio) {
		manager.merge(acessorio);
	}

	@SuppressWarnings("unchecked")
	public List<Acessorio> buscarTodos() {
		return manager.createQuery("from Acessorio").getResultList();
	}

	@Transactional
	public void excluir(Acessorio acessorioSelecionado) throws NegocioException {
		acessorioSelecionado = buscarPeloCodigo(acessorioSelecionado.getCodigo());
		try {
			manager.remove(acessorioSelecionado);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Este acessorio não pode ser Excluido!");
		}

	}

	public Acessorio buscarPeloCodigo(Long codigo) {
		return manager.find(Acessorio.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Acessorio> buscarComPaginacao(int first, int pageSize) {
		//informando da onde sera iniciado a pesquisa e 
		//quantidade de registros a serem retornados
		return manager.createQuery("from Acessorio")
				.setFirstResult(first)
				.setMaxResults(pageSize)
				.getResultList();
	}

	public Long encontrarQuantidadeDeCarros() {
		//busca a quantidade de acessorios
		//devolve um long e apenas um resultado
		//para pesquisa no banco
		return manager.createQuery("select count(a) from Acessorio a", Long.class).getSingleResult();
	}

}
