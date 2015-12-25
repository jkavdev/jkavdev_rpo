package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Funcionario;
import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class FuncionarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Funcionario buscarPeloCodigo(Long codigo) {
		return manager.find(Funcionario.class, codigo);
	}

	public void salvar(Funcionario funcionario) {
		manager.merge(funcionario);
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarTodos() {
		return manager.createQuery("from Funcionario").getResultList();
	}

	@Transactional
	public void excluir(Funcionario funcionarioSelecionado) throws NegocioException {
		funcionarioSelecionado = buscarPeloCodigo(funcionarioSelecionado.getCodigo());
		try {
			manager.remove(funcionarioSelecionado);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Funcionario nao pode ser excluido!");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarComPaginacao(int first, int pageSize) {
		return manager.createQuery("from Funcionario")
				.setFirstResult(first)
				.setMaxResults(pageSize)
				.getResultList();
	}

	public Long encontrarQuantidadeDeFuncionarios() {
		return manager.createQuery("select count(f) from Funcionario f", Long.class).getSingleResult();
	}

}
