package br.com.jkavdev.northwind.database.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import br.com.jkavdev.northwind.database.utils.interfaces.IGenericDao;

public abstract class GenericDao<T extends BaseEntity, ID extends Serializable> implements IGenericDao<T, ID> {

	private final Logger logger = Logger.getLogger(this.getClass());
	private final Class<T> persistentClass;
	private final Session session;

	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];

		this.session = getCurrentSession();

		if (this.logger.isInfoEnabled()) {
			this.logger.info(String.format("Creating a dao to the persistent class [%s]", getPersistentClass()));
		}
	}

	@Override
	public T findById(ID id) {
		return this.getSession().load(this.getPersistentClass(), id);
	}

	@Override
	public List<T> findAll() {
		return this.findByCriteria();
	}

	@Override
	@SuppressWarnings("unchecked")
	public ID save(T entity) {
		// retorna o id da entidade salva,
		// para posteriores necessidades
		beginTransaction();
		Serializable id = this.getSession().save(entity);
		commit();

		return (ID) id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(T entity) {
		entity = (T) this.getSession().merge(entity);

		beginTransaction();
		this.getSession().update(entity);
		commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(T entity) {
		entity = (T) this.getSession().merge(entity);

		beginTransaction();
		this.getSession().delete(entity);
		commit();
	}

	@SuppressWarnings("unchecked")
	protected List<T> executeQuery(String query) {
		try {
			Query queryHql = this.getSession().createQuery(query);

			return queryHql.list();
		} catch (RuntimeException e) {
			this.logger.error(e.getMessage(), e);

			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	private List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = this.getSession().createCriteria(this.getPersistentClass());

		for (Criterion c : criterion) {
			crit.add(c);
		}

		return crit.list();
	}

	private Session getCurrentSession() {
		return HibernateUtility.getSession();
	}

	private void commit() {
		this.getSession().getTransaction().commit();
	}

	private void beginTransaction() {
		this.getSession().beginTransaction();
	}

	public Session getSession() {
		if (this.session == null) {
			this.logger.error("Session not founded.");

			throw new IllegalStateException("Session has not been set on DAO before usage");
		}

		return this.session;
	}

	private Class<T> getPersistentClass() {
		return this.persistentClass;
	}

}
