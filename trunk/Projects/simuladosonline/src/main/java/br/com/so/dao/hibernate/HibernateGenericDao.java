package br.com.so.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.so.dao.interfacesDao.GenericDao;
import br.com.so.util.jsf.FacesUtil;

public class HibernateGenericDao<T, ID extends Serializable> implements GenericDao<T, ID> {

	@Inject
	private EntityManager manager;
	private Class<T> entidade;

	@SuppressWarnings("unchecked")
	public HibernateGenericDao() {
		this.entidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	@Override
	public void salvar(T entidade) {
		try {
			this.manager.getTransaction().begin();
			this.manager.merge(entidade);
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("Erro encontrado, entre em contato com o suporte ou tente novamente mais tarde.");
		}
	}

	@Override
	public void alterar(T entidade) {
		this.manager.merge(entidade);
	}

	@Override
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
		List<T> resultList = this.manager.createQuery(criteriaQuery).getResultList();
		this.manager.clear();
		return resultList;
	}

	public EntityManager getManager() {
		return manager;
	}

}
