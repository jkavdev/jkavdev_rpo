package br.com.jkavdev.models.dpj.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.jkavdev.models.dpj.dao.GenericDao;
import br.com.jkavdev.models.dpj.util.jpa.JpaUtil;

public class JpaGenericDao<T, ID extends Serializable> implements GenericDao<T, ID> {

	private EntityManager manager = JpaUtil.geEntityManager();
	private Class<T> entidade;

	@SuppressWarnings("unchecked")
	public JpaGenericDao() {
		this.entidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	@Override
	public void salvar(T entidade) {
		beginTransaction();

		this.manager.merge(entidade);

		commit();
	}

	@Override
	public void alterar(T entidade) {
		beginTransaction();

		this.manager.merge(entidade);

		commit();
	}

	@Override
	public void remover(T entidade) {
		beginTransaction();

		this.manager.remove(entidade);
		this.manager.flush();

		commit();
	}

	@Override
	public T buscarPorId(ID id) {
		return this.manager.find(entidade, id);
	}

	@SuppressWarnings("unused")
	@Override
	public List<T> buscarTodos() {
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(entidade);
		Root<T> root = criteriaQuery.from(entidade);

		return this.manager.createQuery(criteriaQuery).getResultList();
	}

	public void beginTransaction() {
		this.manager.getTransaction().begin();
	}

	public void commit() {
		this.manager.getTransaction().commit();
	}

	public EntityManager getManager() {
		return manager;
	}

}
