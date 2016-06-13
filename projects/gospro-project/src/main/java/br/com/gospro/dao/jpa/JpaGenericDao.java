package br.com.gospro.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.gospro.dao.GenericDao;
import br.com.gospro.util.jpa.Transactional;

public class JpaGenericDao<T, ID extends Serializable> implements GenericDao<T, ID> {

	@Inject
	EntityManager manager;
	private Class<T> entidade;

	@SuppressWarnings("unchecked")
	public JpaGenericDao() {
		this.entidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	@Override
	@Transactional
	public void salvar(T entidade) {
		this.manager.merge(entidade);
	}

	@Override
	@Transactional
	public void alterar(T entidade) {
		this.manager.merge(entidade);
	}

	@Override
	@Transactional
	public void remover(T entidade) {
		this.manager.remove(entidade);
	}

	@Override
	public T buscarPorId(ID id) {
		return this.manager.find(entidade, id);
	}

	@Override
	public List<T> buscarTodos() {
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(entidade);
		Root<T> root = criteriaQuery.from(entidade);

		return this.manager.createQuery(criteriaQuery).getResultList();
	}

}
